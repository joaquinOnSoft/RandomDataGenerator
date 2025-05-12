package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

import java.util.Map;

public class ProvinceManager {
    private static final Map<Integer, Province> provinces = Map.<Integer, Province>ofEntries(
            Map.entry(1, new Province(1, "Álava", 945)),
            Map.entry(2, new Province(2, "Albacete", 967)),
            Map.entry(3, new Province(3, "Alicante", 965)),
            Map.entry(4, new Province(4, "Almería", 950)),
            Map.entry(5, new Province(5, "Ávila", 920)),
            Map.entry(6, new Province(6, "Badajoz", 924)),
            Map.entry(7, new Province(7, "Islas Baleares", 971)),
            Map.entry(8, new Province(8, "Barcelona", 93)),
            Map.entry(9, new Province(9, "Burgos", 947)),
            Map.entry(10, new Province(10, "Cáceres", 927)),
            Map.entry(11, new Province(11, "Cádiz", 956)),
            Map.entry(12, new Province(12, "Castellón", 964)),
            Map.entry(13, new Province(13, "Ciudad Real", 926)),
            Map.entry(14, new Province(14, "Córdoba", 957)),
            Map.entry(15, new Province(15, "La Coruña", 981)),
            Map.entry(16, new Province(16, "Cuenca", 969)),
            Map.entry(17, new Province(17, "Gerona", 972)),
            Map.entry(18, new Province(18, "Granada", 958)),
            Map.entry(19, new Province(19, "Guadalajara", 949)),
            Map.entry(20, new Province(20, "Guipúzcoa", 943)),
            Map.entry(21, new Province(21, "Huelva", 959)),
            Map.entry(22, new Province(22, "Huesca", 974)),
            Map.entry(23, new Province(23, "Jaén", 953)),
            Map.entry(24, new Province(24, "León", 987)),
            Map.entry(25, new Province(25, "Lérida", 973)),
            Map.entry(26, new Province(26, "La Rioja", 941)),
            Map.entry(27, new Province(27, "Lugo", 982)),
            Map.entry(28, new Province(28, "Madrid", 91)),
            Map.entry(29, new Province(29, "Málaga", 95)),
            Map.entry(30, new Province(30, "Murcia", 968)),
            Map.entry(31, new Province(31, "Navarra", 948)),
            Map.entry(32, new Province(32, "Orense", 988)),
            Map.entry(33, new Province(33, "Asturias", 985)),
            Map.entry(34, new Province(34, "Palencia", 979)),
            Map.entry(35, new Province(35, "Las Palmas", 928)),
            Map.entry(36, new Province(36, "Pontevedra", 986)),
            Map.entry(37, new Province(37, "Salamanca", 923)),
            Map.entry(38, new Province(38, "Santa Cruz de Tenerife", 922)),
            Map.entry(39, new Province(39, "Cantabria", 942)),
            Map.entry(40, new Province(40, "Segovia", 921)),
            Map.entry(41, new Province(41, "Sevilla", 95)),
            Map.entry(42, new Province(42, "Soria", 975)),
            Map.entry(43, new Province(43, "Tarragona", 977)),
            Map.entry(44, new Province(44, "Teruel", 978)),
            Map.entry(45, new Province(45, "Toledo", 925)),
            Map.entry(46, new Province(46, "Valencia", 96)),
            Map.entry(47, new Province(47, "Valladolid", 983)),
            Map.entry(48, new Province(48, "Vizcaya", 94)),
            Map.entry(49, new Province(49, "Zamora", 980)),
            Map.entry(50, new Province(50, "Zaragoza", 976)),
            Map.entry(51, new Province(51, "Ceuta", 956)),
            Map.entry(52, new Province(52, "Melilla", 952))
    );

    public static Province getProvince(int code) {
        return provinces.get(code);
    }

    public static Province getRandomProvince(){
        int code = RandomUtil.getRandomInt(1, 52);
        return provinces.get(code);
    }
}
