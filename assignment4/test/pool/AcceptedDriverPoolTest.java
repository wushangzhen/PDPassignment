package edu.neu.ccs.cs5010.assignment4.pool;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment4.driver.Country;
import edu.neu.ccs.cs5010.assignment4.driver.Crash;
import edu.neu.ccs.cs5010.assignment4.driver.CrashType;
import edu.neu.ccs.cs5010.assignment4.driver.DateInfo;
import edu.neu.ccs.cs5010.assignment4.driver.DriverHistory;
import edu.neu.ccs.cs5010.assignment4.driver.InsuranceInfo;
import edu.neu.ccs.cs5010.assignment4.driver.LicenseInfo;
import edu.neu.ccs.cs5010.assignment4.driver.MovingVioType;
import edu.neu.ccs.cs5010.assignment4.driver.MovingViolationInfo;
import edu.neu.ccs.cs5010.assignment4.driver.Name;
import edu.neu.ccs.cs5010.assignment4.driver.NoneMovingVioType;
import edu.neu.ccs.cs5010.assignment4.driver.NoneMovingViolationInfo;
import edu.neu.ccs.cs5010.assignment4.driver.PerspectiveDriver;
import edu.neu.ccs.cs5010.assignment4.driver.VehicleHistory;
import edu.neu.ccs.cs5010.assignment4.driver.VehicleInfo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AcceptedDriverPoolTest {

  Map<String, Set<PerspectiveDriver>> nameToDriver = new HashMap<>();
  Map<PerspectiveDriver, Set<VehicleInfo>> driverToVehicle = new HashMap<>();
  Map<VehicleInfo, Set<PerspectiveDriver>> vehicleToDriver = new HashMap<>();

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
  PerspectiveDriver perspectiveDriverSecond;


  private final String make = "BAY01FG";
  private final String model = "Blue Honda Accord";
  private final String year = "2014";
  private final String nameCar = "Ss";
  VehicleInfo vehicleInfo = new VehicleInfo(make, model, year, nameCar);
  Set<Name> set = new HashSet<>();
  InsuranceInfo insuranceInfo = new InsuranceInfo(name, set, dateInfo);
  AcceptedDriverPool acceptedDriverPool
      = new AcceptedDriverPool(nameToDriver, driverToVehicle, vehicleToDriver);
  private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

  @Test
  public void provideDriverInfo() throws Exception {
    acceptedDriverPool.provideDriverInfo(LAST_NAME);
    String string = "No registered driver found\n";
    assertEquals(outStream.toString(), string);
    outStream.reset();
    acceptedDriverPool.addDriver(perspectiveDriver);
    string = "Shangzhen,  Wu\n"
        + "1\t2014 Blue Honda Accord, BAY01FG\n"
        + "\tDriving violations:\n"
        + "\t\tSpeeding\n"
        + "\t\tSpeeding\n";
    acceptedDriverPool.provideDriverInfo(LAST_NAME);
    assertEquals(outStream.toString(), string);
    acceptedDriverPool.addDriver(perspectiveDriverSecond);
    acceptedDriverPool.provideDriverInfo(LAST_NAME);
    //assertEquals(outStream.toString(), string);
  }

  @Test
  public void printDriverInfo() throws Exception {
    acceptedDriverPool.addDriver(perspectiveDriver);
    String string = "Shangzhen,  Wu\n"
        + "1\t2014 Blue Honda Accord, BAY01FG\n"
        + "\tDriving violations:\n"
        + "\t\tSpeeding\n"
        + "\t\tSpeeding\n";
    acceptedDriverPool.printDriverInfo(perspectiveDriver);
    assertEquals(outStream.toString(), string);
  }

  @Test(expected = SameDriverSameCarException.class)
  public void addDriver() throws Exception {
    assertEquals(acceptedDriverPool.addDriver(perspectiveDriver), true);
    acceptedDriverPool.addDriver(perspectiveDriver);

  }

  @Test
  public void getNameToDriver() {
    assertEquals(acceptedDriverPool.getNameToDriver(), nameToDriver);
  }

  @Test
  public void setNameToDriver() {
    acceptedDriverPool.setNameToDriver(nameToDriver);
    assertEquals(acceptedDriverPool.getNameToDriver(), nameToDriver);
  }

  @Test
  public void getDriverToVehicle() {
    assertEquals(acceptedDriverPool.getDriverToVehicle(), driverToVehicle);
  }

  @Test
  public void setDriverToVehicle() {
    acceptedDriverPool.setDriverToVehicle(driverToVehicle);
    assertEquals(acceptedDriverPool.getDriverToVehicle(), driverToVehicle);
  }

  @Test
  public void getVehicleToDriver() {
    assertEquals(acceptedDriverPool.getVehicleToDriver(), driverToVehicle);
  }

  @Test
  public void setVehicleToDriver() {
    acceptedDriverPool.setVehicleToDriver(vehicleToDriver);
    assertEquals(acceptedDriverPool.getVehicleToDriver(), driverToVehicle);
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
    perspectiveDriverSecond = new PerspectiveDriver(nameSecond, dateInfoBirthday, licenseInfo, vehicleInfo,
        insuranceInfo, driverHistory, vehicleHistory);
    System.setOut(new PrintStream(outStream));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(System.out);
    System.setIn(System.in);
  }
}