package org.example.junit4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DummyJunitDiffblueTest {

  @Test
  public void testEquality() {
    // The following line will fail to compile if the project uses the groovy compiler for java
    // sources
    final String[] array = {"foo", "bar", "baz"};
    for (int i = 0; i < array.length; i++) {
      assertEquals(array[i], array[i]);
    }
  }
}