package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
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
    // Arrange, Act and Assert
    assertEquals("1", TimePeriod.getBase().getBaseRatio().toString());
  }
}

