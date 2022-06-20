package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TimePeriodDiffblueTest {
  /**
   * Method under test: {@link TimePeriod#getBaseRatio()}
   */
  @Test
  public void testGetBaseRatio() {
    // Arrange, Act and Assert
    assertEquals("1", TimePeriod.getBase().getBaseRatio().toString());
  }

  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link TimePeriod#valueOf(String)}
  *   <li>{@link TimePeriod#getBase()}
  * </ul>
  */
  @Test
  public void testValueOf() {
    // Arrange, Act and Assert
    assertEquals(TimePeriod.DAY, TimePeriod.valueOf("YEAR").getBase());
  }
}

