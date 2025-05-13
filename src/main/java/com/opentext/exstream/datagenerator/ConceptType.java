package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

public enum ConceptType {

    FINANCING_ENTITY("ENT.FINANCIACION"),
    DEBIT_CARD("DEBIT CARD"),
    CREDIT_CARD("CREDIT CARD"),
    PENSION("PENSIÓN INSS/ISM"),
    ATM_CASH_WITHDRAWALS("DISPOSICIÓN DE EFECTIVO EN CAJERO");

    private final String type;

    ConceptType(String name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return type;
    }

    public static ConceptType getRandomType() {
        ConceptType type = null;

        int rand = RandomUtil.getRandomInt(1, 100);
        if (rand <= 1) {
            type = PENSION; // 1%
        } else if (rand <= 6) {
            type = FINANCING_ENTITY; // 5%
        } else if (rand <= 66) {
            type = DEBIT_CARD; // 60%
        } else if (rand <= 86) {
            type = CREDIT_CARD; // 20%
        } else if (rand <= 100) {
            type = ATM_CASH_WITHDRAWALS; // 14%
        }

        return type;
    }
}
