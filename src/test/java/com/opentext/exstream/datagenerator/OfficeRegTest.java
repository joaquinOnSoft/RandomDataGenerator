package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OfficeRegTest {
    static OfficeReg office = new OfficeReg();

    @Test
    public void toRegistry() {
        //Registry example:
        //  O;"01568";"PL. DEL MERCADO, 12";"22300";"BARBASTRO";"974266000"
        String officeRegistry = office.toRegistry();

        Assertions.assertNotNull(officeRegistry);
        Assertions.assertTrue(officeRegistry.startsWith("O;\""));
        int lastSemiColumn = officeRegistry.lastIndexOf(";");

        //Phone number can have 8 or 9 digits
        Assertions.assertTrue(officeRegistry.length() - 11 >= lastSemiColumn);
        Assertions.assertTrue(officeRegistry.length() - 12 <= lastSemiColumn);
    }
}
