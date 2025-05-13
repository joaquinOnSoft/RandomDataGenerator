package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import com.opentext.exstream.util.RandomUtil;

import java.util.Date;

/// Registry type: Detail
///
/// Field definition:
///
/// ```
/// T;fecha;concepto1;concepto2;concepto3;ingreso;cargo;saldo
///```
///
/// Content example:
///
/// ```
/// T;06082021;"ENT.FINANCIACION (05.08.2021)";"06.08.2021 Ref.: RECIBO EMITIDO PO";"Más datos: A99999999000";"0,0";"806,67";"33.320,80"
/// T;07082021;"TARJETA DE DÉBITO";"07.08.2021 Ref.: AUTOSERVICIO gggg";"Más datos: Fecha de operación: 04-08-2021";"0,0";"26,4";"33.294,4"
/// T;07082021;"TARJETA DE DÉBITO";"07.08.2021 Ref.: BBBBBB BB BBB BAR";"Más datos: Fecha de operación: 04-08-2021";"0,0";"26,79";"33.267,61"
///```
public class DetailReg extends AbstractRegistry {
    private final String[] commerce = {
            "PANADERÍA LA ESPIGA", "CARNICERÍA JOSÉ", "FRUTERÍA SOL",
            "PESCADERÍA MAR", "SUPERMERCADO LUZ", "FERRETERÍA HÉRCULES",
            "PELUQUERÍA ESTILO", "PASTELERÍA DULCE", "TIENDA ANTONIO",
            "ÓPTICA CLARAVISIÓN", "LIBRERÍA SABER", "ZAPATERÍA ANDAR",
            "JUGUETERÍA SONRISA", "FLORISTERÍA AROMA", "TELAS Y HILOS",
            "ELECTRODOMÉSTICOS PLUS", "FARMACIA SAN ROQUE", "BAZAR TODO A 1",
            "CAFETERÍA AROMAS", "ROPA MODA JOVEN", "MERCERÍA MARÍA",
            "QUIOSCO PRENSA", "TINTORERÍA LIMPIO", "DECORACIÓN HOGAR",
            "PERFUMERÍA ESENCIA", "MOBILIARIO CASA", "ÓPTICA MIRAR",
            "CERVEZERÍA TAP", "GASOLINERA RÁPIDO", "CHURROS DELICIAS",
            "TABACOS FUMAR", "CESTERÍA ARTESAN", "RELOJERÍA TIEMPO",
            "ALIMENTACIÓN FRESCO", "LOTERÍAS SUERTE", "MÓVILES CONECTA",
            "INFORMÁTICA PC", "MASCOTAS PELUDO", "CYCLE DEPORTES",
            "JARDINERÍA VERDE", "AUTOMÓVILES RÁPIDO", "MOTO VELOCIDAD",
            "PINTURAS COLOR", "MENAJERÍA COCINA", "REPOSTERÍA AZÚCAR",
            "CASA RURAL", "HOSTAL MESÓN", "RESTAURANTE MAR",
            "BAR TAPAS", "COMIDA RÁPIDA"
    };

    private final String holder;
    private final ConceptType concept;

    private final Date date;
    private final String concept1;
    private final String concept2;
    private final String concept3;
    private final float deposit;
    private final float charge;
    private float balance;

    public DetailReg(String holder, Date date, float initialBalance) {
        super(RegistryType.DETAIL);

        this.holder = holder;
        concept = ConceptType.getRandomType();

        this.date = date;
        concept1 = getConcept1();
        concept2 = getConcept2();
        concept3 = getConcept3();

        deposit = getRandomDeposit();
        balance = initialBalance + deposit;

        charge = getRandomCharge();
        balance = initialBalance - charge;
    }

    protected String getConcept1() {
        String strConcept = concept.toString();

        if (concept == ConceptType.FINANCING_ENTITY) {
            strConcept += " (" + DateUtil.dateToStringDate(date, "dd.MM.yyyy") + ")";
        }

        return strConcept;
    }

    protected String getConcept2() {
        String strConcept = DateUtil.dateToStringDate(date, "dd.MM.yyyy");

        switch (concept) {
            case ATM_CASH_WITHDRAWALS -> strConcept += " Oficina " + RandomUtil.getRandomInt(300, 8000);
            case CREDIT_CARD, DEBIT_CARD -> strConcept += " Ref.: " + getRandomCommerce();
            case FINANCING_ENTITY -> strConcept += " Ref.: RECIBO EMITIDO PO";
            case PENSION -> {
                /* Intentionally empty*/
            }
        }
        return strConcept;
    }

    protected String getConcept3() {
        String strConcept = "Más datos: ";

        switch (concept) {
            case ATM_CASH_WITHDRAWALS -> strConcept = "";
            case CREDIT_CARD, DEBIT_CARD -> {
                strConcept += "Fecha de operación: " +
                        DateUtil.dateToStringDate(DateUtil.getDateNDaysAgo(date, RandomUtil.getRandomInt(0, 3)), "dd-MM-yyyy");
            }
            case FINANCING_ENTITY ->
                    strConcept += "A" + asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(111111111, 999999999), 9);
            case PENSION -> strConcept += holder;
        }
        return strConcept;
    }

    private String getRandomCommerce() {
        return commerce[RandomUtil.getRandomInt(0, commerce.length - 1)];
    }

    protected float getRandomDeposit() {
        float depo = 0f;
        if (concept == ConceptType.PENSION) {
            depo = RandomUtil.getRandomFloat(1500, 3000);
        }

        return depo;
    }


    protected float getRandomCharge() {
        float charge = RandomUtil.getRandomFloat(20, 300);

        if (concept == ConceptType.PENSION) {
            charge = 0f;
        }

        return charge;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public String toRegistry() {
        return regType.toString() + DELIMITER +
                DateUtil.dateToExstreamDate(date) + DELIMITER +
                asString(concept1) + DELIMITER +
                asString(concept2) + DELIMITER +
                asString(concept3) + DELIMITER +
                asStringAmount(deposit) + DELIMITER +
                asStringAmount(charge) + DELIMITER +
                asStringAmount(balance) + DELIMITER;
    }
}
