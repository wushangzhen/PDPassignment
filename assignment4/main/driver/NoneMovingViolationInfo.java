package edu.neu.ccs.cs5010.assignment4.driver;

/**
 * None moving violation information class.
 */
public class NoneMovingViolationInfo {

  private DateInfo dateInfo;
  private NoneMovingVioType noneMovingVioType;
  private Name offendingDriver;


  /**
   * A constructor of none moving violation class.
   * @param dateInfo date info
   * @param noneMovingVioType none moving violation type
   * @param offendingDriver the name of offending driver
   */
  public NoneMovingViolationInfo(
      DateInfo dateInfo,
      NoneMovingVioType noneMovingVioType,
      Name offendingDriver) {
    this.dateInfo = dateInfo;
    this.noneMovingVioType = noneMovingVioType;
    this.offendingDriver = offendingDriver;
  }

  /**
   * Get date information.
   *
   * @return date information.
   */
  public DateInfo getDateInfo() {
    return dateInfo;
  }

  /**
   * Set the date information of date.
   *
   * @param dateInfo Date information class
   */
  public void setDateInfo(DateInfo dateInfo) {
    this.dateInfo = dateInfo;
  }

  public NoneMovingVioType getNoneMovingVioType() {
    return noneMovingVioType;
  }

  public void setNoneMovingVioType(
      NoneMovingVioType noneMovingVioType) {
    this.noneMovingVioType = noneMovingVioType;
  }

  /**
   * Get the offending drivers name.
   *
   * @return The name of the driver
   */
  public Name getOffendingDriver() {
    return offendingDriver;
  }

  /**
   * Set the offending driver name.
   * @param offendingDriver the offending driver you want to set
   */
  public void setOffendingDriver(
      Name offendingDriver) {
    this.offendingDriver = offendingDriver;
  }
}
