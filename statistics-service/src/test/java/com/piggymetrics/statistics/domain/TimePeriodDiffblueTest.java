package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class TimePeriodDiffblueTest {
  /**
   * Test {@link com.piggymetrics.statistics.domain.TimePeriod#getBase()}.
   */
  @Test
  public void testGetBase() {
    // Arrange, Act and Assert
    assertEquals(TimePeriod.DAY, TimePeriod.valueOf("YEAR").getBase());
  }

  /**
   * Test {@link com.piggymetrics.statistics.domain.TimePeriod#getBaseRatio()}.
   */
  @Test
  public void testGetBaseRatio() {
    // Arrange and Act
    BigDecimal actualBaseRatio = TimePeriod.YEAR.getBaseRatio();

    // Assert
    assertEquals(new BigDecimal("365.24250000000000682121026329696178436279296875"), actualBaseRatio);
  }
}
