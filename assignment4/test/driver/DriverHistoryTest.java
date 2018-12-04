package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {

  List<MovingViolationInfo> movingViolationList = new ArrayList<>();
  List<NoneMovingViolationInfo> noneMovingViolationList = new ArrayList<>();

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  MovingViolationInfo movingViolationInfo
      = new MovingViolationInfo(dateInfo, MovingVioType.SPEEDING, name);

  NoneMovingViolationInfo noneMovingViolationInfo
      = new NoneMovingViolationInfo(dateInfo, NoneMovingVioType.PARKING_VIOLATION, name);

  DriverHistory driverHistory;
  DriverHistory driverHistoryTest;
  DriverHistory driverHistoryTestWrong;

  @Test
  public void equals() {
    Assert.assertTrue(driverHistory.equals(driverHistoryTest));
    Assert.assertTrue(driverHistory.equals(driverHistory));
    Assert.assertFalse(driverHistory.equals(null));
    Assert.assertFalse(driverHistory.equals(new Date()));
    Assert.assertFalse(driverHistory.equals(driverHistoryTestWrong));

  }

  @Test
  public void hashCodeTest() {
    Assert.assertTrue(driverHistory.hashCode() == driverHistoryTest.hashCode());
  }

  @Before
  public void setUp() throws Exception {
    noneMovingViolationList.add(noneMovingViolationInfo);
    movingViolationList.add(movingViolationInfo);
    driverHistory = new DriverHistory(noneMovingViolationList, movingViolationList);
    driverHistoryTest = new DriverHistory(noneMovingViolationList, movingViolationList);
    driverHistoryTestWrong = new DriverHistory(new ArrayList<>(), new ArrayList<>());

  }

  @Test
  public void setNoneMovingVioList() {
    noneMovingViolationList.remove(NoneMovingVioType.PARKING_VIOLATION);
    driverHistory.setNoneMovingVioList(noneMovingViolationList);
    Assert.assertEquals(driverHistory.getNoneMovingVioList(), noneMovingViolationList);
  }

  @Test
  public void setMovingVioList() {
    movingViolationList.remove(MovingVioType.FAILURE_TO_RESPECT_TRAFFIC_SIGNS);
    driverHistory.setMovingVioList(movingViolationList);
    Assert.assertEquals(driverHistory.getMovingVioList(), movingViolationList);
  }

  @Test
  public void getNoneMovingVioList() {
    Assert.assertEquals(driverHistory.getNoneMovingVioList(), noneMovingViolationList);
  }

  @Test
  public void getMovingVioList() {
    Assert.assertEquals(driverHistory.getMovingVioList(), movingViolationList);
  }
}