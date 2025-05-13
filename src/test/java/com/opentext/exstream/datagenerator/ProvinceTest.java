package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProvinceTest {
    private static final Province prov = ProvinceManager.getRandomProvince();

    @Test
    public void getRandomZip() {
        String zip = prov.getRandomZip();

        Assertions.assertNotNull(zip);
        Assertions.assertEquals(5, zip.length());
    }

    @Test
    public void getRandomPhone() {
        String phone = prov.getRandomPhone();

        Assertions.assertNotNull(phone);
        Assertions.assertTrue(phone.length() >= 8);
        Assertions.assertTrue(phone.length() <= 9);
    }
}
