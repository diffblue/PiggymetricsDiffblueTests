package com.piggymetrics.notification.repository.converter;

import static org.junit.Assert.assertEquals;
import com.piggymetrics.notification.domain.Frequency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {FrequencyReaderConverter.class})
@RunWith(SpringRunner.class)
public class FrequencyReaderConverterDiffblueTest {
  @Autowired
  private FrequencyReaderConverter frequencyReaderConverter;
  @Test
  public void testConvert() {
    // Arrange, Act and Assert
    assertEquals(Frequency.WEEKLY, this.frequencyReaderConverter.convert(7));
  }
}

