package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.Objects;


/**
 * A class represents the perspective driver class.
 */
public class PerspectiveDriver {

  private Name name;
  private DateInfo birthday;
  private LicenseInfo licenseInfo;
  private VehicleInfo vehicleInfo;
  private InsuranceInfo insuranceInfo;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;


  /**
   * A constructor of perspective driver.
   * @param name name 
   * @param birthday birthday
   * @param licenseInfo license information
   * @param vehicleInfo vehicle information
   * @param insuranceInfo insurance information
   * @param driverHistory driver history
   * @param vehicleHistory vehicle history
   */
  public PerspectiveDriver(Name name,
      DateInfo birthday,
      LicenseInfo licenseInfo,
      VehicleInfo vehicleInfo,
      InsuranceInfo insuranceInfo,
      DriverHistory driverHistory,
      VehicleHistory vehicleHistory) {
    this.name = name;
    this.birthday = birthday;
    this.licenseInfo = licenseInfo;
    this.vehicleInfo = vehicleInfo;
    this.insuranceInfo = insuranceInfo;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Get the name of driver.
   *
   * @return the name of the driver
   */
  public Name getName() {
    return name;
  }

  /**
   * Set the name of driver.
   *
   * @param name The name you want to set
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * Get the birthday of driver.
   *
   * @return The date information birthday.
   */
  public DateInfo getBirthday() {
    return birthday;
  }

  /**
   * Set the birthday date information.
   *
   * @param birthday The birthday you want to set
   */
  public void setBirthday(DateInfo birthday) {
    this.birthday = birthday;
  }

  /**
   * Get the license information.
   *
   * @return license information class
   */
  public LicenseInfo getLicenseInfo() {
    return licenseInfo;
  }

  /**
   * Set the license information.
   *
   * @param licenseInfo The license information you want to set
   */
  public void setLicenseInfo(
      LicenseInfo licenseInfo) {
    this.licenseInfo = licenseInfo;
  }

  /**
   * A getter for vehicle information.
   *
   * @return The instance of vehicle information class
   */
  public VehicleInfo getVehicleInfo() {
    return vehicleInfo;
  }

  /**
   * A setter for vehicle information.
   *
   * @param vehicleInfo The vehicle info you want to set
   */
  public void setVehicleInfo(
      VehicleInfo vehicleInfo) {
    this.vehicleInfo = vehicleInfo;
  }

  /**
   * A getter for insurance info.
   *
   * @return The information of insurance
   */
  public InsuranceInfo getInsuranceInfo() {
    return insuranceInfo;
  }

  /**
   * Set the insurance info.
   *
   * @param insuranceInfo the insurance info you want to set
   */
  public void setInsuranceInfo(
      InsuranceInfo insuranceInfo) {
    this.insuranceInfo = insuranceInfo;
  }

  /**
   * Get the driver history.
   *
   * @return the driver history
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * Set the driver history.
   *
   * @param driverHistory The driver history you want to set
   */
  public void setDriverHistory(
      DriverHistory driverHistory) {
    this.driverHistory = driverHistory;
  }

  /**
   * A getter for vehicle history.
   *
   * @return vehicle history
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  /**
   * Set the vehicle history.
   *
   * @param vehicleHistory The vehicle history you want to set
   */
  public void setVehicleHistory(
      VehicleHistory vehicleHistory) {
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Auto generated equals and hashCode method.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    PerspectiveDriver driver = (PerspectiveDriver) object;
    return Objects.equals(name, driver.name)
        && Objects.equals(birthday, driver.birthday)
        && Objects.equals(licenseInfo, driver.licenseInfo)
        && Objects.equals(vehicleInfo, driver.vehicleInfo)
        && Objects.equals(insuranceInfo, driver.insuranceInfo)
        && Objects.equals(driverHistory, driver.driverHistory)
        && Objects.equals(vehicleHistory, driver.vehicleHistory);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(name, birthday, licenseInfo, vehicleInfo, insuranceInfo, driverHistory,
            vehicleHistory);
  }
}
