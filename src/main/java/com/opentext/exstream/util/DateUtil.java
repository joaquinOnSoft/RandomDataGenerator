package com.opentext.exstream.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final String EXSTREAM_DATE_FORMAT = "ddMMyyyy";

    /**
     * Return current date in Exstream date format, e.g.
     * 12052025
     * @return current date in Exstream date format
     */
    public static String nowToExstreamDate() {
        LocalDate date = LocalDate.now();
        return date.format(DateTimeFormatter.ofPattern(EXSTREAM_DATE_FORMAT)) ;
    }

    public static Date now(){
        return Calendar.getInstance().getTime();
    }

    public static String getExstreamDateNDaysAgo(int nDays) {
        LocalDate date = LocalDate.now().minusDays(nDays);
        return date.format(DateTimeFormatter.ofPattern(EXSTREAM_DATE_FORMAT));
    }

    public static Date getDateNDaysAgo(Date refDate, int nDays){
        return new Date(refDate.getTime() - 24L * 60 * 60 * 1000 * nDays);
    }


    public static Date getDateNDaysAgo(int nDays){
        Date now = Calendar.getInstance().getTime();
        return new Date(now.getTime() - 24L * 60 * 60 * 1000 * nDays);
    }


    public static String dateToExstreamDate(Date d) {
        return dateToStringDate(d, EXSTREAM_DATE_FORMAT);
    }

    public static String dateToStringDate(Date d, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(d);
    }
}
