package com.piggymetrics.notification.repository.converter;

import static org.junit.Assert.assertEquals;
import com.piggymetrics.notification.domain.Frequency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FrequencyReaderConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrequencyReaderConverterDiffblueTest {
  @Autowired
  private FrequencyReaderConverter frequencyReaderConverter;

  /**
   * Test {@link FrequencyReaderConverter#convert(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then returns {@code WEEKLY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrequencyReaderConverter#convert(Integer)}
   */
  @Test
  public void testConvertWithInteger_whenSeven_thenReturnsWeekly() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, frequencyReaderConverter.convert(7));
  }
}
