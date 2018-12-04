package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoneMovingViolationInfoTest {

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  NoneMovingViolationInfo noneMovingViolationInfo
      = new NoneMovingViolationInfo(dateInfo, NoneMovingVioType.PAPERWORK_ISSUES, name);

  @Test
  public void getDateInfo() {
    assertEquals(noneMovingViolationInfo.getDateInfo(), dateInfo);
  }

  @Test
  public void setDateInfo() {
    dateInfo.setYear("1199");
    noneMovingViolationInfo.setDateInfo(dateInfo);
    assertEquals(noneMovingViolationInfo.getDateInfo(), dateInfo);
  }

  @Test
  public void getMovingVioType() {
    assertEquals(noneMovingViolationInfo.getNoneMovingVioType(),
        NoneMovingVioType.PAPERWORK_ISSUES);
  }

  @Test
  public void setMovingVioType() {
    noneMovingViolationInfo.setNoneMovingVioType(NoneMovingVioType.PARKING_VIOLATION);
    assertEquals(noneMovingViolationInfo.getNoneMovingVioType(),
        NoneMovingVioType.PARKING_VIOLATION);
  }

  @Test
  public void getOffendingDriver() {
    assertEquals(noneMovingViolationInfo.getOffendingDriver(), name);
  }

  @Test
  public void setOffendingDriver() {
    name.setLastName("x");
    noneMovingViolationInfo.setOffendingDriver(name);
    assertEquals(noneMovingViolationInfo.getOffendingDriver(), name);
  }

}