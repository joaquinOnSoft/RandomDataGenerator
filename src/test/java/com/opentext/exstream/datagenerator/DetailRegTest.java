package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

public class DetailRegTest {

    static DetailReg detail;

    @BeforeAll
    public static void setup() {
        detail = new DetailReg("Peter Parker", DateUtil.now(), 300345f);
    }

    @RepeatedTest(10)
    public void getConcept1() {
        String concept = detail.getConcept1();
        Assertions.assertNotNull(concept);
        Assertions.assertTrue(
                concept.startsWith(ConceptType.ATM_CASH_WITHDRAWALS.toString()) ||
                        concept.startsWith(ConceptType.CREDIT_CARD.toString()) ||
                        concept.startsWith(ConceptType.DEBIT_CARD.toString()) ||
                        concept.startsWith(ConceptType.FINANCING_ENTITY.toString()) ||
                        concept.startsWith(ConceptType.PENSION.toString())
        );
    }

    @RepeatedTest(10)
    public void getConcept2() {
        String concept = detail.getConcept2();
        Assertions.assertNotNull(concept);
    }

    @RepeatedTest(10)
    public void getConcept3() {
        String concept = detail.getConcept3();
        Assertions.assertNotNull(concept);
        Assertions.assertTrue(concept.startsWith("Más datos:") || concept.compareTo("") == 0);
    }

    @RepeatedTest(10)
    public void toRegistry() {
        String reg = detail.toRegistry();

        Assertions.assertNotNull(reg);
        String[] tokens = reg.split(";");
        Assertions.assertNotNull(tokens);
        Assertions.assertEquals(8, tokens.length);
    }
}
