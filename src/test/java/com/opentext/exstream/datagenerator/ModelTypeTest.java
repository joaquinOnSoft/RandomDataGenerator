package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTypeTest {
    @Test
    public void getRandomType() {
        Segment type;

        boolean modelBUsed = false;
        for (int i = 0; i < 100; i++) {
            type = Segment.getRandomType();
            if (type == Segment.B) {
                modelBUsed = true;
                break;
            }
        }
        Assertions.assertTrue(modelBUsed);
    }
}
