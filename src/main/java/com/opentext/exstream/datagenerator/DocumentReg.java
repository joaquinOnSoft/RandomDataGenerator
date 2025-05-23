package com.opentext.exstream.datagenerator;


import com.opentext.exstream.util.RandomUtil;

/// Registry type: Documento
///
/// Field definition:
///
/// ```
/// D;modelo;submodelo;segmento;saldoAnterior
///```
///
/// Content example:
///
/// ```
/// D;"00001";"001";"A";"99.999,99"
///```
public class DocumentReg extends AbstractRegistry {

    private static final String MODEL_1 = "00001";
    private static final String SUBMODEL_1 = "001";

    private final String model;
    private final String submodel;
    private final Segment segment;
    private float balance;

    public DocumentReg() {
        super(RegistryType.DOCUMENT);
        model = MODEL_1;
        submodel = SUBMODEL_1;
        segment = Segment.getRandomType();
        balance = RandomUtil.getRandomFloat(5000f, 99999);
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Segment getSegment() {
        return segment;
    }

    @Override
    public String toRegistry() {
        return regType.toString() + DELIMITER +
                model + DELIMITER +
                submodel + DELIMITER +
                segment.toString() + DELIMITER +
                asAmount(balance);
    }
}
