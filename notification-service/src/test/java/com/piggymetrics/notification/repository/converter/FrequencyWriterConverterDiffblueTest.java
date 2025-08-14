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

@ContextConfiguration(classes = {FrequencyWriterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrequencyWriterConverterDiffblueTest {
  @Autowired private FrequencyWriterConverter frequencyWriterConverter;

  /**
   * Test {@link FrequencyWriterConverter#convert(Frequency)} with {@code Frequency}.
   *
   * <p>Method under test: {@link FrequencyWriterConverter#convert(Frequency)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer FrequencyWriterConverter.convert(Frequency)"})
  public void testConvertWithFrequency() {
    // Arrange, Act and Assert
    assertEquals(7, frequencyWriterConverter.convert(Frequency.WEEKLY).intValue());
  }
}
