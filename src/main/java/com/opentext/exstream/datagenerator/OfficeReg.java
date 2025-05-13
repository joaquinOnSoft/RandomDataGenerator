package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.AddressUtil;
import com.opentext.exstream.util.RandomUtil;

/// Registry type: Office
///
/// Field definition:
///
/// ```
/// O;numero;direccion;cp;poblacion;telefono
///```
///
/// Content example:
///
/// ```
/// O;"01568";"PL. DEL MERCADO, 12";"22300";"BARBASTRO";"974266000"
///```
public class OfficeReg extends AbstractRegistry {


    private final int number;
    private final String address;
    private final String zip;
    private final String locality;
    private final String phone;

    public OfficeReg() {
        super(RegistryType.OFFICE);
        number = RandomUtil.getRandomInt(1, 10000);

        Province province = ProvinceManager.getRandomProvince();

        address = AddressUtil.getRandomAddress();
        zip = province.getRandomZip();
        locality = province.getName();
        phone = province.getRandomPhone();
    }


    @Override
    public String toRegistry() {
        //O;"01568";"PL. DEL MERCADO, 12";"22300";"BARBASTRO";"974266000"
        return regType.toString() + DELIMITER +
                asString(String.format("%05d", number)) + DELIMITER +
                asString(address) + DELIMITER +
                asString(zip) + DELIMITER +
                asString(locality) + DELIMITER +
                asString(phone);
    }
}
