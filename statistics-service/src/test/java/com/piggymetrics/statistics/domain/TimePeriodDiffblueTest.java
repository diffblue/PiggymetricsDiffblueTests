package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class TimePeriodDiffblueTest {
  /**
   * Method under test: {@link TimePeriod#getBase()}
   */
  @Test
  public void testGetBase() {
    // Arrange, Act and Assert
    assertEquals(TimePeriod.DAY, TimePeriod.valueOf("YEAR").getBase());
  }

  /**
   * Method under test: {@link TimePeriod#getBaseRatio()}
   */
  @Test
  public void testGetBaseRatio() {
    // Arrange and Act
    BigDecimal actualBaseRatio = TimePeriod.getBase().getBaseRatio();

    // Assert
    assertEquals(new BigDecimal("1"), actualBaseRatio);
  }
}
