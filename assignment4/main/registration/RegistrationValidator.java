package edu.neu.ccs.cs5010.assignment4.registration;

import edu.neu.ccs.cs5010.assignment4.driver.Country;
import edu.neu.ccs.cs5010.assignment4.driver.Crash;
import edu.neu.ccs.cs5010.assignment4.driver.MovingVioType;
import edu.neu.ccs.cs5010.assignment4.driver.Name;
import edu.neu.ccs.cs5010.assignment4.driver.MovingViolationInfo;
import edu.neu.ccs.cs5010.assignment4.driver.PerspectiveDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * A validator class for registration.
 */
public class RegistrationValidator {

  private PerspectiveDriver localPerspectiveDriver;

  public RegistrationValidator(
      PerspectiveDriver localPerspectiveDriver) {
    this.localPerspectiveDriver = localPerspectiveDriver;
  }

  /**
   * The validate method will determine whether the driver is qualified.
   *
   * @param perspectiveDriver perspective driver
   * @return boolean value indicates whether he is qualified
   * @throws Exception some exceptions
   */
  public boolean validate(PerspectiveDriver perspectiveDriver) throws Exception {
    this.localPerspectiveDriver = perspectiveDriver;
    return checkAge() && checkLicenseInfo() && checkVehicleInfo()
        && checkInsuranceInfo() && checkVehicleHistory() && checkViolation();
  }


  /**
   * Check the age of driver.
   *
   * @return boolean value whether driver is qualified
   */
  public boolean checkAge() {
    Date date = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    String currentDate = df.format(date);
    String driverDate = localPerspectiveDriver.getBirthday().toString();
    String[] currentDateArray = currentDate.split("\\.");
    String[] driverDateArray = driverDate.split("\\.");
    if (Integer.parseInt(currentDateArray[0]) - Integer.parseInt(driverDateArray[0]) > 20) {
      return true;
    } else if (Integer.parseInt(currentDateArray[0]) - Integer.parseInt(driverDateArray[0]) == 20) {
      if (Integer.parseInt(currentDateArray[1]) > Integer.parseInt(driverDateArray[1])) {
        return true;
      } else if (Integer.parseInt(currentDateArray[1]) == Integer.parseInt(driverDateArray[1])) {
        if (Integer.parseInt(currentDateArray[2]) >= Integer.parseInt(driverDateArray[2])) {
          return true;
        }
      }
    }
    return false;
  }


  /**
   * Check the license information of driver.
   *
   * @return whether the license info is correct
   * @throws Exception some exceptions
   */
  public boolean checkLicenseInfo() throws Exception {
    return checkName() && checkBirthDate() && checkCountry() && checkIssuanceDate()
        && checkIfExpired();
  }

  /**
   * Check the name of driver.
   *
   * @return whether the name is correct
   */
  public boolean checkName() {
    return localPerspectiveDriver.getName().equals(
        localPerspectiveDriver.getLicenseInfo().getName());
  }

  /**
   * Check the birthday of driver.
   *
   * @return boolean value
   */
  public boolean checkBirthDate() {
    return localPerspectiveDriver.getBirthday().equals(
        localPerspectiveDriver.getLicenseInfo().getBirthDay());
  }

  /**
   * Check the country.
   *
   * @return whether the country is correct
   */
  public boolean checkCountry() {
    return localPerspectiveDriver.getLicenseInfo().getCountry().equals(Country.U_S)
        || (localPerspectiveDriver.getLicenseInfo().getCountry().equals(Country.CANADA));
  }

  /**
   * Check the issuance date for driver.
   *
   * @return boolean value
   * @throws Exception some exceptions
   */
  public boolean checkIssuanceDate() throws Exception {
    String issuanceDate = localPerspectiveDriver.getLicenseInfo().getIssuanceDateInfo().toString();
    if (computeMonth(issuanceDate) >= 6) {
      return true;
    }
    return false;
  }

  /**
   * Compute the months from the past to now.
   *
   * @param compareDate The date you want to compare
   * @return boolean value
   * @throws Exception some exceptions
   */
  public int computeMonth(String compareDate) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    Date date = new Date();
    String currentDate = df.format(date);
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.setTime(df.parse(currentDate));
    c2.setTime(df.parse(compareDate));
    int result = (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12;
    result += c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
    return result == 0 ? 1 : Math.abs(result);
  }

