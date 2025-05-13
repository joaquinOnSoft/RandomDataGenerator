package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

public enum ModelType {

    MODEL_A('A'),
    MODEL_B('B');

    private final char type;

    ModelType(char name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }

    public static ModelType getRandomType() {
        ModelType type = MODEL_A;

        int rand = RandomUtil.getRandomInt(1, 2);
        if (rand == 2) {
            type = MODEL_B;
        }

        return type;
    }
}
