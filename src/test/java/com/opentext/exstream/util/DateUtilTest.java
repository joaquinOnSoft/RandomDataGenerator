package com.opentext.exstream.util;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void testNowToExstreamDate() {
        // Act
        String result = DateUtil.nowToExstreamDate();

        // Assert
        assertNotNull(result);
        try {
            DateFormat sourceFormat = new SimpleDateFormat(DateUtil.EXSTREAM_DATE_FORMAT);
            sourceFormat.parse(result);
        } catch (ParseException e) {
            fail("The format is not a valid Instant");
        }
    }

    @Test
    void testGetExstreamDateNDaysAgo() {
        // Arrange
        int daysToSubtract = 5;
        LocalDate expectedDate = LocalDate.now().minusDays(daysToSubtract);
        String expectedFormat = expectedDate.format(DateTimeFormatter.ofPattern(DateUtil.EXSTREAM_DATE_FORMAT));

        // Act
        String result = DateUtil.getExstreamDateNDaysAgo(daysToSubtract);

        // Assert
        assertEquals(expectedFormat, result);
        // Format ddMMyyyy is always 8 characters long
        assertEquals(8, result.length());
    }

    @Test
    void testGetExstreamDateNDaysAgoWithZeroDays() {
        // Arrange
        LocalDate expectedDate = LocalDate.now();
        String expectedFormat = expectedDate.format(DateTimeFormatter.ofPattern(DateUtil.EXSTREAM_DATE_FORMAT));

        // Act
        String result = DateUtil.getExstreamDateNDaysAgo(0);

        // Assert
        assertEquals(expectedFormat, result);
    }

    @Test
    void testDateToExstreamDate() throws ParseException {
        // Arrange
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date testDate = sdf.parse("2025-05-15");
        String expected = "15052025";

        // Act
        String result = DateUtil.dateToExstreamDate(testDate);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testDateToExstreamDateWithNull() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            DateUtil.dateToExstreamDate(null);
        });
    }

    @Test
    void returnsCurrentDate() {
        Date result = DateUtil.now();
        Date expected = new Date();

        assertNotNull(result, "Returned date should not be null");
        long diff = Math.abs(expected.getTime() - result.getTime());
        assertTrue(diff < 100, "Returned date should be very close to current time");
    }

    @Test
    void withPositiveDaysReturnsPastDate() {
        int days = 5;
        Date now = new Date();

        Date result = DateUtil.getDateNDaysAgo(days);

        assertNotNull(result, "Returned date should not be null");
        long diff = now.getTime() - result.getTime();
        assertEquals(TimeUnit.DAYS.toMillis(days), diff, 1000,
                "Difference should be approximately 5 days");
    }

    @Test
    void withZeroDaysReturnsCurrentDate() {
        Date now = new Date();

        Date result = DateUtil.getDateNDaysAgo(0);

        assertNotNull(result, "Returned date should not be null");
        long diff = Math.abs(now.getTime() - result.getTime());
        assertTrue(diff < 100, "With 0 days should return date very close to now");
    }

    @Test
    void withNegativeDaysReturnsFutureDate() {
        int days = -3;
        Date now = new Date();

        Date result = DateUtil.getDateNDaysAgo(days);

        assertNotNull(result, "Returned date should not be null");
        assertTrue(result.after(now), "With negative days should return future date");
        long diff = result.getTime() - now.getTime();
        assertEquals(TimeUnit.DAYS.toMillis(Math.abs(days)), diff, 1000,
                "Difference should be approximately 3 days in future");
    }

    @Test
    void nowReturnsTimeBetweenBeforeAndAfterCall() {
        long before = System.currentTimeMillis();
        Date result = DateUtil.now();
        long after = System.currentTimeMillis();

        assertTrue(result.getTime() >= before && result.getTime() <= after,
                "Returned date should be between time before and after calling");
    }

    @Test
    void dateCalculationHasPrecision() {
        int days = 2;
        long expectedMillis = TimeUnit.DAYS.toMillis(days);

        Date now = new Date();
        Date result = DateUtil.getDateNDaysAgo(days);

        long diff = now.getTime() - result.getTime();
        assertEquals(expectedMillis, diff, 1000,
                "Difference should be exactly 2 days (with 1 second margin)");
    }
}