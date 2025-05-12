package com.opentext.exstream.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class DateUtilTest {

    @Test
    void testNowToExstreamDate() {
        // Act
        String result = DateUtil.nowToExstreamDate();

        // Assert
        assertNotNull(result);
        try {
            Instant.parse(result);
        } catch (Exception e) {
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
        assertEquals(8, result.length()); // Format ddMMyyyy is always 8 characters long
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
    void testNowToExstreamDateIsRecent() {
        // Act
        String result = DateUtil.nowToExstreamDate();
        Instant instantResult = Instant.parse(result);

        // Assert
        assertTrue(Instant.now().minus(1, ChronoUnit.SECONDS).isBefore(instantResult),
                "The date should be very recent");
        assertTrue(Instant.now().plus(1, ChronoUnit.SECONDS).isAfter(instantResult),
                "La fecha debería ser muy reciente");
    }
}