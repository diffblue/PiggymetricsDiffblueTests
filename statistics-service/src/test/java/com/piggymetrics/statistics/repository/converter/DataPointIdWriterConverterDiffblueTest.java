package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mongodb.DBObject;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DBObject DataPointIdWriterConverter.convert(DataPointId)"})
  public void testConvertWithDataPointId_thenReturnMap() {
    // Arrange
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    DataPointId id = new DataPointId("3", date);

    // Act
    DBObject actualConvertResult = dataPointIdWriterConverter.convert(id);

    // Assert
    assertTrue(actualConvertResult instanceof Map);
    assertEquals(2, ((Map<String, Object>) actualConvertResult).size());
    assertEquals("3", ((Map<String, Object>) actualConvertResult).get("account"));
    assertSame(date, ((Map<String, Object>) actualConvertResult).get("date"));
  }
}
