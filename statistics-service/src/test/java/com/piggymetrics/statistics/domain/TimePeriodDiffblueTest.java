package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class TimePeriodDiffblueTest {
  /**
   * Method under test: {@link TimePeriod#getBaseRatio()}
   */
  @Test
  public void testGetBaseRatio_givenYear_thenReturnsNewBigDecimalWith365Dot24250000000000682121026329696178436279296875() {
    // Arrange and Act
    BigDecimal actualBaseRatio = TimePeriod.YEAR.getBaseRatio();

    // Assert
    assertEquals(new BigDecimal("365.24250000000000682121026329696178436279296875"), actualBaseRatio);
  }

  /**
   * Method under test: {@link TimePeriod#getBase()}
   */
  @Test
  public void testGetBase_givenValueOfYear_thenReturnsDay() {
    // Arrange, Act and Assert
    assertEquals(TimePeriod.DAY, TimePeriod.valueOf("YEAR").getBase());
  }
}
