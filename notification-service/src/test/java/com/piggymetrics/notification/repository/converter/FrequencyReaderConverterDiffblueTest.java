package com.piggymetrics.notification.repository.converter;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.piggymetrics.notification.domain.Frequency;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FrequencyReaderConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrequencyReaderConverterDiffblueTest {
  @Autowired private FrequencyReaderConverter frequencyReaderConverter;

  /**
   * Test {@link FrequencyReaderConverter#convert(Integer)} with {@code Integer}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code WEEKLY}.
   * </ul>
   *
   * <p>Method under test: {@link FrequencyReaderConverter#convert(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Frequency FrequencyReaderConverter.convert(Integer)"})
  public void testConvertWithInteger_whenSeven_thenReturnWeekly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, frequencyReaderConverter.convert(7));
  }

  /**
   * Test {@link FrequencyReaderConverter#convert(Integer)} with {@code Integer}.
   *
   * <ul>
   *   <li>When thirty.
   *   <li>Then return {@code MONTHLY}.
   * </ul>
   *
   * <p>Method under test: {@link FrequencyReaderConverter#convert(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Frequency FrequencyReaderConverter.convert(Integer)"})
  public void testConvertWithInteger_whenThirty_thenReturnMonthly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.MONTHLY, frequencyReaderConverter.convert(30));
  }
}
