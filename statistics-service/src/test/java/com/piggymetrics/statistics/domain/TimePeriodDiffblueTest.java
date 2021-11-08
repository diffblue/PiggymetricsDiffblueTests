package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class TimePeriodDiffblueTest {
  @Test
  public void testGetBaseRatio() {
    // Arrange, Act and Assert
    assertEquals("365.24250000000000682121026329696178436279296875", TimePeriod.YEAR.getBaseRatio().toString());
  }

  @Test
  public void testValueOf() {
    // Arrange, Act and Assert
    BigDecimal baseRatio = TimePeriod.valueOf("YEAR").getBaseRatio();
    assertEquals(44, baseRatio.scale());
    assertEquals("365.24250000000000682121026329696178436279296875", baseRatio.toString());
    assertEquals(1, baseRatio.signum());
  }
}

