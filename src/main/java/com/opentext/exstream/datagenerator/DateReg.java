package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import com.opentext.exstream.util.RandomUtil;

import java.util.Date;

/// Registry type: Date
///
/// Field definition:
///
/// ```
/// F;emision;extractoNumero
/// ```
///
/// Content example:
///
/// ```
/// F;05092021;2021/009
/// ```
public class DateReg extends AbstractRegistry{
    private final Date emision;
    private final String extractNumber;

    public DateReg() {
        super(RegistryType.DATE);
        emision = DateUtil.now();
        extractNumber = DateUtil.dateToStringDate(emision, "yyyy") + "/" + RandomUtil.getRandomInt(100, 999);
    }



    @Override
    public String toRegistry() {
        return regType.toString() + DELIMITER +
                DateUtil.dateToExstreamDate(emision) + DELIMITER +
                extractNumber;
    }
}
