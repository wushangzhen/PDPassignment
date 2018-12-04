package edu.neu.ccs.cs5010.assignment4.driver;

/**
 * A class will record the moving violation information.
 */
public class MovingViolationInfo {

  private DateInfo dateInfo;
  private MovingVioType movingVioType;
  private Name offendingDriver;

  /**
   * Get the date information.
   *
   * @return Date information
   */
  public DateInfo getDateInfo() {
    return dateInfo;
  }

  public void setDateInfo(DateInfo dateInfo) {
    this.dateInfo = dateInfo;
  }

  /**
   * Getter and setter for moving violation type.
   *
   * @return moving violation type
   */
  public MovingVioType getMovingVioType() {
    return movingVioType;
  }

  public void setMovingVioType(
      MovingVioType movingVioType) {
    this.movingVioType = movingVioType;
  }

  /**
   * A constructor of moving violation information.
   * @param dateInfo date information
   * @param movingVioType the type of moving violation type
   * @param offendingDriver the offending drivers' name
   */
  public MovingViolationInfo(DateInfo dateInfo,
      MovingVioType movingVioType, Name offendingDriver) {
    this.dateInfo = dateInfo;
    this.movingVioType = movingVioType;
    this.offendingDriver = offendingDriver;
  }

  /**
   * Get the offending drivers' name.
   * @return offending driver
   */
  public Name getOffendingDriver() {
    return offendingDriver;
  }

  public void setOffendingDriver(
      Name offendingDriver) {
    this.offendingDriver = offendingDriver;
  }
}
