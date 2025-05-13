package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import com.opentext.exstream.util.RandomUtil;

import java.util.Date;

public class DetailRegManager {
    private final String holder;
    private float currentBalance;

    DetailRegManager(String holder, float initialBalance) {
        this.holder = holder;
        this.currentBalance = initialBalance;
    }

    public String toRegistry() {
        StringBuilder str = new StringBuilder();

        int repeat;
        Date date;
        DetailReg detail;
        for (int i = 0; i < 30; i++) {
            do {
                repeat = RandomUtil.getRandomInt(1, 100);

                date = DateUtil.getDateNDaysAgo(30 - i);
                detail = new DetailReg(holder, date, currentBalance);
                str.append(detail.toRegistry()).append("\n");
                // 10% of probability to have more than one charge or deposit in a day
            } while (repeat <= 10);

            currentBalance = detail.getBalance();
        }

        return str.toString();
    }

    public float getCurrentBalance() {
        return currentBalance;
    }
}
