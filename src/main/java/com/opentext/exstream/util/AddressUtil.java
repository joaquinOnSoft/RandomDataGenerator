package com.opentext.exstream.util;

public class AddressUtil {
    private static final String[]  streets = {
            "PL. DEL MERCADO", "C. MAYOR", "AV. DE LA CONSTITUCIÓN",
            "C. REAL", "C. DEL OLIVO", "C. DE LA LUNA", "AV. DEL RÍO",
            "C. SANTA MARÍA", "PL. DE ESPAÑA", "C. DEL CARMEN",
            "C. SAN FERNANDO", "AV. DE AMÉRICA", "C. DE LA PIEDRA",
            "C. DEL SOL", "AV. DE LA PAZ", "C. DEL RÍO", "PL. DEL AYUNTAMIENTO",
            "C. SAN JUAN", "AV. DE EUROPA", "C. DE LA ROSA", "C. DEL PUENTE",
            "C. DE LA ESTACIÓN", "AV. DE LOS REYES", "C. DEL PARQUE",
            "C. DE LA FUENTE", "AV. DE LA LUZ", "C. DEL CASTILLO",
            "PL. DE LA VILLA", "C. DE LAS FLORES", "AV. DEL MAR"
    };

    public static String getRandomAddress(){
        int index = RandomUtil.getRandomInt(0, streets.length -1);

        return streets[index] + " " +RandomUtil.getRandomInt(1, 50);
    }
}
