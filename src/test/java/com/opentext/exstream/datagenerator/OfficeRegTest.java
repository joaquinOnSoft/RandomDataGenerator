package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OfficeRegTest {
    static OfficeReg office = new OfficeReg();

    @Test
    public void toRegistry(){
        //Registry example:
        //  O;"01568";"PL. DEL MERCADO, 12";"22300";"BARBASTRO";"974266000"
        String officeRegistry = office.toRegistry();

        Assertions.assertNotNull(officeRegistry);
        Assertions.assertTrue(officeRegistry.startsWith("O;\""));
        Assertions.assertEquals(officeRegistry.length() - 12, officeRegistry.lastIndexOf(";") );
    }
}
