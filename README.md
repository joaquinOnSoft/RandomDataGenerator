# Random Data Generator

App to generate a data sample file following a given format

## Data file definition

 - The delimiter is ’;’
 - The first field is the record type:
    - (D)ocumento
    - (O)ficina
    - (F)echa
    - (C)liente 
    - De(T)alle  
 - The dates are in ddMMyyyy format.
 - I have put the text fields in inverted commas so that Exstream recognises them as strings, including the numbers.
 - The data corresponds to the attached PDF, so the last figure in the detail is the previous balance +/- income or debit. If we mix the records until we get the stipulated 50 this figure will be wrong, but I don't think it is important now.
 - The type A or B is in record D, the third field. It is best to also make this field random

### Fields definition

```text
D;modelo;submodelo;segmento;saldoAnterior
O;numero;direccion;cp;poblacion;telefono
F;emision;extractoNumero
C;titular;identificador;combinacion;verInterna;verVisible;agreements;division;caducidad;anyo;lote;hoja;iban;periodoInicial;periodoFinal;saldo;swift
T;fecha;concepto1;concepto2;concepto3;ingreso;cargo;saldo
```

### File example 

```text
D;"00001";"001";"A";"99.999,99"
O;"01568";"PL. DEL MERCADO, 12";"22300";"BARBASTRO";"974266000"
F;05092021;2021/009
C;"VICTOR SAULER PORTAL";"01568/00";"Com. G-00007, Sub. 001, Emp. 001, Id. 002";"013";"001";"001-005";"200";"CCOD124";"2021";"20210906-00129-0000769";"001";"ES49 2100 9999 9999 9999 9999",06082021,05092021;"33.799,01";"CAIXESBBXXX"
T;06082021;"ENT.FINANCIACION (05.08.2021)";"06.08.2021 Ref.: RECIBO EMITIDO PO";"Más datos: A99999999000";"0,0";"806,67";"33.320,80"
T;07082021;"TARJETA DE DÉBITO";"07.08.2021 Ref.: AUTOSERVICIO gggg";"Más datos: Fecha de operación: 04-08-2021";"0,0";"26,4";"33.294,4"
T;07082021;"TARJETA DE DÉBITO";"07.08.2021 Ref.: BBBBBB BB BBB BAR";"Más datos: Fecha de operación: 04-08-2021";"0,0";"26,79";"33.267,61"
T;08082021;"TARJETA DE DÉBITO";"08.08.2021 Ref.: TTTTT TTTTTTTTTT";"Más datos: Fecha de operación: 05-08-2021";"0,0";"17,25";"33.250,36"
T;08082021;"TARJETA DE DÉBITO";"08.08.2021 Ref.: TTTT BBBBBBBBO";"Más datos: Fecha de operación: 05-08-2021";"0,0";"19,95";"33.230,41"
T;09082021;"TARJETA DE DÉBITO";"09.08.2021 Ref.: EEEEEI CENTER BAR";"Más datos: Fecha de operación: 06-08-2021";"0,0";"33,16";"33.197,25"
```