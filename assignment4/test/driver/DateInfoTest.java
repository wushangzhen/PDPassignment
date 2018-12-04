package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

public class DateInfoTest {

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);
  DateInfo dateInfoTest = new DateInfo(YEAR, MONTH, DAY);
  DateInfo dateInfoTestWrong = new DateInfo("1111", MONTH, DAY);

  @Test
  public void equals() {
    assertFalse(dateInfo.equals(dateInfoTestWrong));
    assertTrue(dateInfo.equals(dateInfo));
    assertTrue(dateInfo.equals(dateInfoTest));
    assertFalse(dateInfo.equals(null));
    assertFalse(dateInfo.equals(new Date()));
  }

  @Test
  public void toStringTest() {
    assertEquals(dateInfo.toString(), "1999.03.02");
  }

  @Test
  public void getYear() {
    assertEquals(dateInfo.getYear(), YEAR);
  }

  @Test
  public void setYear() {
    final String CHANGED_YEAR = "2222";
    dateInfo.setYear(CHANGED_YEAR);
    assertEquals(dateInfo.getYear(), CHANGED_YEAR);
  }

  @Test
  public void getMonth() {
    assertEquals(dateInfo.getMonth(), MONTH);
  }

  @Test
  public void setMonth() {
    final String CHANGED_MONTH = "12";
    dateInfo.setMonth(CHANGED_MONTH);
    assertEquals(dateInfo.getMonth(), CHANGED_MONTH);
  }

  @Test
  public void getDay() {
    assertEquals(dateInfo.getDay(), DAY);
  }

  @Test
  public void setDay() {
    final String CHANGED_DAY = "22";
    dateInfo.setDay(CHANGED_DAY);
    assertEquals(dateInfo.getDay(), CHANGED_DAY);
  }

  @Test
  public void hashCodeTest() {
    assertTrue(dateInfo.hashCode() == dateInfoTest.hashCode());
  }
}