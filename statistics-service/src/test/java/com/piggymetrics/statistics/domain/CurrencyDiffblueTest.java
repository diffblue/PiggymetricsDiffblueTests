package com.piggymetrics.statistics.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CurrencyDiffblueTest {
  /**
   * Test {@link Currency#getBase()}.
   *
   * <p>Method under test: {@link Currency#getBase()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency Currency.getBase()"})
  public void testGetBase() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getBase());
  }
}
