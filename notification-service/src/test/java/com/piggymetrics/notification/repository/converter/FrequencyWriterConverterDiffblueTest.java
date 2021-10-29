package com.piggymetrics.notification.repository.converter;

import static org.junit.Assert.assertEquals;
import com.piggymetrics.notification.domain.Frequency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {FrequencyWriterConverter.class})
@RunWith(SpringRunner.class)
public class FrequencyWriterConverterDiffblueTest {
  @Autowired
  private FrequencyWriterConverter frequencyWriterConverter;
  @Test
  public void testConvert() {
    // Arrange, Act and Assert
    assertEquals(7, this.frequencyWriterConverter.convert(Frequency.WEEKLY).intValue());
  }
}
