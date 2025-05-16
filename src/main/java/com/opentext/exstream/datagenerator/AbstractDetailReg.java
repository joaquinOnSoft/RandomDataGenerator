package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import com.opentext.exstream.util.RandomUtil;

import java.util.Date;

public class AbstractDetailReg extends AbstractRegistry {
    private final String[] commerce = {
            // Food
            "PANADERÍA LA ESPIGA", "CARNICERÍA JOSÉ", "FRUTERÍA SOL", "PESCADERÍA MAR",
            "SUPERMERCADO LUZ", "ALIMENTACIÓN FRESCO", "CHARCUTERÍA SABOR", "HUEVERÍA GALLINA",
            "LECHE Y DERIVADOS", "QUESOS TRADICIÓN", "ACEITES DEL SUR", "ULTRAFRESCO",
            "CONGELADOS INVIERNO", "LEGUMBRES SANAS", "ESPECIAS Y MÁS", "DELICATESSEN GOURMET",
            "MIEL ABEJA", "FRUTOS SECOS NUT", "VINOS Y LICORES", "CEREALES CAMPO",
            "PAN INTEGRAL", "PASTA CASERA", "EMBUTIDOS IBÉRICOS", "MARISCOS COSTA",
            "ENVASADOS LA ABUELA", "CONSERVERA MARINA", "ORGANIC FOOD", "TIENDA VEGANA",
            "CESTA BÁSICA", "MERCADILLO FRESCO",

            // Bars, cafés and restaurants
            "CAFETERÍA AROMAS", "BAR TAPAS", "COMIDA RÁPIDA", "RESTAURANTE MAR",
            "CERVECERÍA TAP", "CHURROS DELICIAS", "HELADERÍA GELATO", "TETERÍA MENTA",
            "COCTELERÍA MIX", "ASADOR BRASA", "PIZZERÍA ITALIA", "MESÓN QUESO",
            "TABERNA VIEJA", "BODEGA VINOS", "CAFÉ LIBRERÍA", "CHOCOLATERÍA DULCE",
            "BOLLERÍA MANTECA", "SUSHI DEL MAR", "PARRILLA ARGENTINA", "COMIDA MEXICANA",
            "BAR DE COPAS", "CAFÉ INTERNET", "TAPAS Y MÁS", "RESTAURANTE RURAL",
            "MERENDERO PLAYA", "BAR DEPORTIVO", "CAFETERÍA MODERNA", "TERRAZA SOL",

            // Fashion and accessories
            "ROPA MODA JOVEN", "ZAPATERÍA ANDAR", "PERFUMERÍA ESENCIA", "JOYERÍA RUBÍ",
            "BOLSOS Y MÁS", "GAFAS DE SOL", "ROPA INTERIOR SUAVE", "UNIFORMES LABORAL",
            "TALLAS GRANDES", "MODA INFANTIL", "CAMISERÍA ELEGANTE", "JEANS & CO",
            "ROPA DEPORTIVA", "OUTLET MODA", "VINTAGE STYLE", "ACCESORIOS PLATA",
            "ROPA DE CUERO", "ZAPATOS ARTESANOS", "GORRAS Y SOMBREROS", "TIENDA DE GANGAS",

            // Services and professionals
            "FERRETERÍA HÉRCULES", "PELUQUERÍA ESTILO", "ÓPTICA CLARAVISIÓN", "TINTORERÍA LIMPIO",
            "FARMACIA SAN ROQUE", "MÓVILES CONECTA", "INFORMÁTICA PC", "ELECTRODOMÉSTICOS PLUS",
            "FOTOCOPIAS RÁPIDO", "TALLER MECÁNICO", "GASOLINERA RÁPIDO", "SEGUROS TRANQUILO",
            "AGENCIA VIAJES", "ABOGADOS LEGAL", "GESTORÍA PAPELES", "DENTISTA SONRISA",
            "CLÍNICA VETERINARIA", "ESCUELA CONDUCIR", "LIMPIEZA TOTAL", "REFORMAS HOGAR",
            "CERRAJERÍA URGENCIA", "FONTANERÍA AGUA", "ELECTRICISTA LUZ", "CAMBIO MONEDA",

            // Home & Decoration
            "DECORACIÓN HOGAR", "MOBILIARIO CASA", "PINTURAS COLOR", "MENAJERÍA COCINA",
            "ALFOMBRAS Y MÁS", "CUADROS Y MARCO", "ILUMINACIÓN LED", "JARDINERÍA VERDE",
            "BAÑOS MODERNOS", "COCINAS IDEALES", "CORTINAS Y TELAS", "SILLONES CONFORT",
            "MUEBLES RÚSTICOS", "ELECTROHOGAR", "AIRE ACONDICIONADO", "ALMACÉN MUEBLES",
            "Vajillas Elegantes", "HOGAR Y ESTILO", "REGALOS ORIGINALES", "ARTÍCULOS NAVIDAD",

            // Leisure and culture
            "LIBRERÍA SABER", "JUGUETERÍA SONRISA", "QUIOSCO PRENSA", "MÚSICA Y CD",
            "VIDEOJUEGOS GAME", "CINE MULTIPLEX", "TEATRO ESCENA", "ARTE GALERÍA",
            "DEPORTES ACTIVO", "BICICLETAS VELOZ", "PESCA Y CAZA", "CAMPING MONTAÑA",
            "FITNESS GYM", "PISCINA Y MÁS", "FÚTBOL TIENDA", "TENIS RAQUETA",
            "JUEGOS MESA", "MANUALIDADES CREA", "FOTOGRAFÍA IMAGEN", "INSTRUMENTOS MUSICALES",

            // Miscellaneous and bazaar
            "BAZAR TODO A 1", "MERCERÍA MARÍA", "TELAS Y HILOS", "RELOJERÍA TIEMPO",
            "MASCOTAS PELUDO", "LOTERÍAS SUERTE", "TABACOS FUMAR", "CESTERÍA ARTESAN",
            "REPOSTERÍA AZÚCAR", "ARTESANÍA LOCAL", "REGALOS SORPRESA", "TIENDA CHINA",
            "TODO A 100", "SEGUNDA MANO", "ALMACÉN VARIEDADES", "OBJETOS PERDIDOS",
            "ANTIGÜEDADES", "COLECCIONISMO", "ARTE RELIGIOSO", "MERCADILLO USADO",

            // Tourism and accommodation
            "CASA RURAL", "HOSTAL MESÓN", "HOTEL PLAYA", "APARTAMENTOS SOL",
            "CAMPING PINAR", "ALBERGUE JUVENTUD", "CASA DE ALQUILER", "HOTEL NEGOCIO",
            "POSADA MEDIEVAL", "BALNEARIO AGUA", "CABAÑAS BOSQUE", "HOSTERÍA CAMINO",
            "PARADOR TURÍSTICO", "HOTEL LUJO", "MOTEL CARRETERA", "ALOJAMIENTO BARATO",
            "CASA DE HUÉSPEDES", "VILLA PRIVADA", "CHALET ALQUILER", "HOTEL FAMILIAR"
    };

