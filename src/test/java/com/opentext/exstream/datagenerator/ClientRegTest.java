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
    public void toRegistry() {
        //Registry example:
        /// C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
        String clientRegistry = client.toRegistry();

        Assertions.assertNotNull(clientRegistry);
        Assertions.assertTrue(clientRegistry.startsWith("C;\""));
    }
}
