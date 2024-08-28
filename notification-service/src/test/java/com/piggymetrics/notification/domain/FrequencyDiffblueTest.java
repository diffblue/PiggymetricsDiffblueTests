package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrequencyDiffblueTest {
  /**
   * Method under test: {@link Frequency#getDays()}
   */
  @Test
  public void testGetDays_thenReturnsSeven() {
    // Arrange, Act and Assert
    assertEquals(7, Frequency.valueOf("WEEKLY").getDays());
  }

  /**
   * Method under test: {@link Frequency#withDays(int)}
   */
  @Test
  public void testWithDays_whenSeven_thenReturnsWeekly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, Frequency.withDays(7));
  }
}
