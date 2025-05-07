package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrequencyDiffblueTest {
  /**
   * Test {@link Frequency#getDays()}.
   * <p>
   * Method under test: {@link Frequency#getDays()}
   */
  @Test
  public void testGetDays() {
    // Arrange, Act and Assert
    assertEquals(7, Frequency.valueOf("WEEKLY").getDays());
  }

  /**
   * Test {@link Frequency#withDays(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code WEEKLY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Frequency#withDays(int)}
   */
  @Test
  public void testWithDays_whenSeven_thenReturnWeekly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, Frequency.withDays(7));
  }

  /**
   * Test {@link Frequency#withDays(int)}.
   * <ul>
   *   <li>When thirty.</li>
   *   <li>Then return {@code MONTHLY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Frequency#withDays(int)}
   */
  @Test
  public void testWithDays_whenThirty_thenReturnMonthly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.MONTHLY, Frequency.withDays(30));
  }
}
