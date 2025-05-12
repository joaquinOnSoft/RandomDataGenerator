package com.opentext.exstream.datagenerator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class AbstractRegistry {
    protected static final String DELIMITER = ";";
    protected RegistryType regType;

    public AbstractRegistry(RegistryType regType) {
        this.regType = regType;
    }

    protected String asStringAmount(float value){
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("es", "ES"));
        decimalFormat.applyPattern("###,###.00");
        return "\"" + decimalFormat.format(value) + "\"";
    }

    protected String asString(String value){
        return "\"" + value + "\"";
    }

    protected String asFixLengthLeftZeroPadding(int value, int length){
        return String.format("%0" + length + "d", value);
    }

    protected String asFixLengthLeftZeroPadding(String value, int length){
        return String.format("%1$" + length + "s", value).replace(' ', '0');
    }

    protected String asFixLengthLeftZeroPaddingString(int value, int length){
        return "\"" + String.format("%0" + length + "d", value) + "\"";
    }

    protected String asFixLengthLeftZeroPaddingString(String value, int length){
        return "\"" + String.format("%1$" + length + "s", value).replace(' ', '0') + "\"";
    }

    public abstract String toRegistry();
}
