package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import com.mongodb.BasicDBObject;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {DataPointIdWriterConverter.class})
@RunWith(SpringRunner.class)
public class DataPointIdWriterConverterDiffblueTest {
  @Autowired
  private DataPointIdWriterConverter dataPointIdWriterConverter;
  @Test
  public void testConvert() {
    // Arrange, Act and Assert
    assertEquals(2,
        ((BasicDBObject) this.dataPointIdWriterConverter.convert(new DataPointId("3", new Date(1L)))).size());
    assertEquals(2,
        ((BasicDBObject) this.dataPointIdWriterConverter.convert(new DataPointId("date", new Date(-1L)))).size());
  }
}

