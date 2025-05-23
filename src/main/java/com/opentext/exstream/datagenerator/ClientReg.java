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
///```
///
/// Content example:
///
/// ```
/// C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999";06082021;05092021;"33.799,01";"CAIXESBBXXX"
///```
public class ClientReg extends AbstractRegistry {
    private static final char[] letters = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    // titular
    private final String holder;
    // identificador: "01568/00"
    private final String id;
    // combinacion
    private final String combination;
    // verInterna
    private final String internalVer;
    // verVisible
    private final String visibleVer;
    // agreements
    private final String agreements;
    // division
    private final String division;
    // caducidad
    private final String expiry;
    // anyo
    private final int year;
    // lote
    private final String lot;
    // hoja
    private final String sheet;
    // iban
    private final String iban;
    // periodoInicial
    private final String initialPeriod;
    // periodoFinal
    private final String endPeriod;
    // saldo
    private float balance;
    // swift
    private final String swift;


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
        balance = RandomUtil.getRandomFloat(25000f, 99999f);
        swift = BankUtil.getRandomSwift();
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    //identificador: "01568/00"
    protected String getRandomId() {
        int id1 = RandomUtil.getRandomInt(1, 99999);
        int id2 = RandomUtil.getRandomInt(1, 99);

        return asFixLengthLeftZeroPadding(id1, 5) + "/" + asFixLengthLeftZeroPadding(id2, 2);
    }

    //Combination: "Com. G-00007, Sub. 001, Emp. 001, Id. 002"
    protected String getRandomCombination() {
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
    protected String getRandomAgreements() {
        return asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3) +
                "-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
    }

    // Expiry: CCOD124
    protected String getRandomExpiry() {
        int numLetters = letters.length - 1;
        return Character.toString(letters[RandomUtil.getRandomInt(0, numLetters)]) +
                letters[RandomUtil.getRandomInt(0, numLetters)] +
                letters[RandomUtil.getRandomInt(0, numLetters)] +
                letters[RandomUtil.getRandomInt(0, numLetters)] +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 999), 3);
    }

    // Lot: "20210906-00129-0000769"
    protected String getRandomLot() {
        return DateUtil.getExstreamDateNDaysAgo(RandomUtil.getRandomInt(0, 90)) +
                "-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 99999), 5) +
                "-" +
                asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(1, 9999999), 7);
    }

    public String getHolder() {
        return holder;
    }

    @Override
    public String toRegistry() {
        // C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
        return regType.toString() + DELIMITER +
                holder + DELIMITER +
                id + DELIMITER +
                combination + DELIMITER +
                internalVer + DELIMITER +
                visibleVer + DELIMITER +
                agreements + DELIMITER +
                division + DELIMITER +
                expiry + DELIMITER +
                year + DELIMITER +
                lot + DELIMITER +
                sheet + DELIMITER +
                iban + DELIMITER +
                initialPeriod + DELIMITER +
                endPeriod + DELIMITER +
                asAmount(balance) + DELIMITER +
                swift;
    }
}
