package com.piggymetrics.notification.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FrequencyDiffblueTest {
  @Test
  public void testWithDays() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, Frequency.withDays(7));
  }
}
