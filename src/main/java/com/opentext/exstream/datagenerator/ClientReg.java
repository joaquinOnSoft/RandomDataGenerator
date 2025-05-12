package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

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
/// C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
/// ```
public class ClientReg extends AbstractRegistry{
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
    private String initialPrice;
    // periodoFinal
    private String endPrice;
    // saldo
    private float balance;
    // swift
    private String swift;


    public ClientReg() {
        super(RegistryType.CLIENT);
        holder = ClientManager.getRandomClient().toString();
    }

    //identificador: "01568/00"
    protected String getRandomId(){
        int id1 = RandomUtil.getRandomInt(1, 99999);
        int id2 = RandomUtil.getRandomInt(1, 99);

        return asFixLengthLeftZeroPadding(id1, 5) + "/" + asFixLengthLeftZeroPadding(id2, 2);
    }

    @Override
    public String toRegistry() {
        // C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
        return regType.toString() + DELIMITER +
                asString(holder) + DELIMITER +
                asString(id) + DELIMITER;
    }
}
