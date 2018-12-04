package edu.neu.ccs.cs5010.assignment1.problem4;

import static org.junit.Assert.*;
import java.util.*;

import javax.jws.WebService;
import org.junit.Before;
import org.junit.Test;

public class MotorCycleTest {
  MakeAndModel makeAndModel = new MakeAndModel("BMW", "2015");
  LicensePlate licensePlate = new LicensePlate("WA", "16AA","Nov.2018");
  MotorCycle motorCycle = new MotorCycle("black", makeAndModel, licensePlate, 50.0, "Eastbound");

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void acceleration() {
    try {
      motorCycle.acceleration(20);
      assertEquals(motorCycle.getVelocity(), 60, 1e-8);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void deceleration() {
    try {
      motorCycle.deceleration(20);
      assertEquals(motorCycle.getVelocity(), 40, 1e-8);
      motorCycle.deceleration(60);
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidDecelerationFactorException.class);
    }
  }

  @Test
  public void changeDirection() {
    try {
      motorCycle.changeDirection("Westbound");
      assertEquals(motorCycle.getDirection(), "Westbound");
      motorCycle.changeDirection("Eastbound");
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidDirectionException.class);
      e.printStackTrace();
    }
  }

  @Test
  public void getColor() {
    assertEquals(motorCycle.getColor(), "black");
  }

  @Test
  public void setColor() {
    motorCycle.setColor("white");
    assertEquals(motorCycle.getColor(), "white");
  }

  @Test
  public void getMakeAndModel() {
    assertEquals(motorCycle.getMakeAndModel(), makeAndModel);
  }

  @Test
  public void setMakeAndModel() {
    MakeAndModel newMakeAndModel = new MakeAndModel("Audi", "R8");
    motorCycle.setMakeAndModel(newMakeAndModel);
    assertEquals(motorCycle.getMakeAndModel(), newMakeAndModel);
  }

  @Test
  public void getLicensePlate() {
    assertEquals(motorCycle.getLicensePlate(), licensePlate);
  }

  @Test
  public void setLicensePlate() {
    LicensePlate newLicensePlate = new LicensePlate("WA", "1a", "2019");
    motorCycle.setLicensePlate(newLicensePlate);
    assertEquals(motorCycle.getLicensePlate(), newLicensePlate);
  }

  @Test
  public void getVelocity() {
    assertEquals(motorCycle.getVelocity(), 50,1e-8);
  }

  @Test
  public void setVelocity() {
    motorCycle.setVelocity(40.0);
    assertEquals(motorCycle.getVelocity(), 40,1e-8);
  }

  @Test
  public void getMaxVelocity() {
    assertEquals(motorCycle.getMaxVelocity(), 65, 1e-8);
  }

  @Test
  public void setMaxVelocity() {
    motorCycle.setMaxVelocity(65);
    assertEquals(motorCycle.getMaxVelocity(), 65, 1e-8);
  }

  @Test
  public void getDirection() {
    assertEquals(motorCycle.getDirection(), "Eastbound");
  }

  @Test
  public void setDirection() {
    motorCycle.setDirection("Westbound");
    assertEquals(motorCycle.getDirection(), "Westbound");
  }

  @Test
  public void getRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    rules.put("Eastbound", "Westbound");
    rules.put("Westbound", "Eastbound");
    assertEquals(motorCycle.getRules(), rules);
  }

  @Test
  public void setRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    motorCycle.setRules(rules);
    assertEquals(motorCycle.getRules(), rules);
  }
}