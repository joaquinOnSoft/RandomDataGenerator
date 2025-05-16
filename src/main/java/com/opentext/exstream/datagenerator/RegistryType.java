package com.opentext.exstream.datagenerator;

public enum RegistryType {

    /// - (D)ocumento
    /// - (O)ficina
    /// - (F)echa
    /// - (C)liente
    /// - de(T)alle
    /// - detalle B (U)
    DOCUMENT('D'),
    OFFICE('O'),
    DATE('F'),
    CLIENT('C'),
    DETAIL_SEGMENT_A('T'),
    DETAIL_SEGMENT_B('U');

    private final char type;

    RegistryType(char name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
