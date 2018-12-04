package edu.neu.ccs.cs5010.assignment1.problem4;

import static org.junit.Assert.*;
import java.util.*;

import javax.jws.WebService;
import org.junit.Before;
import org.junit.Test;

public class AutoMobileTest {
  MakeAndModel makeAndModel = new MakeAndModel("BMW", "2015");
  LicensePlate licensePlate = new LicensePlate("WA", "16AA","Nov.2018");
  AutoMobile autoMobile = new AutoMobile("black", makeAndModel, licensePlate, 50.0, "Eastbound");

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void acceleration() {
    try {
      autoMobile.acceleration(20);
      assertEquals(autoMobile.getVelocity(), 60, 1e-8);
      autoMobile.acceleration(100);
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidAccelerationFactorException.class);
    }
  }

  @Test
  public void deceleration() {
    try {
      autoMobile.deceleration(20);
      assertEquals(autoMobile.getVelocity(), 40, 1e-8);
      autoMobile.deceleration(50);
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidDecelerationException.class);
    }
  }

  @Test
  public void changeDirection() {
    try {
      autoMobile.changeDirection("Westbound");
      assertEquals(autoMobile.getDirection(), "Westbound");
      autoMobile.changeDirection("Northbound");
    } catch (Exception e) {
      assertEquals(e.getClass(), InvalidDirectionException.class);
      e.printStackTrace();
    }
  }

  @Test
  public void getColor() {
    assertEquals(autoMobile.getColor(), "black");
  }

  @Test
  public void setColor() {
    autoMobile.setColor("white");
    assertEquals(autoMobile.getColor(), "white");
  }

  @Test
  public void getMakeAndModel() {
    assertEquals(autoMobile.getMakeAndModel(), makeAndModel);
  }

  @Test
  public void setMakeAndModel() {
    MakeAndModel newMakeAndModel = new MakeAndModel("Audi", "R8");
    autoMobile.setMakeAndModel(newMakeAndModel);
    assertEquals(autoMobile.getMakeAndModel(), newMakeAndModel);
  }

  @Test
  public void getLicensePlate() {
    assertEquals(autoMobile.getLicensePlate(), licensePlate);
  }

  @Test
  public void setLicensePlate() {
    LicensePlate newLicensePlate = new LicensePlate("WA", "1a", "2019");
    autoMobile.setLicensePlate(newLicensePlate);
    assertEquals(autoMobile.getLicensePlate(), newLicensePlate);
  }

  @Test
  public void getVelocity() {
    assertEquals(autoMobile.getVelocity(), 50,1e-8);
  }

  @Test
  public void setVelocity() {
    autoMobile.setVelocity(40.0);
    assertEquals(autoMobile.getVelocity(), 40,1e-8);
  }

  @Test
  public void getMaxVelocity() {
    assertEquals(autoMobile.getMaxVelocity(), 70, 1e-8);
  }

  @Test
  public void setMaxVelocity() {
    autoMobile.setMaxVelocity(65);
    assertEquals(autoMobile.getMaxVelocity(), 65, 1e-8);
  }

  @Test
  public void getDirection() {
    assertEquals(autoMobile.getDirection(), "Eastbound");
  }

  @Test
  public void setDirection() {
    autoMobile.setDirection("Westbound");
    assertEquals(autoMobile.getDirection(), "Westbound");
  }

  @Test
  public void getRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    rules.put("Eastbound", "Westbound");
    rules.put("Westbound", "Eastbound");
    assertEquals(autoMobile.getRules(), rules);
  }

  @Test
  public void setRules() {
    HashMap<String, String> rules = new HashMap<String, String>();
    rules.put("Northbound", "Southbound");
    rules.put("Southbound", "Northbound");
    autoMobile.setRules(rules);
    assertEquals(autoMobile.getRules(), rules);
  }
}