package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DocumentRegTest {
    static DocumentReg doc = new DocumentReg();

    @Test
    public void asPrice(){
        Assertions.assertEquals("\"12.345,67\"", doc.asStringAmount(12345.67f));

        Assertions.assertEquals("\"12.345,00\"", doc.asStringAmount(12345.00f));

    }

    @Test
    public void toRegistry(){
        //Registry example:
        //  D;"00001";"001";"A";"99.999,99"
        String docStr = doc.toRegistry();

        Assertions.assertNotNull(docStr);
        Assertions.assertTrue(docStr.startsWith("D;\"00001\";\"001\";"));
        Assertions.assertEquals(docStr.length() - 8, docStr.indexOf("."));
        Assertions.assertEquals(docStr.length() - 4, docStr.indexOf(","));
    }


    @Test
    public void asFixLengthLeftZeroPaddingFromInt(){
        String str = doc.asFixLengthLeftZeroPadding(1236, 5);
        Assertions.assertEquals("01236", str);
    }

    @Test
    public void asFixLengthLeftZeroPaddingFromStr(){
        String str = doc.asFixLengthLeftZeroPadding("1236", 5);
        Assertions.assertEquals("01236", str);
    }


    @Test
    public void asFixLengthLeftZeroPaddingStringFromInt(){
        String str = doc.asFixLengthLeftZeroPaddingString(1236, 5);
        Assertions.assertEquals("\"01236\"", str);

    }

    @Test
    public void asFixLengthLeftZeroPaddingStringFromStr(){
        String str = doc.asFixLengthLeftZeroPaddingString("1236", 5);
        Assertions.assertEquals("\"01236\"", str);

    }

}
