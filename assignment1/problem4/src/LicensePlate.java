package edu.neu.ccs.cs5010.assignment1.problem4;


/**
 * A class represents license information.
 */
public class LicensePlate {

  String location;
  String number;
  String expiredTime;

  public LicensePlate(String location, String number, String expiredTime) {
    this.location = location;
    this.number = number;
    this.expiredTime = expiredTime;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(String expiredTime) {
    this.expiredTime = expiredTime;
  }
}