  /**
   * Check whether the date is expired.
   *
   * @return boolean value
   * @throws Exception some date exception
   */
  public boolean checkIfExpired() throws Exception {
    String expiredDateStr
        = localPerspectiveDriver.getLicenseInfo().getExpirationDateInfo().toString();
    return compareToCurrent(expiredDateStr);
  }

  /**
   * Check vehicle information.
   *
   * @return boolean value
   */
  public boolean checkVehicleInfo() {
    String year = localPerspectiveDriver.getVehicleInfo().getYearOfVehicle();
    Date date = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    String curDateStr = df.format(date);
    String[] curDateArray = curDateStr.split("\\.");
    if (Integer.parseInt(curDateArray[0]) - Integer.parseInt(year) < 15) {
      return true;
    }
    return false;
  }

  /**
   * Check the insurance information.
   *
   * @return boolean value indicates whether it is correct
   * @throws Exception Some date exceptions.
   */
  public boolean checkInsuranceInfo() throws Exception {
    Name officialOwner = localPerspectiveDriver.getInsuranceInfo().getOwner();
    String expiredDateForInsurance =
        localPerspectiveDriver.getInsuranceInfo().getExpirationDateInfo().toString();
    if (compareToCurrent(expiredDateForInsurance)) {
      if (officialOwner.equals(localPerspectiveDriver.getName())) {
        return true;
      } else {
        Set<Name> nameList = localPerspectiveDriver.getInsuranceInfo().getPeopleCovered();
        if (nameList.contains(localPerspectiveDriver.getName())) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Check the violation.
   *
   * @return boolean value represents whether he has some violations
   */
  public boolean checkViolation() {
    List<MovingViolationInfo> movingViolationInfoList
        = localPerspectiveDriver.getDriverHistory().getMovingVioList();
    for (int i = 0; i < movingViolationInfoList.size(); i++) {
      if (movingViolationInfoList.get(i).getMovingVioType().equals(
          MovingVioType.DRIVING_UNDER_INFLUENCE)
          || movingViolationInfoList.get(i).getMovingVioType().equals(
          MovingVioType.DRIVING_WITHOUT_VALID_LICENCE)
          || movingViolationInfoList.get(i).getMovingVioType().equals(
          MovingVioType.RECKLESS_DRIVING)
          || movingViolationInfoList.get(i).getMovingVioType().equals(
          MovingVioType.DRIVING_WITHOUT_VALID_INSURANCE)
          || movingViolationInfoList.get(i).getMovingVioType().equals(
          MovingVioType.SPEEDING)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check the vehicle history.
   *
   * @return boolean value whether it is correct
   * @throws Exception some date exceptions.
   */
  public boolean checkVehicleHistory() throws Exception {
    List<MovingViolationInfo> movingViolationInfoList
        = localPerspectiveDriver.getVehicleHistory().getMovingViolationInfoList();
    for (int i = 0; i < movingViolationInfoList.size(); i++) {
      if (computeMonth(movingViolationInfoList.get(i).getDateInfo().toString()) <= 6) {
        return false;
      }
    }
    List<Crash> crashList
        = localPerspectiveDriver.getVehicleHistory().getCrashList();
    for (int i = 0; i < crashList.size(); i++) {
      if (computeMonth(crashList.get(i).getDate().toString()) <= 6) {
        return false;
      }
    }
    return true;
  }

  /**
   * Compare date to present date.
   *
   * @param comparedDate the date you want to compare
   * @return boolean value
   * @throws Exception some dates exceptions
   */
  public boolean compareToCurrent(String comparedDate) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    Date date = new Date();
    Date expiredDate = df.parse(comparedDate);
    if (date.before(expiredDate)) {
      return true;
    }
    return false;
  }

  /**
   * getter and setters.
   */
  public PerspectiveDriver getLocalPerspectiveDriver() {
    return localPerspectiveDriver;
  }

  public void setLocalPerspectiveDriver(
      PerspectiveDriver localPerspectiveDriver) {
    this.localPerspectiveDriver = localPerspectiveDriver;
  }
}
