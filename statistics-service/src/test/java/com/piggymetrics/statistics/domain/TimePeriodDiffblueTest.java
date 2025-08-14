package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TimePeriodDiffblueTest {
  /**
   * Test {@link TimePeriod#getBaseRatio()}.
   *
   * <p>Method under test: {@link TimePeriod#getBaseRatio()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal TimePeriod.getBaseRatio()"})
  public void testGetBaseRatio() {
    // Arrange and Act
    BigDecimal actualBaseRatio = TimePeriod.YEAR.getBaseRatio();

    // Assert
    assertEquals(
        new BigDecimal("365.24250000000000682121026329696178436279296875"), actualBaseRatio);
  }

  /**
   * Test {@link TimePeriod#getBase()}.
   *
   * <p>Method under test: {@link TimePeriod#getBase()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TimePeriod TimePeriod.getBase()"})
  public void testGetBase() {
    // Arrange, Act and Assert
    assertEquals(TimePeriod.DAY, TimePeriod.valueOf("YEAR").getBase());
  }
}
