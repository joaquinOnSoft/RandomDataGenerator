package com.opentext.exstream.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    public static final String EXSTREAM_DATE_FORMAT = "ddMMyyyy";

    /**
     * Return current date in Exstream date format, e.g.
     * 12052025
     * @return current date in Exstream date format
     */
    public static String nowToExstreamDate() {
        return Instant.now().toString() ;
    }

    public static String getExstreamDateNDaysAgo(int nDays) {
        LocalDate date = LocalDate.now().minusDays(nDays);
        return date.format(DateTimeFormatter.ofPattern(EXSTREAM_DATE_FORMAT));
    }

    public static String dateToExstreamDate(Date d) {
        DateFormat dateFormat = new SimpleDateFormat(EXSTREAM_DATE_FORMAT);
        return dateFormat.format(d);
    }
}
