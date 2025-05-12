package com.opentext.exstream.datagenerator;

public enum RegistryType {

    /// - (D)ocumento
    /// - (O)ficina
    /// - (F)echa
    /// - (C)liente
    /// - de(T)alle
    DOCUMENT('D'),
    OFFICE('O'),
    DATE('F'),
    CLIENT('C'),
    DETAIL('T');

    private final char type;

    RegistryType(char name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
