package edu.neu.ccs.cs5010.assignment1.problem4;

import static org.junit.Assert.*;
import java.util.*;

import javax.jws.WebService;
import org.junit.Before;
import org.junit.Test;

public class TruckTest {
  MakeAndModel makeAndModel = new MakeAndModel("BMW", "2015");
  LicensePlate licensePlate = new LicensePlate("WA", "16AA","Nov.2018");
  Truck truck = new Truck("black", makeAndModel, licensePlate, 50.0, "Eastbound");

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void acceleration() {
    try {
      truck.acceleration(20);
      assertEquals(truck.getVelocity(), 60, 1e-8);
      truck.acceleration(50);
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidAccelerationException.class);
    }
  }

  @Test
  public void deceleration() {
    try {
      truck.deceleration(20);
      assertEquals(truck.getVelocity(), 40, 1e-8);
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidDecelerationException.class);
    }
  }

  @Test
  public void changeDirection() {
    try {
      truck.changeDirection("Westbound");
      assertEquals(truck.getDirection(), "Westbound");
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidDirectionException.class);
      e.printStackTrace();
    }
  }

  @Test
  public void getColor() {
    assertEquals(truck.getColor(), "black");
  }

  @Test
  public void setColor() {
    truck.setColor("white");
    assertEquals(truck.getColor(), "white");
  }

  @Test
  public void getMakeAndModel() {
    assertEquals(truck.getMakeAndModel(), makeAndModel);
  }

  @Test
  public void setMakeAndModel() {
    MakeAndModel newMakeAndModel = new MakeAndModel("Audi", "R8");
    truck.setMakeAndModel(newMakeAndModel);
    assertEquals(truck.getMakeAndModel(), newMakeAndModel);
  }

  @Test
  public void getLicensePlate() {
    assertEquals(truck.getLicensePlate(), licensePlate);
  }

  @Test
  public void setLicensePlate() {
    LicensePlate newLicensePlate = new LicensePlate("WA", "1a", "2019");
    truck.setLicensePlate(newLicensePlate);
    assertEquals(truck.getLicensePlate(), newLicensePlate);
  }

  @Test
  public void getVelocity() {
    assertEquals(truck.getVelocity(), 50,1e-8);
  }

  @Test
  public void setVelocity() {
    truck.setVelocity(40.0);
    assertEquals(truck.getVelocity(), 40,1e-8);
  }

  @Test
  public void getMaxVelocity() {
    assertEquals(truck.getMaxVelocity(), 60, 1e-8);
  }

  @Test
  public void setMaxVelocity() {
    truck.setMaxVelocity(65);
    assertEquals(truck.getMaxVelocity(), 65, 1e-8);
  }

  @Test
  public void getDirection() {
    assertEquals(truck.getDirection(), "Eastbound");
  }

  @Test
  public void setDirection() {
    truck.setDirection("Westbound");
    assertEquals(truck.getDirection(), "Westbound");
  }

  @Test
  public void getRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    rules.put("Eastbound", "Westbound");
    rules.put("Westbound", "Eastbound");
    assertEquals(truck.getRules(), rules);
  }

  @Test
  public void setRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    truck.setRules(rules);
    assertEquals(truck.getRules(), rules);
  }
}