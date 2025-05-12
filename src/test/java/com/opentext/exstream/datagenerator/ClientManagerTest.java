package com.opentext.exstream.datagenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class ClientManagerTest {

    private static final List<String> VALID_NAMES = Arrays.asList(
            "Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Sofía",
            "Miguel", "Elena", "Javier", "Lucía", "David", "Paula", "Daniel", "Martina"
    );

    private static final List<String> VALID_FIRST_FAMILY_NAMES = Arrays.asList(
            "García", "Rodríguez", "González", "Fernández", "López", "Martínez",
            "Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz", "Hernández",
            "Díaz", "Moreno", "Álvarez"
    );

    private static final List<String> VALID_SECOND_FAMILY_NAMES = Arrays.asList(
            "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz", "Hernández", "Díaz",
            "Moreno", "Álvarez", "Muñoz", "Romero", "Alonso", "Gutiérrez", "Navarro",
            "Torres", "Domínguez"
    );

    @Test
    void testGetRandomClientReturnsValidClient() {
        Client client = ClientManager.getRandomClient();

        Assertions.assertNotNull(client, "The client should not be null");
        Assertions.assertTrue(VALID_NAMES.contains(client.getName()),
                "The name should be in the list of valid names.");
        Assertions.assertTrue(VALID_FIRST_FAMILY_NAMES.contains(client.getFirstFamilyName()),
                "The first surname should be in the list of valid surnames.");
        Assertions.assertTrue(VALID_SECOND_FAMILY_NAMES.contains(client.getSecondFamilyName()),
                "The second surname should be in the list of valid surnames.");
    }

    @Test
    void testGetRandomClientGeneratesDifferentClients() {
        Client client1 = ClientManager.getRandomClient();
        Client client2 = ClientManager.getRandomClient();

        // Esto podría fallar ocasionalmente por aleatoriedad, pero es muy improbable
        assertNotEquals(client1.toString(), client2.toString(), "Different customers should be generated in consecutive calls.");
    }

    @Test
    void testClientProperties() {
        Client client = new Client("Juan", "García", "López");

        Assertions.assertEquals("Juan", client.getName());
        Assertions.assertEquals("García", client.getFirstFamilyName());
        Assertions.assertEquals("López", client.getSecondFamilyName());
    }
}