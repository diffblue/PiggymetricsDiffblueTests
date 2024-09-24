package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DataPointIdWriterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataPointIdWriterConverterDiffblueTest {
  @Autowired
  private DataPointIdWriterConverter dataPointIdWriterConverter;

  /**
   * Test
   * {@link com.piggymetrics.statistics.repository.converter.DataPointIdWriterConverter#convert(DataPointId)}.
   */
  @Test
  public void testConvert() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    DBObject actualConvertResult = dataPointIdWriterConverter.convert(new DataPointId("3", date));

    // Assert
    assertTrue(actualConvertResult instanceof BasicDBObject);
    assertEquals(2, ((BasicDBObject) actualConvertResult).size());
    assertEquals("3", ((BasicDBObject) actualConvertResult).get((Object) "account"));
    assertSame(date, ((BasicDBObject) actualConvertResult).get((Object) "date"));
  }

  /**
   * Test
   * {@link com.piggymetrics.statistics.repository.converter.DataPointIdWriterConverter#convert(DataPointId)}.
   * <ul>
   *   <li>When
   * {@link com.piggymetrics.statistics.domain.timeseries.DataPointId#DataPointId(String, Date)}
   * with account is {@code 3} and {@link java.sql.Date}.</li>
   *   <li>Then returns containsKey {@code date}.</li>
   * <ul>
   */
  @Test
  public void testConvert_whenDataPointIdWithAccountIs3AndDate_thenReturnsContainsKeyDate() {
    // Arrange and Act
    DBObject actualConvertResult = dataPointIdWriterConverter.convert(new DataPointId("3", mock(java.sql.Date.class)));

    // Assert
    assertTrue(actualConvertResult instanceof BasicDBObject);
    assertEquals(2, ((BasicDBObject) actualConvertResult).size());
    assertEquals("3", ((BasicDBObject) actualConvertResult).get((Object) "account"));
    assertTrue(((BasicDBObject) actualConvertResult).containsKey((Object) "date"));
  }
}
