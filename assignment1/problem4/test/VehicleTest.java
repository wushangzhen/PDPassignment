package edu.neu.ccs.cs5010.assignment1.problem4;

import static org.junit.Assert.*;
import java.util.*;

import javax.jws.WebService;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  MakeAndModel makeAndModel = new MakeAndModel("BMW", "2015");
  LicensePlate licensePlate = new LicensePlate("WA", "16AA","Nov.2018");
  Bus bus = new Bus("black", makeAndModel, licensePlate, 50.0, "Eastbound");

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void acceleration() {
    try {
      bus.acceleration(20);
      assertEquals(bus.getVelocity(), 60, 1e-8);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void deceleration() {
    try {
      bus.deceleration(20);
      assertEquals(bus.getVelocity(), 40, 1e-8);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void changeDirection() {
    try {
      bus.changeDirection("Westbound");
      assertEquals(bus.getDirection(), "Westbound");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getColor() {
    assertEquals(bus.getColor(), "black");
  }

  @Test
  public void setColor() {
    bus.setColor("white");
    assertEquals(bus.getColor(), "white");
  }

  @Test
  public void getMakeAndModel() {
    assertEquals(bus.getMakeAndModel(), makeAndModel);
  }

  @Test
  public void setMakeAndModel() {
    MakeAndModel newMakeAndModel = new MakeAndModel("Audi", "R8");
    bus.setMakeAndModel(newMakeAndModel);
    assertEquals(bus.getMakeAndModel(), newMakeAndModel);
  }

  @Test
  public void getLicensePlate() {
    assertEquals(bus.getLicensePlate(), licensePlate);
  }

  @Test
  public void setLicensePlate() {
    LicensePlate newLicensePlate = new LicensePlate("WA", "1a", "2019");
    bus.setLicensePlate(newLicensePlate);
    assertEquals(bus.getLicensePlate(), newLicensePlate);
  }

  @Test
  public void getVelocity() {
    assertEquals(bus.getVelocity(), 50,1e-8);
  }

  @Test
  public void setVelocity() {
    bus.setVelocity(40.0);
    assertEquals(bus.getVelocity(), 40,1e-8);
  }

  @Test
  public void getMaxVelocity() {
    assertEquals(bus.getMaxVelocity(), 60, 1e-8);
  }

  @Test
  public void setMaxVelocity() {
    bus.setMaxVelocity(65);
    assertEquals(bus.getMaxVelocity(), 65, 1e-8);
  }

  @Test
  public void getDirection() {
    assertEquals(bus.getDirection(), "Eastbound");
  }

  @Test
  public void setDirection() {
    bus.setDirection("Westbound");
    assertEquals(bus.getDirection(), "Westbound");
  }

  @Test
  public void getRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    rules.put("Eastbound", "Westbound");
    rules.put("Westbound", "Eastbound");
    assertEquals(bus.getRules(), rules);
  }

  @Test
  public void setRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    bus.setRules(rules);
    assertEquals(bus.getRules(), rules);
  }
}