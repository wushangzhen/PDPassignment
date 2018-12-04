package edu.neu.ccs.cs5010.assignment3.part2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test class for Row.
 */
public class RowTest {
  private final int ROW_NUM = 0;
  private final int NUMBER = 10;
  private final int CHANGED_ROW_NUM = 1;
  private final int CHANGED_NUMBER = 1;
  private final boolean IS_ACCESSIBLE = false;
  private Row row = new Row(ROW_NUM, NUMBER, IS_ACCESSIBLE);

  @Test
  public void init() {
    row.init(NUMBER);
    Row rowTest = new Row(ROW_NUM, NUMBER, IS_ACCESSIBLE);
    for (char i = 'A'; i < 'A'+ NUMBER; i++) {
      rowTest.add(new Seat(String.valueOf(i), null));
    }
    assertTrue(row.equals(rowTest));
  }

  @Test
  public void setRowNum() {
    row.setRowNum(CHANGED_ROW_NUM);
    assertEquals(row.getRowNum(), CHANGED_ROW_NUM);
  }

  @Test
  public void isAccessible() {
    assertEquals(row.isAccessible(), false);
  }

  @Test
  public void setAccessible() {
    row.setAccessible(true);
    assertEquals(row.isAccessible(), true);
  }

  @Test
  public void getRowNum() {
    assertEquals(row.getRowNum(), ROW_NUM);
  }

  @Test
  public void equals() {
    Row rowTest = new Row(ROW_NUM, CHANGED_NUMBER, IS_ACCESSIBLE);
    Row newRow = new Row(ROW_NUM, NUMBER, IS_ACCESSIBLE);
    assertTrue(row.equals(row));
    assertTrue(row.equals(newRow));
    assertFalse(row.equals(""));
    assertFalse(row.equals(rowTest));
    rowTest.clear();
    for (char i = 'B'; i < 'B'+ NUMBER; i++) {
      rowTest.add(new Seat(String.valueOf(i), null));
    }
    assertFalse(row.equals(rowTest));
    assertFalse(row.equals(null));
  }
}