package com.piggymetrics.account.domain;

import java.time.*;
import com.diffblue.cover.annotations.InterestingTestFactory;

public class DateFactory {

    @InterestingTestFactory
    public static Clock getSpecificDateForTesting() {
        LocalDate ld = LocalDate.of(1965,Month.APRIL,25);
        ZoneId zone = ZoneId.of("America/Los_Angeles");
        Clock clock = Clock.fixed(ld.atStartOfDay().atZone(zone).toInstant(), zone);
        return clock;
    }

/*
    //@InterestingTestFactory
    public static Clock getAnotherSpecificDateForTesting() {
        LocalDate ld = LocalDate.of(1979,Month.APRIL,27);
        ZoneId zone = ZoneId.of("America/Los_Angeles");
        Clock clock = Clock.fixed(ld.atStartOfDay().atZone(zone).toInstant(), zone);
        return clock;
    }
*/
}
