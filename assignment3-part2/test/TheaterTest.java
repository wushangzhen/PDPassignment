package edu.neu.ccs.cs5010.assignment3.part2;

import static org.junit.Assert.*;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for theater.
 */
public class TheaterTest {
  List<Integer> accessibleSeatList = new ArrayList<>();
  Theater theater = new Theater("Roxy", 10, 7, accessibleSeatList);
  @Before
  public void setUp() throws Exception {
    accessibleSeatList.add(1);
    accessibleSeatList.add(3);
    accessibleSeatList.add(5);
  }

  @Test
  public void initRows() {
    Row[] rows = theater.getRows();
    Row[] rowTest = new Row[10];
    for (int i = 0; i < 10; i++) {
      rowTest[i] = new Row(i, 7, false);
    }
    assertEquals(rows.length, rowTest.length);
    for (int i = 0; i < rows.length; i++) {
      assertTrue(rows[i].equals(rowTest[i]));
    }
  }

  @Test
  public void getName() {
    assertEquals(theater.getName(), "Roxy");
  }

  @Test
  public void setName() {
    theater.setName("xxx");
    assertEquals(theater.getName(), "xxx");
  }

  @Test
  public void getRows() {
    Row[] rows = theater.getRows();
    Row[] rowTest = new Row[10];
    for (int i = 0; i < 10; i++) {
      rowTest[i] = new Row(i, 7, false);
    }
    for (int i = 0; i < rows.length; i++) {
      assertTrue(rows[i].equals(rowTest[i]));
    }
  }

  @Test
  public void setRows() {
    Row[] rowTest = new Row[10];
    for (int i = 0; i < 10; i++) {
      rowTest[i] = new Row(i, 7, false);
    }
    theater.setRows(rowTest);
    Row[] rows = theater.getRows();
    for (int i = 0; i < rows.length; i++) {
      assertTrue(rows[i].equals(rowTest[i]));
    }
  }

  @Test
  public void getTheaterSeat() {
    assertEquals(theater.getTheaterSeat(), new String[10][7]);
  }

  @Test
  public void setTheaterSeat() {
    theater.setTheaterSeat(new String[1][7]);
    assertEquals(theater.getTheaterSeat(), new String[1][7]);
  }

  @Test
  public void getOrderSeatNumber() {
    assertEquals(theater.getOrderSeatNumber(), 0);
  }

  @Test
  public void setOrderSeatNumber() {
    theater.setOrderSeatNumber(1);
    assertEquals(theater.getOrderSeatNumber(), 1);
  }

  @Test
  public void getAccessibleRowList() {
    List<Integer> accessibleSeatList = new ArrayList<>();
    accessibleSeatList.add(1);
    accessibleSeatList.add(3);
    accessibleSeatList.add(5);
    assertEquals(theater.getAccessibleRowList(), accessibleSeatList);

  }

  @Test
  public void setAccessibleRowList() {
    List<Integer> accessibleSeatList = new ArrayList<>();
    accessibleSeatList.add(1);
    accessibleSeatList.add(3);
    accessibleSeatList.add(4);
    theater.setAccessibleRowList(accessibleSeatList);
    assertEquals(theater.getAccessibleRowList(), accessibleSeatList);
  }
}