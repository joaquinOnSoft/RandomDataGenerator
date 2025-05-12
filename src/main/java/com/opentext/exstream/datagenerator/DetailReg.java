package com.opentext.exstream.datagenerator;

import java.util.Date;

/// Registry type: Detail
///
/// Field definition:
///
/// ```
/// T;fecha;concepto1;concepto2;concepto3;ingreso;cargo;saldo
/// ```
///
/// Content example:
///
/// ```
/// T;06082021;"ENT.FINANCIACION (05.08.2021)";"06.08.2021 Ref.: RECIBO EMITIDO PO";"Más datos: A99999999000";"0,0";"806,67";"33.320,80"
/// T;07082021;"TARJETA DE DÉBITO";"07.08.2021 Ref.: AUTOSERVICIO gggg";"Más datos: Fecha de operación: 04-08-2021";"0,0";"26,4";"33.294,4"
/// T;07082021;"TARJETA DE DÉBITO";"07.08.2021 Ref.: BBBBBB BB BBB BAR";"Más datos: Fecha de operación: 04-08-2021";"0,0";"26,79";"33.267,61"
/// ```
public class DetailReg extends AbstractRegistry {
    private Date date;
    private String concept1;
    private String concept2;
    private String concept3;
    private float deposit;
    private float charge;
    private float balance;
    
    public DetailReg() {
        super(RegistryType.DETAIL);
    }

    @Override
    public String toRegistry() {
        return "";
    }
}
