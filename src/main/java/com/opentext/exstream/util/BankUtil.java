package com.opentext.exstream.util;

import java.util.Random;

public class BankUtil {
    private static final Random random = new Random();
    private static final String BANK_CODE = "2100"; // Código de CaixaBank
    private static final String COUNTRY_CODE = "ES";
    private static final String SWIFT_PREFIX = "CAIXESBB"; // Código SWIFT base de CaixaBank

    /**
     * Genera un IBAN español aleatorio válido para CaixaBank
     *
     * @return IBAN válido (formato ESXX 2100 XXXX XXXX XXXX XXXX)
     */
    public static String getRandomIban() {
        // Generar 16 dígitos aleatorios (20 posiciones en total con el código de banco)
        StringBuilder accountNumber = new StringBuilder(BANK_CODE);
        for (int i = 0; i < 16; i++) {
            accountNumber.append(random.nextInt(10));
        }

        // Calcular dígitos de control
        String controlDigits = calculateIbanControlDigits(accountNumber.toString());

        return COUNTRY_CODE + controlDigits + accountNumber;
    }

    /**
     * Genera un código SWIFT/BIC aleatorio válido para una oficina de CaixaBank
     *
     * @return Código SWIFT (formato CAIXESBBXXX)
     */
    public static String getRandomSwift() {
        // Los últimos 3 dígitos identifican la sucursal (XXX para oficina principal)
        char[] branchCode = new char[3];
        for (int i = 0; i < 3; i++) {
            branchCode[i] = (char) ('0' + random.nextInt(10));
        }
        return SWIFT_PREFIX + new String(branchCode);
    }

    protected static String calculateIbanControlDigits(String bankAccount) {
        // Mover código de país y dígitos de control (00) al final
        String rearranged = bankAccount + COUNTRY_CODE + "00";

        // Convertir letras a números (A=10, B=11, ..., E=14)
        StringBuilder numeric = new StringBuilder();
        for (char c : rearranged.toCharArray()) {
            if (Character.isLetter(c)) {
                numeric.append(10 + (c - 'A'));
            } else {
                numeric.append(c);
            }
        }

        // Calcular módulo 97
        java.math.BigInteger bigInt = new java.math.BigInteger(numeric.toString());
        int mod97 = bigInt.mod(java.math.BigInteger.valueOf(97)).intValue();

        // Dígitos de control = 98 - módulo
        int controlDigits = 98 - mod97;

        // Asegurar 2 dígitos
        return String.format("%02d", controlDigits);
    }

    // Auxiliary method for validating IBANs according to official algorithm
    public static boolean isValidIban(String iban) {
        // Move the first 4 characters to the end
        String rearranged = iban.substring(4) + iban.substring(0, 4);

        // Convert letters to numbers (A=10, B=11, ..., E=14)
        StringBuilder numeric = new StringBuilder();
        for (char c : rearranged.toCharArray()) {
            if (Character.isLetter(c)) {
                numeric.append(10 + (c - 'A'));
            } else {
                numeric.append(c);
            }
        }

        // Calculate modulus 97
        java.math.BigInteger bigInt = new java.math.BigInteger(numeric.toString());
        return bigInt.mod(java.math.BigInteger.valueOf(97)).intValue() == 1;
    }
}
