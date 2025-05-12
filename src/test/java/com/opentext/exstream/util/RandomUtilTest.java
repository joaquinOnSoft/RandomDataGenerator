package com.opentext.exstream.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    public void getRandomInt(){
        int min = 1;
        int max = 10;
        int random = RandomUtil.getRandomInt(min, max);

        Assertions.assertTrue(random >= min);
        Assertions.assertTrue(random <= max);
    }

    @Test
    public void getRandomFloat(){
        float min = 1;
        float max = 10;
        float random = RandomUtil.getRandomFloat(min, max);

        System.out.println("Random: " + random);
        Assertions.assertTrue(random >= min);
        Assertions.assertTrue(random <= max);
    }
}
