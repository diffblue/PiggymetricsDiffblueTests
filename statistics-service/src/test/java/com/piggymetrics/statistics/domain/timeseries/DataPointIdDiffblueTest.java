package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class DataPointIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataPointId#DataPointId(String, Date)}
   *   <li>{@link DataPointId#toString()}
   *   <li>{@link DataPointId#getAccount()}
   *   <li>{@link DataPointId#getDate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    DataPointId actualDataPointId = new DataPointId("3", date);
    actualDataPointId.toString();
    String actualAccount = actualDataPointId.getAccount();

    // Assert
    assertEquals("3", actualAccount);
    assertSame(date, actualDataPointId.getDate());
  }
}
