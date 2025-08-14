package com.piggymetrics.statistics.domain.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataPointIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataPointId#DataPointId(String, Date)}
   *   <li>{@link DataPointId#toString()}
   *   <li>{@link DataPointId#getAccount()}
   *   <li>{@link DataPointId#getDate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataPointId.<init>(String, Date)",
    "String DataPointId.getAccount()",
    "Date DataPointId.getDate()",
    "String DataPointId.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    DataPointId actualDataPointId = new DataPointId("3", date);
    actualDataPointId.toString();
    String actualAccount = actualDataPointId.getAccount();

    // Assert
    assertEquals("3", actualAccount);
    assertSame(date, actualDataPointId.getDate());
  }
}
