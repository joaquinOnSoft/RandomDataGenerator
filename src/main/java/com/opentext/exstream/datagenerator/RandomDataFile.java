package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.RandomUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomDataFile {
    public static void toFile(String fileName)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(getRandomClientData());
            writer.flush();

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String getRandomClientData(){
        StringBuilder data = new StringBuilder();

        DocumentReg doc = new DocumentReg();
        OfficeReg office = new OfficeReg();
        DateReg dateReg = new DateReg();
        ClientReg client = new ClientReg();
        DetailRegManager detailMng = new DetailRegManager(client.getHolder(), RandomUtil.getRandomFloat(25000, 99999));
        client.setBalance(detailMng.getCurrentBalance());

        data.append(doc.toRegistry()).append("\n")
                .append(office.toRegistry()).append("\n")
                .append(dateReg.toRegistry()).append("\n")
                .append(client.toRegistry()).append("\n")
                .append(detailMng.toRegistry());

        return data.toString();
    }
}
