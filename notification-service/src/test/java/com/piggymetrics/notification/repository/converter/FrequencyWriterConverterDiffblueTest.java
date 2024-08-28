package com.piggymetrics.notification.repository.converter;

import static org.junit.Assert.assertEquals;
import com.piggymetrics.notification.domain.Frequency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FrequencyWriterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrequencyWriterConverterDiffblueTest {
  @Autowired
  private FrequencyWriterConverter frequencyWriterConverter;

  /**
   * Method under test: {@link FrequencyWriterConverter#convert(Frequency)}
   */
  @Test
  public void testConvert_whenWeekly_thenReturnsIntValueIsSeven() {
    // Arrange, Act and Assert
    assertEquals(7, frequencyWriterConverter.convert(Frequency.WEEKLY).intValue());
  }
}
