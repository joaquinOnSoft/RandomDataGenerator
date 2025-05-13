package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
///```
public class RandomDataGenerator {
    private static final String OPT_SHORT_HELP = "h";
    private static final String OPT_HELP = "help";

    private static final String OPT_SHORT_CLIENTS = "c";
    private static final String OPT_CLIENTS = "clients";

    private static final String OPT_SHORT_OUTPUT = "o";
    private static final String OPT_OUTPUT = "output";

    private static final String DEFAULT_FILE_PREFIX = "random_data_";
    private static final String CSV_EXTENSION = ".csv";
    private static final int DEFAULT_NUMBER_CLIENTS = 10;

    private static final Logger log = LogManager.getLogger(RandomDataGenerator.class);


    public static void main(String[] args) {
        Options options = new Options();

        Option clientsOpt = new Option(OPT_SHORT_CLIENTS, OPT_CLIENTS, true, "Number of clients. Default value: 10");
        options.addOption(clientsOpt);

        Option outputOpt = new Option(OPT_SHORT_OUTPUT, OPT_OUTPUT, true, "Output file name. Default value: random_data_yyyyMMdd.csv");
        options.addOption(outputOpt);

        Option helpOpt = new Option(OPT_SHORT_HELP, OPT_HELP, false, "Output file name. Default value: random_data_yyyyMMdd.csv");
        options.addOption(helpOpt);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

        } catch (ParseException e) {
            log.error(e.getMessage());
            formatter.printHelp("RandomDataGenerator", options);

            System.exit(1);
            return;
        }


        if(cmd.hasOption(OPT_HELP)){
            formatter.printHelp("java -jar file.jar --config/-c 'config file path'", options);
            System.exit(0);
            return;
        }

        int clients = DEFAULT_NUMBER_CLIENTS;
        if(cmd.hasOption(OPT_CLIENTS)) {
            String pClients = cmd.getOptionValue(OPT_CLIENTS);
            try {
                clients = Integer.parseInt(pClients);
            } catch (NumberFormatException e) {
                log.error(e.getMessage());
                System.err.printf("Invalid value for %s / %s: %s \n", OPT_SHORT_CLIENTS, OPT_CLIENTS, pClients);
                System.exit(2);
                return;
            }
        }



        String output;
        if(cmd.hasOption(OPT_OUTPUT)){
            output = cmd.getOptionValue(OPT_OUTPUT);
        }
        else {
            output = DEFAULT_FILE_PREFIX +
                    DateUtil.dateToStringDate(DateUtil.now(), "yyyyMMddhhmmss") +
                    "_" + clients + "_reg" +
                    CSV_EXTENSION;
        }

        RandomDataFile.toFile(clients, output);

    }
}
