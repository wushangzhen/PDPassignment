package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrashTest {

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  Crash crash = new Crash(dateInfo, CrashType.FENDER_BENDER, name);

  @Test
  public void getDate() {
    assertEquals(crash.getDate(), dateInfo);
  }

  @Test
  public void setDate() {
    final String YEAR = "1998";
    final String MONTH = "03";
    final String DAY = "02";
    DateInfo dateInfoChanged = new DateInfo(YEAR, MONTH, DAY);
    crash.setDate(dateInfoChanged);
    assertEquals(crash.getDate(), dateInfoChanged);
  }

  @Test
  public void getCrashType() {
    assertEquals(crash.getCrashType(), CrashType.FENDER_BENDER);
  }

  @Test
  public void setCrashType() {
    crash.setCrashType(CrashType.CRASH_WITH_BODILY_INJURIES);
    assertEquals(crash.getCrashType(), CrashType.CRASH_WITH_BODILY_INJURIES);
  }

  @Test
  public void getName() {
    Name nameTest = new Name(FIRST_NAME, LAST_NAME);
    assertEquals(crash.getName(), nameTest);
  }

  @Test
  public void setName() {
    Name nameTest = new Name(FIRST_NAME, LAST_NAME);
    crash.setName(nameTest);
    assertEquals(crash.getName(), nameTest);
  }
}