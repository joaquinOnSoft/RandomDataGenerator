package com.opentext.exstream.datagenerator;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;


///  App to generate a data sample file following a given format
///
/// ## Data file definition
///
///  - The delimiter is ’;’
///  - The first field is the record type:
///     - (D)ocumento
///     - (O)ficina
///     - (F)echa
///     - (C)liente
///     - De(T)alle
///  - The dates are in ddMMyyyy format.
///  - I have put the text fields in inverted commas so that Exstream recognises them as strings, including the numbers.
///  - The data corresponds to the attached PDF, so the last figure in the detail is the previous balance +/- income or debit. If we mix the records until we get the stipulated 50 this figure will be wrong, but I don't think it is important now.
///  - The type A or B is in record D, the third field. It is best to also make this field random
///
/// ### Fields definition
///
/// ```text
/// D;modelo;submodelo;segmento;saldoAnterior
/// O;numero;direccion;cp;poblacion;telefono
/// F;emision;extractoNumero
/// C;titular;identificador;combinacion;verInterna;verVisible;agreements;division;caducidad;anyo;lote;hoja;iban;periodoInicial;periodoFinal;saldo;swift
/// T;fecha;concepto1;concepto2;concepto3;ingreso;cargo;saldo
/// ```
public class RandomDataGenerator {
    private static final String OPT_SHORT_CLIENTS = "c";
    private static final String OPT_LONG_CLIENTS = "clients";

    private static final String OPT_SHORT_OUTPUT = "o";
    private static final String OPT_LONG_OUTPUT = "output";

    public static void main(String[] args) {
        Options options = new Options();

        Option audioOpt = new Option(OPT_SHORT_CLIENTS, OPT_LONG_CLIENTS, false, "Process ALL audio formats (.wav, .gsm, .mp3, .ogg). By default only .wav is processed");
        options.addOption(audioOpt);

        Option configOpt = new Option(OPT_SHORT_OUTPUT, OPT_LONG_OUTPUT, true, "JSON Config file");
        options.addOption(configOpt);
        RandomDataFile.toFile("sample.csv");
    }
}
