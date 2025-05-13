package com.opentext.exstream.util;

import java.util.Random;

public class RandomUtil {
    public static int getRandomInt(int min, int max) {
        Random rn = new Random();
        return rn.nextInt((max - min) + 1) + min;
    }

    public static float getRandomFloat(float min, float max) {
        Random rn = new Random();
        return rn.nextFloat() * (max - min) + min;
    }
}
