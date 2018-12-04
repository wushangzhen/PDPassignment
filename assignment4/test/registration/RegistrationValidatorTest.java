package edu.neu.ccs.cs5010.assignment4.registration;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class RegistrationValidatorTest {

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

  private final String YEAR_BIRTHDAY = "1996";
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
  PerspectiveDriver perspectiveDriverValidate;
  DriverHistory driverHistoryValidate;


  private final String make = "BAY01FG";
  private final String model = "Blue Honda Accord";
  private final String year = "2014";
  private final String nameCar = "Ss";
  VehicleInfo vehicleInfo = new VehicleInfo(make, model, year, nameCar);
  Set<Name> set = new HashSet<>();
  InsuranceInfo insuranceInfo = new InsuranceInfo(name, set, dateInfoExpiration);
  RegistrationValidator registrationValidator;
  RegistrationValidator registrationValidatorValid;

  @Test
  public void validate() throws Exception {
    assertFalse(registrationValidator.validate(perspectiveDriver));
    assertTrue(registrationValidatorValid.validate(perspectiveDriverValidate));
  }

  @Test
  public void checkAge() {
    assertTrue(registrationValidator.checkAge());
    assertTrue(registrationValidatorValid.checkAge());
    registrationValidator.getLocalPerspectiveDriver().setBirthday(new DateInfo("1998",
        "10", "14"));
    assertTrue(registrationValidator.checkAge());
    registrationValidator.getLocalPerspectiveDriver().setBirthday(new DateInfo("1997",
        "10", "14"));
    assertTrue(registrationValidator.checkAge());
    registrationValidator.getLocalPerspectiveDriver().setBirthday(new DateInfo("1998",
        "09", "14"));
    assertTrue(registrationValidator.checkAge());
    registrationValidator.getLocalPerspectiveDriver().setBirthday(new DateInfo("2008",
        "09", "14"));
    assertFalse(registrationValidator.checkAge());
  }

  @Test
  public void checkLicenseInfo() throws Exception {
    assertTrue(registrationValidatorValid.checkLicenseInfo());
    assertTrue(registrationValidator.checkLicenseInfo());
  }

  @Test
  public void checkName() {
    assertTrue(registrationValidator.checkName());
  }

  @Test
  public void checkBirthDate() {
    assertTrue(registrationValidator.checkBirthDate());
  }

  @Test
  public void checkCountry() {
    registrationValidator.getLocalPerspectiveDriver().getLicenseInfo().setCountry(Country.CANADA);
    assertTrue(registrationValidator.checkCountry());
  }

  @Test
  public void checkIssuanceDate() throws Exception {
    registrationValidator.getLocalPerspectiveDriver().getLicenseInfo()
        .setIssuanceDateInfo(new DateInfo("2018", "09", "01"));
    assertFalse(registrationValidator.checkIssuanceDate());
  }

  @Test
  public void computeMonth() throws Exception {
    assertEquals(registrationValidator.computeMonth("1998.01.01"), 249);
  }

  @Test
  public void checkIfExpired() {
  }

  @Test
  public void checkVehicleInfo() throws Exception {
    assertTrue(registrationValidator.checkVehicleInfo());
    registrationValidator.getLocalPerspectiveDriver().getVehicleInfo().setYearOfVehicle("1900");
    assertFalse(registrationValidator.checkVehicleInfo());
  }

  @Test
  public void checkInsuranceInfo() throws Exception {
    assertTrue(registrationValidator.checkInsuranceInfo());
    registrationValidator.getLocalPerspectiveDriver().getInsuranceInfo()
        .setOwner(new Name("xxx", "xxx"));
    registrationValidator.getLocalPerspectiveDriver().getInsuranceInfo().getPeopleCovered()
        .add(new Name("xxx", "xxx"));
    assertTrue(registrationValidator.checkInsuranceInfo());
    registrationValidator.getLocalPerspectiveDriver().getInsuranceInfo().getPeopleCovered()
        .remove(new Name("xxx", "xxx"));
    registrationValidator.getLocalPerspectiveDriver().getInsuranceInfo().getPeopleCovered()
        .remove(name);
    assertFalse(registrationValidator.checkInsuranceInfo());
  }

  @Test
  public void checkViolation() {
    assertFalse(registrationValidator.checkViolation());
    registrationValidator.getLocalPerspectiveDriver().getDriverHistory().getMovingVioList()
        .remove(movingViolationInfo);
    assertTrue(registrationValidator.checkViolation());
  }

  @Test
  public void checkVehicleHistory() throws Exception {
    assertTrue(registrationValidator.checkVehicleHistory());
    registrationValidator.getLocalPerspectiveDriver().getVehicleHistory().getCrashList()
        .get(0).setDate(new DateInfo("2018", "10", "1"));
    assertFalse(registrationValidator.checkVehicleHistory());
    registrationValidator.getLocalPerspectiveDriver().getVehicleHistory()
        .getMovingViolationInfoList().get(0)
        .setDateInfo(new DateInfo("2018", "10", "1"));
    assertFalse(registrationValidator.checkVehicleHistory());
  }

  @Test
  public void compareToCurrent() throws Exception {
    assertFalse(registrationValidator.compareToCurrent(dateInfo.toString()));
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
    driverHistoryValidate = new DriverHistory(new ArrayList<>(), new ArrayList<>());
    perspectiveDriverValidate = new PerspectiveDriver(name, dateInfoBirthday,
        licenseInfo, vehicleInfo, insuranceInfo, driverHistoryValidate, vehicleHistory);
    registrationValidator = new RegistrationValidator(perspectiveDriver);
    registrationValidatorValid = new RegistrationValidator(perspectiveDriverValidate);

  }

  @Test
  public void getLocalPerspectiveDriver() {
    assertEquals(registrationValidator.getLocalPerspectiveDriver(), perspectiveDriver);
  }

  @Test
  public void setLocalPerspectiveDriver() {
    registrationValidator.setLocalPerspectiveDriver(perspectiveDriver);
    assertEquals(registrationValidator.getLocalPerspectiveDriver(), perspectiveDriver);
  }
}