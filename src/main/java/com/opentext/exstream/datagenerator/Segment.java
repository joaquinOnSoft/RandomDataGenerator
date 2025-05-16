package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

public enum Segment {

    A('A'),
    B('B');

    private final char type;

    Segment(char name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }

    public static Segment getRandomType() {
        Segment type = A;

        int rand = RandomUtil.getRandomInt(1, 2);
        if (rand == 2) {
            type = B;
        }

        return type;
    }
}