    protected final String holder;
    protected final ConceptType concept;

    protected final Date date;
    protected final String concept1;
    protected final String concept2;
    protected final String concept3;
    protected final float deposit;
    protected final float charge;
    protected float balance;

    public AbstractDetailReg(RegistryType regType, String holder, Date date, float initialBalance) {
        super(regType);

        this.holder = holder;
        concept = ConceptType.getRandomType();

        this.date = date;
        concept1 = getConcept1();
        concept2 = getConcept2();
        concept3 = getConcept3();

        deposit = getRandomDeposit();
        balance = initialBalance + deposit;

        charge = getRandomCharge();
        balance = initialBalance - charge;
    }

    protected String getConcept1() {
        String strConcept = concept.toString();

        if (concept == ConceptType.FINANCING_ENTITY) {
            strConcept += " (" + DateUtil.dateToStringDate(date, "dd.MM.yyyy") + ")";
        }

        return strConcept;
    }

    protected String getConcept2() {
        String strConcept = DateUtil.dateToStringDate(date, "dd.MM.yyyy");

        switch (concept) {
            case ATM_CASH_WITHDRAWALS -> strConcept += " Oficina " + RandomUtil.getRandomInt(300, 8000);
            case CREDIT_CARD, DEBIT_CARD -> strConcept += " Ref.: " + getRandomCommerce();
            case FINANCING_ENTITY -> strConcept += " Ref.: RECIBO EMITIDO PO";
            case PENSION -> {
                /* Intentionally empty*/
            }
        }
        return strConcept;
    }

    protected String getConcept3() {
        String strConcept = "Más datos: ";

        switch (concept) {
            case ATM_CASH_WITHDRAWALS -> strConcept = "";
            case CREDIT_CARD, DEBIT_CARD -> {
                strConcept += "Fecha de operación: " +
                        DateUtil.dateToStringDate(DateUtil.getDateNDaysAgo(date, RandomUtil.getRandomInt(0, 3)), "dd-MM-yyyy");
            }
            case FINANCING_ENTITY ->
                    strConcept += "A" + asFixLengthLeftZeroPadding(RandomUtil.getRandomInt(111111111, 999999999), 9);
            case PENSION -> strConcept += holder;
        }
        return strConcept;
    }

    private String getRandomCommerce() {
        return commerce[RandomUtil.getRandomInt(0, commerce.length - 1)];
    }

    protected float getRandomDeposit() {
        float depo = 0f;
        if (concept == ConceptType.PENSION) {
            depo = RandomUtil.getRandomFloat(1500, 3000);
        }

        return depo;
    }

    protected float getRandomCharge() {
        float charge = RandomUtil.getRandomFloat(20, 300);

        if (concept == ConceptType.PENSION) {
            charge = 0f;
        }

        return charge;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public String toRegistry() {
        return regType.toString() + DELIMITER +
                DateUtil.dateToExstreamDate(date) + DELIMITER +
                concept1 + DELIMITER +
                concept2 + DELIMITER +
                concept3 + DELIMITER +
                asAmount(deposit) + DELIMITER +
                asAmount(charge) + DELIMITER +
                asAmount(balance) + DELIMITER;
    }
}
