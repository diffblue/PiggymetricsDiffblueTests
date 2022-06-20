package com.piggymetrics.statistics.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.piggymetrics.statistics.domain.Currency;
import com.piggymetrics.statistics.domain.ExchangeRatesContainer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ExchangeRatesClientFallback.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExchangeRatesClientFallbackDiffblueTest {
  @Autowired
  private ExchangeRatesClientFallback exchangeRatesClientFallback;
  /**
  * Method under test: {@link ExchangeRatesClientFallback#getRates(Currency)}
  */
  @Test
  public void testGetRates() {
    // Arrange and Act
    ExchangeRatesContainer actualRates = exchangeRatesClientFallback.getRates(Currency.USD);

    // Assert
    assertEquals(Currency.USD, actualRates.getBase());
    assertTrue(actualRates.getRates().isEmpty());
  }
}

