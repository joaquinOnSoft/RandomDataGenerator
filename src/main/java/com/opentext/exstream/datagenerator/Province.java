package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

public class Province {
    private final int code;
    private final String name;
    private final int prefix;

    Province(int code, String name, int prefix) {
        this.code = code;
        this.name = name;
        this.prefix = prefix;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrefix() {
        return prefix;
    }

    public String getRandomZip() {
        return String.format("%02d", code) + String.format("%03d", RandomUtil.getRandomInt(1, 999));
    }

    public String getRandomPhone() {
        return prefix + String.format("%06d", RandomUtil.getRandomInt(1, 999999));
    }
}