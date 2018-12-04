package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  Crash crash = new Crash(dateInfo, CrashType.FENDER_BENDER, name);

  MovingViolationInfo movingViolationInfo
      = new MovingViolationInfo(dateInfo, MovingVioType.SPEEDING, name);

  NoneMovingViolationInfo noneMovingViolationInfo
      = new NoneMovingViolationInfo(dateInfo, NoneMovingVioType.PAPERWORK_ISSUES, name);

  List<Crash> crashList;
  List<MovingViolationInfo> movingViolationInfoList;
  List<NoneMovingViolationInfo> noneMovingViolationInfoList;
  VehicleHistory vehicleHistory;

  @Test
  public void getCrashList() {
    assertEquals(vehicleHistory.getCrashList(), crashList);
  }

  @Test
  public void setCrashList() {
    vehicleHistory.setCrashList(null);
    assertEquals(vehicleHistory.getCrashList(), null);
  }

  @Test
  public void getMovingViolationInfoList() {
    assertEquals(vehicleHistory.getMovingViolationInfoList(), movingViolationInfoList);
  }

  @Test
  public void setMovingViolationInfoList() {
    vehicleHistory.setMovingViolationInfoList(null);
    assertEquals(vehicleHistory.getMovingViolationInfoList(), null);
  }

  @Test
  public void getNoneMovingViolationInfo() {
    assertEquals(vehicleHistory.getNoneMovingViolationInfo(), noneMovingViolationInfoList);
  }

  @Test
  public void setNoneMovingViolationInfo() {
    vehicleHistory.setNoneMovingViolationInfo(null);
    assertEquals(vehicleHistory.getNoneMovingViolationInfo(), null);
  }

  @Before
  public void setUp() throws Exception {
    crashList = new ArrayList<>();
    movingViolationInfoList = new ArrayList<>();
    noneMovingViolationInfoList = new ArrayList<>();
    crashList.add(crash);
    movingViolationInfoList.add(movingViolationInfo);
    noneMovingViolationInfoList.add(noneMovingViolationInfo);
    vehicleHistory = new VehicleHistory(crashList,
        movingViolationInfoList, noneMovingViolationInfoList);
  }
}