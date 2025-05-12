package com.opentext.exstream.datagenerator;

/*
- Las 5 primeras líneas son de cabecera, contienen el concepto de cada tipo de registro
- El delimitador es ";"
- El primer campo es el tipo de registro, (D)ocumento, (O)ficina, (F)echa, (C)liente y de(T)alle
- Las fechas están en formato ddmmyyyy
- Los campos de texto los he puesto entre comillas para que Exstream los reconozca como strings, incluyendo las cifras
- Los datos corresponden a los del PDF anexado, así que la última cifra del detalle es el saldo anterior +/- ingreso o cargo. Si mezclamos los registros hasta conseguir los 50 estipulados esta cifra va a estar mal, pero no creo que sea importante ahora
- El tipo A o B está en el registro D, el tercer campo. Lo mejor es también hacer este campo random

 */
public class RandomDataGenerator {
}
