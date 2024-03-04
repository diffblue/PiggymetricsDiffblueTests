package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import com.mongodb.BasicDBObject;
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
    // Arrange, Act and Assert
    assertEquals(2, ((BasicDBObject) dataPointIdWriterConverter.convert(
        new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))))
            .size());
  }
}
