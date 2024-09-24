package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrequencyDiffblueTest {
  /**
   * Test {@link com.piggymetrics.notification.domain.Frequency#getDays()}.
   */
  @Test
  public void testGetDays() {
    // Arrange, Act and Assert
    assertEquals(7, Frequency.valueOf("WEEKLY").getDays());
  }

  /**
   * Test {@link com.piggymetrics.notification.domain.Frequency#withDays(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then returns {@code WEEKLY}.</li>
   * <ul>
   */
  @Test
  public void testWithDays_whenSeven_thenReturnsWeekly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, Frequency.withDays(7));
  }
}
