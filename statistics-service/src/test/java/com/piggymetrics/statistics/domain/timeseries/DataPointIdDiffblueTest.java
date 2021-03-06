package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;

public class DataPointIdDiffblueTest {
  /**
  * Methods under test: 
  * 
  * <ul>
  *   <li>{@link DataPointId#DataPointId(String, Date)}
  *   <li>{@link DataPointId#toString()}
  *   <li>{@link DataPointId#getAccount()}
  *   <li>{@link DataPointId#getDate()}
  * </ul>
  */
  @Test
  public void testConstructor() {
    // Arrange
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

    // Act
    DataPointId actualDataPointId = new DataPointId("3", fromResult);
    actualDataPointId.toString();

    // Assert
    assertEquals("3", actualDataPointId.getAccount());
    assertSame(fromResult, actualDataPointId.getDate());
  }
}

