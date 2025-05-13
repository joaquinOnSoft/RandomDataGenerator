package com.opentext.exstream.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class AddressUtilTest {
    @Test
    public void getRandomAddress() {
        String address = AddressUtil.getRandomAddress();

        Assertions.assertNotNull(address);
        Assertions.assertTrue(isNumeric(address.substring(address.length() - 1)));
    }

    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
