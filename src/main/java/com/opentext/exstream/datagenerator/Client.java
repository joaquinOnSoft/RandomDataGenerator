package com.opentext.exstream.datagenerator;

import java.util.Random;

public class Client {
    private String name;
    private String firstFamilyName;
    private String secondFamilyName;

    public Client(String name, String firstFamilyName, String secondFamilyName) {
        this.name = name;
        this.firstFamilyName = firstFamilyName;
        this.secondFamilyName = secondFamilyName;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getFirstFamilyName() {
        return firstFamilyName;
    }

    public String getSecondFamilyName() {
        return secondFamilyName;
    }

    @Override
    public String toString() {
        return name + " " + firstFamilyName + " " + secondFamilyName;
    }
}