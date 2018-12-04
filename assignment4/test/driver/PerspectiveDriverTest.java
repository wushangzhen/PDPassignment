package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class PerspectiveDriverTest {

  List<MovingViolationInfo> movingViolationList = new ArrayList<>();
  List<NoneMovingViolationInfo> noneMovingViolationList = new ArrayList<>();
  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  private final String NUMBER = "WWSZ";

  private final String FIRST_NAME_SECOND = "Shang";
  private final String LAST_NAME_SECOND = "Wu";
  private Name nameSecond = new Name(FIRST_NAME_SECOND, LAST_NAME_SECOND);

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfoIssuance = new DateInfo(YEAR, MONTH, DAY);
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);

  private final String YEAR_EXPIRATION = "2999";
  private final String MONTH_EXPIRATION = "03";
  private final String DAY_EXPIRATION = "02";
  DateInfo dateInfoExpiration = new DateInfo(YEAR_EXPIRATION, MONTH_EXPIRATION, DAY_EXPIRATION);

  private final String YEAR_BIRTHDAY = "2999";
  private final String MONTH_BIRTHDAY = "03";
  private final String DAY_BIRTHDAY = "02";
  DateInfo dateInfoBirthday = new DateInfo(YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY);
  private final String ADDRESS = "Boren";
  private final String STATE_OF_ISSUANCE = "ISSUED";
  LicenseInfo licenseInfo = new LicenseInfo(NUMBER, name, ADDRESS, dateInfoBirthday,
      Country.U_S, STATE_OF_ISSUANCE, dateInfoIssuance, dateInfoExpiration);

  MovingViolationInfo movingViolationInfo
      = new MovingViolationInfo(dateInfoIssuance, MovingVioType.SPEEDING, name);

  NoneMovingViolationInfo noneMovingViolationInfo
      = new NoneMovingViolationInfo(dateInfoIssuance, NoneMovingVioType.PARKING_VIOLATION, name);

  DriverHistory driverHistory;

  Crash crash = new Crash(dateInfoIssuance, CrashType.FENDER_BENDER, name);

  List<Crash> crashList;
  List<MovingViolationInfo> movingViolationInfoList;
  List<NoneMovingViolationInfo> noneMovingViolationInfoList;
  VehicleHistory vehicleHistory;
  PerspectiveDriver perspectiveDriver;


  private final String make = "BAY01FG";
  private final String model = "Blue Honda Accord";
  private final String year = "2014";
  private final String nameCar = "Ss";
  VehicleInfo vehicleInfo = new VehicleInfo(make, model, year, nameCar);
  Set<Name> set = new HashSet<>();
  InsuranceInfo insuranceInfo = new InsuranceInfo(name, set, dateInfo);

  @Test
  public void getName() {
    assertEquals(perspectiveDriver.getName(), name);
  }

  @Test
  public void setName() {
    perspectiveDriver.setName(nameSecond);
    assertEquals(perspectiveDriver.getName(), nameSecond);
  }

  @Test
  public void getBirthday() {
    assertEquals(perspectiveDriver.getBirthday(), dateInfoBirthday);
  }

  @Test
  public void setBirthday() {
    perspectiveDriver.setBirthday(dateInfo);
    assertEquals(perspectiveDriver.getBirthday(), dateInfo);
  }

  @Test
  public void getLicenseInfo() {
    assertEquals(perspectiveDriver.getLicenseInfo(), licenseInfo);
  }

  @Test
  public void setLicenseInfo() {
    licenseInfo.setExpirationDateInfo(dateInfoBirthday);
    perspectiveDriver.setLicenseInfo(licenseInfo);
    assertEquals(perspectiveDriver.getLicenseInfo(), licenseInfo);
  }

  @Test
  public void getVehicleInfo() {
    assertEquals(perspectiveDriver.getVehicleInfo(), vehicleInfo);
  }

  @Test
  public void setVehicleInfo() {
    perspectiveDriver.setVehicleInfo(vehicleInfo);
    assertEquals(perspectiveDriver.getVehicleInfo(), vehicleInfo);
  }

  @Test
  public void getInsuranceInfo() {
    assertEquals(perspectiveDriver.getInsuranceInfo(), insuranceInfo);
  }

  @Test
  public void setInsuranceInfo() {
    perspectiveDriver.setInsuranceInfo(insuranceInfo);
    assertEquals(perspectiveDriver.getInsuranceInfo(), insuranceInfo);
  }

  @Test
  public void getDriverHistory() {
    assertEquals(perspectiveDriver.getDriverHistory(), driverHistory);
  }

  @Test
  public void setDriverHistory() {
    perspectiveDriver.setDriverHistory(driverHistory);
    assertEquals(perspectiveDriver.getDriverHistory(), driverHistory);
  }

  @Test
  public void getVehicleHistory() {
    assertEquals(perspectiveDriver.getVehicleHistory(), vehicleHistory);
  }

  @Test
  public void setVehicleHistory() {
    perspectiveDriver.setVehicleHistory(vehicleHistory);
    assertEquals(perspectiveDriver.getVehicleHistory(), vehicleHistory);
  }

  @Test
  public void equals() {
    PerspectiveDriver perspectiveDriverTest
        = new PerspectiveDriver(name, dateInfoBirthday, licenseInfo, vehicleInfo,
        insuranceInfo, driverHistory, vehicleHistory);
    assertTrue(perspectiveDriverTest.equals(perspectiveDriver));
    assertTrue(perspectiveDriverTest.equals(perspectiveDriverTest));
    assertFalse(perspectiveDriver.equals(null));
    assertFalse(perspectiveDriver.equals(dateInfo));
    perspectiveDriverTest.setName(nameSecond);
    assertFalse(perspectiveDriver.equals(perspectiveDriverTest));
    perspectiveDriverTest.setDriverHistory(null);
    assertFalse(perspectiveDriver.equals(perspectiveDriverTest));
    perspectiveDriverTest.setDriverHistory(null);
    assertFalse(perspectiveDriver.equals(perspectiveDriverTest));
    perspectiveDriverTest.setInsuranceInfo(null);
    assertFalse(perspectiveDriver.equals(perspectiveDriverTest));
    perspectiveDriverTest.setVehicleHistory(null);
    assertFalse(perspectiveDriver.equals(perspectiveDriverTest));
    perspectiveDriverTest.setLicenseInfo(null);
    assertFalse(perspectiveDriver.equals(perspectiveDriverTest));
  }

  @Test
  public void hashCodeTest() {
    PerspectiveDriver perspectiveDriverTest
        = new PerspectiveDriver(name, dateInfoBirthday, licenseInfo, vehicleInfo,
        insuranceInfo, driverHistory, vehicleHistory);
    assertTrue(perspectiveDriver.hashCode() == perspectiveDriverTest.hashCode());
  }

  @Before
  public void setUp() throws Exception {
    noneMovingViolationList.add(noneMovingViolationInfo);
    movingViolationList.add(movingViolationInfo);
    driverHistory = new DriverHistory(noneMovingViolationList, movingViolationList);
    set.add(name);
    set.add(nameSecond);
    crashList = new ArrayList<>();
    movingViolationInfoList = new ArrayList<>();
    noneMovingViolationInfoList = new ArrayList<>();
    crashList.add(crash);
    movingViolationInfoList.add(movingViolationInfo);
    noneMovingViolationInfoList.add(noneMovingViolationInfo);
    vehicleHistory = new VehicleHistory(crashList,
        movingViolationInfoList, noneMovingViolationInfoList);
    perspectiveDriver = new PerspectiveDriver(name, dateInfoBirthday, licenseInfo, vehicleInfo,
        insuranceInfo, driverHistory, vehicleHistory);
  }
}