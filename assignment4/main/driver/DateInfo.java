package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.Objects;

/**
 * The date info class.
 */
public class DateInfo {

  private String year;
  private String month;
  private String day;

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    DateInfo dateInfo = (DateInfo) object;
    return Objects.equals(year, dateInfo.year) 
        && Objects.equals(month, dateInfo.month) 
        && Objects.equals(day, dateInfo.day);
  }

  /**
   * The constructor of DateInfo.
   * @param year year
   * @param month month
   * @param day day
   */
  public DateInfo(String year, String month, String day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  /**
   * Override the toString method to get the standard output.
   *
   * @return String of output
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(year);
    sb.append(".");
    sb.append(month);
    sb.append(".");
    sb.append(day);
    return sb.toString();
  }

  /**
   * Getters and Setters for field.
   */
  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, month, day);
  }
}
