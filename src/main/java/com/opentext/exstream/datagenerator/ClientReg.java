package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.BankUtil;
import com.opentext.exstream.util.DateUtil;
import com.opentext.exstream.util.RandomUtil;

import java.time.Year;

/// Registry type: Client
///
/// Field definition:
///
/// ```
/// C;titular;identificador;combinacion;verInterna;verVisible;agreements;division;caducidad;anyo;lote;hoja;iban;periodoInicial;periodoFinal;saldo;swift
/// ```
///
/// Content example:
///
/// ```
/// C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999";06082021;05092021;"33.799,01";"CAIXESBBXXX"
/// ```
public class ClientReg extends AbstractRegistry{
    private static final char[] letters = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    // titular
    private String holder;
    // identificador: "01568/00"
    private String id;
    // combinacion
    private String combination;
    // verInterna
    private String internalVer;
    // verVisible
    private String visibleVer;
    // agreements
    private String agreements;
    // division
    private String division;
    // caducidad
    private String expiry;
    // anyo
    private int year;
    // lote
    private String lot;
    // hoja
    private String sheet;
    // iban
    private String iban;
    // periodoInicial
    private String initialPeriod;
    // periodoFinal
    private String endPeriod;
    // saldo
    private float balance;
    // swift
    private String swift;


    public ClientReg() {
        super(RegistryType.CLIENT);
        holder = ClientManager.getRandomClient().toString();
        id = getRandomId();
        combination = getRandomCombination();
        internalVer = asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
        visibleVer = asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
        agreements = getRandomAgreements();
        division = asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
        expiry = getRandomExpiry();
        year = Year.now().getValue();
        lot = getRandomLot();
        sheet = asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
        iban = BankUtil.getRandomIban();
        initialPeriod = DateUtil.nowToExstreamDate();
        endPeriod = DateUtil.getExstreamDateNDaysAgo(30);
        balance = RandomUtil.getRandomFloat(5000f, 99999f);
        swift = BankUtil.getRandomSwift();
    }

    //identificador: "01568/00"
    protected String getRandomId(){
        int id1 = RandomUtil.getRandomInt(1, 99999);
        int id2 = RandomUtil.getRandomInt(1, 99);

        return asFixLengthLeftZeroPadding(id1, 5) + "/" + asFixLengthLeftZeroPadding(id2, 2);
    }

    //Combination: "Com. G-00007, Sub. 001, Emp. 001, Id. 002"
    protected String getRandomCombination(){
        return "Com. G-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 99999), 5) +
                ", Sub." +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3) +
                ", Emp. " +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3) +
                ", Id. " +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
    }

    // Agreements: "001-005"
    protected String getRandomAgreements(){
        return asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3) +
                "-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
    }

    // Expiry: CCOD124
    protected String getRandomExpiry(){
        int numLetters = letters.length - 1;
        return Character.toString(letters[RandomUtil.getRandomInt(0, numLetters)]) +
                Character.toString(letters[RandomUtil.getRandomInt(0, numLetters)]) +
                Character.toString(letters[RandomUtil.getRandomInt(0, numLetters)]) +
                Character.toString(letters[RandomUtil.getRandomInt(0, numLetters)]) +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
    }

    // Lot: "20210906-00129-0000769"
    protected String getRandomLot(){
        return DateUtil.getExstreamDateNDaysAgo(RandomUtil.getRandomInt(0, 90)) +
                "-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 99999), 5) +
                "-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 9999999), 7);
    }

    @Override
    public String toRegistry() {
        // C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
        return regType.toString() + DELIMITER +
                asString(holder) + DELIMITER +
                asString(id) + DELIMITER +
                asString(combination) + DELIMITER +
                asString(internalVer) + DELIMITER +
                asString(visibleVer) + DELIMITER +
                asString(agreements) + DELIMITER +
                asString(division)  + DELIMITER +
                asString(expiry) + DELIMITER +
                asString(Integer.toString(year)) + DELIMITER +
                asString(lot)  + DELIMITER +
                asString(sheet) + DELIMITER +
                asString(iban) + DELIMITER +
                initialPeriod  + DELIMITER +
                endPeriod  + DELIMITER +
                asStringAmount(balance)  + DELIMITER +
                asString(swift);
    }
}
