package com.piggymetrics.account.domain;

import java.time.*;

public class DateAndTime {

    public ZonedDateTime zonedDateTime(Clock clock) {
        LocalDate ldt = LocalDate.now(clock);
        LocalTime lt = LocalTime.now(clock);
        ZoneId zone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdt = ZonedDateTime.of(ldt, lt, zone);
        zdt = zdt.plusDays(2).plusHours(3).plusMinutes(4).plusSeconds(5).plusNanos(6);
        return zdt;
    }
}
