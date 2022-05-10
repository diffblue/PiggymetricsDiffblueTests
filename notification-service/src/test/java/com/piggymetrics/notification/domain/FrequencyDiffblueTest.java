package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrequencyDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link Frequency#valueOf(String)}
  *   <li>{@link Frequency#getDays()}
  * </ul>
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

