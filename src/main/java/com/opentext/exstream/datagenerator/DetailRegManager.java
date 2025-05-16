package com.opentext.exstream.datagenerator;

import com.opentext.exstream.util.DateUtil;
import com.opentext.exstream.util.RandomUtil;

import java.util.Date;

public class DetailRegManager {
    private final Segment segment;
    private final String holder;
    private float currentBalance;

    DetailRegManager(Segment segment, String holder, float initialBalance) {
        this.segment = segment;
        this.holder = holder;
        this.currentBalance = initialBalance;
    }

    public String toRegistry() {
        StringBuilder str = new StringBuilder();

        int repeat;
        Date date;
        AbstractDetailReg detail;
        for (int i = 0; i < 30; i++) {
            for(int j=0; j<2; j++) {
                do {
                    repeat = RandomUtil.getRandomInt(1, 100);

                    date = DateUtil.getDateNDaysAgo(30 - i);
                    if (segment == Segment.A) {
                        detail = new DetailSegmentAReg(holder, date, currentBalance);
                    } else {
                        detail = new DetailSegmentBReg(holder, date, currentBalance);
                    }
                    str.append(detail.toRegistry()).append("\n");

                    currentBalance = detail.getBalance();

                    // 10% of probability to have more than one charge or deposit in a day
                } while (repeat <= 10);
            }
        }

        return str.toString();
    }

    public float getCurrentBalance() {
        return currentBalance;
    }
}
