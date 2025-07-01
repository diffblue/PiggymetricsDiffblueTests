package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.mongodb.DBObject;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DataPointIdWriterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataPointIdWriterConverterDiffblueTest {
  @Autowired private DataPointIdWriterConverter dataPointIdWriterConverter;

  /**
   * Test {@link DataPointIdWriterConverter#convert(DataPointId)} with {@code DataPointId}.
   *
   * <ul>
   *   <li>Then return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link DataPointIdWriterConverter#convert(DataPointId)}
   */
  @Test
  public void testConvertWithDataPointId_thenReturnMap() {
    // Arrange
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    DBObject actualConvertResult = dataPointIdWriterConverter.convert(new DataPointId("3", date));

    // Assert
    assertTrue(actualConvertResult instanceof Map);
    assertEquals(2, ((Map<String, Object>) actualConvertResult).size());
    assertEquals("3", ((Map<String, Object>) actualConvertResult).get("account"));
    assertSame(date, ((Map<String, Object>) actualConvertResult).get("date"));
  }
}
