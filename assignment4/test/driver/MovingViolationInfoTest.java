package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovingViolationInfoTest {

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  MovingViolationInfo movingViolationInfo
      = new MovingViolationInfo(dateInfo, MovingVioType.SPEEDING, name);

  @Test
  public void getDateInfo() {
    assertEquals(movingViolationInfo.getDateInfo(), dateInfo);
  }

  @Test
  public void setDateInfo() {
    dateInfo.setYear("1199");
    movingViolationInfo.setDateInfo(dateInfo);
    assertEquals(movingViolationInfo.getDateInfo(), dateInfo);
  }

  @Test
  public void getMovingVioType() {
    assertEquals(movingViolationInfo.getMovingVioType(), MovingVioType.SPEEDING);
  }

  @Test
  public void setMovingVioType() {
    movingViolationInfo.setMovingVioType(MovingVioType.DRIVING_WITHOUT_VALID_INSURANCE);
    assertEquals(movingViolationInfo.getMovingVioType(),
        MovingVioType.DRIVING_WITHOUT_VALID_INSURANCE);
  }

  @Test
  public void getOffendingDriver() {
    assertEquals(movingViolationInfo.getOffendingDriver(), name);
  }

  @Test
  public void setOffendingDriver() {
    name.setLastName("x");
    movingViolationInfo.setOffendingDriver(name);
    assertEquals(movingViolationInfo.getOffendingDriver(), name);
  }

}