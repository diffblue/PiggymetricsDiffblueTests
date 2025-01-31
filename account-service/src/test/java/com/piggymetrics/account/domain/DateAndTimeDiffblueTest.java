package com.piggymetrics.account.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateAndTimeDiffblueTest {

    /**
     * Test {@link DateAndTime#zonedDateTime(Clock)}.
     * <ul>
     *   <li>Then return toLocalDateTime toLocalTime toString is
     * {@code 03:04:05.000000006}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DateAndTime#zonedDateTime(Clock)}
     */
    @Test
    @DisplayName("Test zonedDateTime(Clock); then return toLocalDateTime toLocalTime toString is '03:04:05.000000006'")
    void testZonedDateTime_thenReturnToLocalDateTimeToLocalTimeToStringIs030405000000006() {
        // Arrange
        DateAndTime dateAndTime = new DateAndTime();

        // Act
        ZonedDateTime actualZonedDateTimeResult = dateAndTime.zonedDateTime(DateFactory.getSpecificDateForTesting());

        // Assert
        LocalDateTime toLocalDateTimeResult = actualZonedDateTimeResult.toLocalDateTime();
        assertEquals("03:04:05.000000006", toLocalDateTimeResult.toLocalTime().toString());
        assertEquals("1965-04-27", toLocalDateTimeResult.toLocalDate().toString());
        assertEquals("America/Los_Angeles", actualZonedDateTimeResult.getZone().toString());
    }

}
