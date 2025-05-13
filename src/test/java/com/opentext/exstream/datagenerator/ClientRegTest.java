package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientRegTest {
    private static final ClientReg client = new ClientReg();

    @Test
    public void getRandomId() {
        String id = client.getRandomId();

        Assertions.assertNotNull(id);
        Assertions.assertEquals(8, id.length());
        Assertions.assertEquals(5, id.indexOf("/"));
    }

    @Test
    //Combination: "Com. G-00007, Sub. 001, Emp. 001, Id. 002"
    public void getRandomCombination() {
        String combination = client.getRandomCombination();

        Assertions.assertNotNull(combination);
        Assertions.assertTrue(combination.startsWith("Com. G-"));
        Assertions.assertEquals(40, combination.length());
    }

    @Test
    public void getRandomAgreements() {
        String version = client.getRandomAgreements();

        Assertions.assertNotNull(version);
        Assertions.assertEquals(3, version.indexOf("-"));
        Assertions.assertEquals(7, version.length());
    }

    @Test
    public void getRandomExpiry() {
        String expiry = client.getRandomExpiry();

        Assertions.assertNotNull(expiry);
        Assertions.assertEquals(7, expiry.length());

        Assertions.assertTrue(Character.isLetter(expiry.charAt(0)));
        Assertions.assertTrue(Character.isLetter(expiry.charAt(1)));
        Assertions.assertTrue(Character.isLetter(expiry.charAt(2)));
        Assertions.assertTrue(Character.isLetter(expiry.charAt(3)));

        Assertions.assertTrue(Character.isDigit(expiry.charAt(4)));
        Assertions.assertTrue(Character.isDigit(expiry.charAt(5)));
        Assertions.assertTrue(Character.isDigit(expiry.charAt(6)));
    }

    @Test
    public void getRandomLot() {
        String lot = client.getRandomLot();

        Assertions.assertNotNull(lot);
        Assertions.assertEquals(22, lot.length());
    }

    @Test
    public void toRegistry() {
        //Registry example:
        /// C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
        String reg = client.toRegistry();

        Assertions.assertNotNull(reg);
        Assertions.assertTrue(reg.startsWith("C;\""));

        String[] tokens = reg.split(";");
        Assertions.assertNotNull(tokens);
        Assertions.assertEquals(17, tokens.length);
    }
}
