package edu.neu.ccs.cs5010.assignment4.driver;

/**
 * A crash class includes date and crash type.
 */
public class Crash {

  private DateInfo date;
  private CrashType crashType;
  private Name name;


  /**
   * A constructor of crash.
   * @param date date
   * @param crashType crashType
   * @param name name
   */
  public Crash(DateInfo date,
      CrashType crashType, Name name) {
    this.date = date;
    this.crashType = crashType;
    this.name = name;
  }

  public DateInfo getDate() {
    return date;
  }

  public void setDate(DateInfo date) {
    this.date = date;
  }

  public CrashType getCrashType() {
    return crashType;
  }

  public void setCrashType(CrashType crashType) {
    this.crashType = crashType;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }
}
