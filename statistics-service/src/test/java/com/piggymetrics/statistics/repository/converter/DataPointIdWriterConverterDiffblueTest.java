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
   * Method under test: {@link DataPointIdWriterConverter#convert(DataPointId)}
   */
  @Test
  public void testConvert() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);

    // Act
    DBObject actualConvertResult = dataPointIdWriterConverter.convert(id);

    // Assert
    assertTrue(actualConvertResult instanceof BasicDBObject);
    assertEquals(2, ((BasicDBObject) actualConvertResult).size());
    Object getResult = ((BasicDBObject) actualConvertResult).get((Object) "account");
    assertEquals("3", getResult);
    assertSame(getResult, id.getAccount());
    assertSame(date, id.getDate());
    assertSame(date, ((BasicDBObject) actualConvertResult).get((Object) "date"));
  }

  /**
   * Method under test: {@link DataPointIdWriterConverter#convert(DataPointId)}
   */
  @Test
  public void testConvert2() {
    // Arrange
    DataPointId id = new DataPointId("3", mock(java.sql.Date.class));

    // Act
    DBObject actualConvertResult = dataPointIdWriterConverter.convert(id);

    // Assert
    assertTrue(actualConvertResult instanceof BasicDBObject);
    assertEquals(2, ((BasicDBObject) actualConvertResult).size());
    Object getResult = ((BasicDBObject) actualConvertResult).get((Object) "account");
    assertEquals("3", getResult);
    assertTrue(((BasicDBObject) actualConvertResult).containsKey((Object) "date"));
    assertSame(getResult, id.getAccount());
    Object expectedDate = ((BasicDBObject) actualConvertResult).get((Object) "date");
    assertSame(expectedDate, id.getDate());
  }
}
