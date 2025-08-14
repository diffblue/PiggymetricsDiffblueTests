package com.piggymetrics.account.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CurrencyDiffblueTest {
  /**
   * Test {@link Currency#getDefault()}.
   *
   * <p>Method under test: {@link Currency#getDefault()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Currency Currency.getDefault()"})
  public void testGetDefault() {
    // Arrange, Act and Assert
    assertEquals(Currency.USD, Currency.valueOf("USD").getDefault());
  }
}
