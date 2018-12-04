package edu.neu.ccs.cs5010.assignment1.problem4;

import static org.junit.Assert.*;

import org.junit.Test;

public class LicensePlateTest {
  LicensePlate licensePlate = new LicensePlate("WA", "16AA","Nov.2018");
  @Test
  public void getLocation() {
    assertEquals(licensePlate.getLocation(), "WA");
  }

  @Test
  public void setLocation() {
    licensePlate.setLocation("MA");
    assertEquals(licensePlate.getLocation(), "MA");
  }

  @Test
  public void getNumber() {
    assertEquals(licensePlate.getNumber(), "16AA");
  }

  @Test
  public void setNumber() {
    licensePlate.setNumber("13AA");
    assertEquals(licensePlate.getNumber(), "13AA");
  }

  @Test
  public void getExpiredTime() {
    assertEquals(licensePlate.getExpiredTime(), "Nov.2018");
  }

  @Test
  public void setExpiredTime() {
    licensePlate.setExpiredTime("Nov.2019");
    assertEquals(licensePlate.getExpiredTime(), "Nov.2019");
  }
}