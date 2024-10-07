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
   *   <li>Then returns {@code WEEKLY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Frequency#withDays(int)}
   */
  @Test
  public void testWithDays_whenSeven_thenReturnsWeekly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, Frequency.withDays(7));
  }
}
