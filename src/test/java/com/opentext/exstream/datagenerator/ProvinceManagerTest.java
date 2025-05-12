package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProvinceManagerTest {
    @Test
    public void getRandomProvince(){
        Province prov = ProvinceManager.getProvince(49);

        Assertions.assertEquals(49, prov.getCode());
        Assertions.assertEquals("Zamora", prov.getName());
        Assertions.assertEquals(980, prov.getPrefix());

    }
}
