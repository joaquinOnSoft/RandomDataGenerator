package com.opentext.exstream.datagenerator;

import java.util.Random;

public class ClientManager {
    private static final String[] NAMES = {
            "Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Sofía",
            "Miguel", "Elena", "Javier", "Lucía", "David", "Paula", "Daniel", "Martina"
    };

    private static final String[] FIRST_FAMILY_NAMES = {
            "García", "Rodríguez", "González", "Fernández", "López", "Martínez",
            "Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz", "Hernández",
            "Díaz", "Moreno", "Álvarez"
    };

    private static final String[] SECOND_FAMILY_NAMES = {
            "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz", "Hernández", "Díaz",
            "Moreno", "Álvarez", "Muñoz", "Romero", "Alonso", "Gutiérrez", "Navarro",
            "Torres", "Domínguez"
    };

    private static final Random random = new Random();

    public static Client getRandomClient() {
        String name = NAMES[random.nextInt(NAMES.length)];
        String firstFamilyName = FIRST_FAMILY_NAMES[random.nextInt(FIRST_FAMILY_NAMES.length)];
        String secondFamilyName = SECOND_FAMILY_NAMES[random.nextInt(SECOND_FAMILY_NAMES.length)];

        return new Client(name, firstFamilyName, secondFamilyName);
    }
}
