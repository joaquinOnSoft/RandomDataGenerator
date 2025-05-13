package com.opentext.exstream.util;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankUtilTest {

    // Test para getRandomIban()
    @RepeatedTest(20)
    void testGetRandomIban_ValidFormat() {
        String iban = BankUtil.getRandomIban();

        // Verificar estructura básica del IBAN
        assertTrue(iban.startsWith("ES"), "The IBAN must begin with EN");
        assertEquals(24, iban.length(), "The IBAN must be 24 characters long");

        // Verificar que los dígitos de control son numéricos
        assertDoesNotThrow(() -> Integer.parseInt(iban.substring(2, 4)));

        // Verificar que contiene el código de banco de Caixa (2100)
        assertEquals("2100", iban.substring(4, 8), "It must contain the CaixaBank code 2100.");

        // Verificar que el resto son dígitos
        assertTrue(iban.substring(8).matches("\\d{16}"), "The last 16 characters must be digits");
    }

    @Test
    void testGetRandomIban_ValidCheckDigits() {
        String iban = BankUtil.getRandomIban();
        assertTrue(BankUtil.isValidIban(iban), "The IBAN generated must be valid");
    }

    // Test para getRandomSwift()
    @RepeatedTest(20)
    void testGetRandomSwiftValidFormat() {
        String swift = BankUtil.getRandomSwift();

        // Verificar estructura del SWIFT
        assertTrue(swift.startsWith("CAIXESBB"), "SWIFT must start with CAIXESBB");
        assertEquals(11, swift.length(), "SWIFT must be 11 characters long\n");
        assertTrue(swift.substring(8).matches("\\d{3}"), "The last 3 characters must be digits");
    }

    @RepeatedTest(10)
    void testGetRandomSwiftVariability() {
        String swift1 = BankUtil.getRandomSwift();
        String swift2 = BankUtil.getRandomSwift();

        // This could occasionally fail due to randomness, but is very unlikely.
        assertNotEquals(swift1, swift2, "Different SWIFT must be generated");
    }


    // Test adicional para verificar el cálculo de dígitos de control
    @Test
    void testIbanControlDigitsCalculation() {
        // IBAN conocido: ES9121000418450200051332
        String accountNumber = "21000418450200051332";
        String controlDigits = BankUtil.calculateIbanControlDigits(accountNumber);
        assertEquals("91", controlDigits, "Calculated check digits are incorrect");
    }
}