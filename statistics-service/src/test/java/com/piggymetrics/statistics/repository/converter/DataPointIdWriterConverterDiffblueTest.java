package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import com.mongodb.BasicDBObject;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
  @Test
  public void testConvert() {
    // Arrange
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act and Assert
    assertEquals(2, ((BasicDBObject) this.dataPointIdWriterConverter
        .convert(new DataPointId("3", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())))).size());
  }
}

