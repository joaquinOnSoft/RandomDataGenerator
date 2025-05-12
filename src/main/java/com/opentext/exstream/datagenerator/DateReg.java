package com.opentext.exstream.datagenerator;

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
    public DateReg() {
        super(RegistryType.DATE);
    }

    @Override
    public String toRegistry() {
        return "";
    }
}
