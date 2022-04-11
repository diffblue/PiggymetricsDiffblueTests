package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrequencyDiffblueTest {
  /**
  * Method under test: {@link Frequency#valueOf(String)}
  */
  @Test
  public void testValueOf() {
    // Arrange, Act and Assert
    assertEquals(7, Frequency.valueOf("WEEKLY").getDays());
  }

  /**
   * Method under test: {@link Frequency#withDays(int)}
   */
  @Test
  public void testWithDays() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, Frequency.withDays(7));
  }
}

