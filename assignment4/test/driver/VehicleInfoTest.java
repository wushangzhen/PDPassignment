package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

public class VehicleInfoTest {

  private final String make = "BAY01FG";
  private final String model = "Blue Honda Accord";
  private final String year = "2014";
  private final String name = "Ss";
  VehicleInfo vehicleInfo = new VehicleInfo(make, model, year, name);
  VehicleInfo vehicleInfoTest = new VehicleInfo(make, model, year, name);

  @Test
  public void equals() {
    assertTrue(vehicleInfo.equals(vehicleInfo));
    assertTrue(vehicleInfo.equals(vehicleInfoTest));
    assertFalse(vehicleInfo.equals(null));
    assertFalse(vehicleInfo.equals(new Date()));
    vehicleInfoTest.setMake("xxxxxxxxx");
    assertFalse(vehicleInfo.equals(vehicleInfoTest));
    vehicleInfoTest.setModel(null);
    assertFalse(vehicleInfo.equals(vehicleInfoTest));
    vehicleInfoTest.setYearOfVehicle("xxxxxxxxx");
    assertFalse(vehicleInfo.equals(vehicleInfoTest));
    vehicleInfoTest.setOfficialOwner("xxxxxxxxx");
    assertFalse(vehicleInfo.equals(vehicleInfoTest));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(vehicleInfo.hashCode() == vehicleInfoTest.hashCode());
  }

  @Test
  public void getMake() {
    assertEquals(vehicleInfo.getMake(), make);

  }

  @Test
  public void setMake() {
    vehicleInfo.setMake(model);
    assertEquals(vehicleInfo.getMake(), model);
  }

  @Test
  public void getModel() {
    assertEquals(vehicleInfo.getModel(), model);
  }

  @Test
  public void setModel() {
    vehicleInfo.setModel("xxx");
    assertEquals(vehicleInfo.getModel(), "xxx");
  }

  @Test
  public void getYearOfVehicle() {
    assertEquals(vehicleInfo.getYearOfVehicle(), year);
  }

  @Test
  public void setYearOfVehicle() {
    vehicleInfo.setYearOfVehicle("xxx");
    assertEquals(vehicleInfo.getYearOfVehicle(), "xxx");
  }

  @Test
  public void getOfficialOwner() {
    assertEquals(vehicleInfo.getOfficialOwner(), name);
  }

  @Test
  public void setOfficialOwner() {
    vehicleInfo.setOfficialOwner("xx");
    assertEquals(vehicleInfo.getOfficialOwner(), "xx");
  }

  @Test
  public void toStringTest() {
    assertEquals(vehicleInfo.toString(), "2014 Blue Honda Accord, BAY01FG");
  }
}