package com.piggymetrics.statistics.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.ExchangeRatesContainer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ExchangeRatesClientFallback.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExchangeRatesClientFallbackDiffblueTest {
  @Autowired private ExchangeRatesClientFallback exchangeRatesClientFallback;

  /**
   * Test {@link ExchangeRatesClientFallback#getRates(Currency)}.
   *
   * <p>Method under test: {@link ExchangeRatesClientFallback#getRates(Currency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExchangeRatesContainer ExchangeRatesClientFallback.getRates(Currency)"})
  public void testGetRates() {
    // Arrange and Act
    ExchangeRatesContainer actualRates = exchangeRatesClientFallback.getRates(Currency.USD);

    // Assert
    assertEquals(Currency.USD, actualRates.getBase());
    assertTrue(actualRates.getRates().isEmpty());
  }
}
