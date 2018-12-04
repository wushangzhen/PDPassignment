package edu.neu.ccs.cs5010.assignment1.probem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XWingFighterTest {
  XWingFighter xWingFighter = new XWingFighter(20, 30, false);
  XWingFighter xWingFighter1 = new XWingFighter(20, 30, false);


  @Test
  public void changeFuel() {
    try {
      xWingFighter.changeFuel(10);
      xWingFighter1.changeFuel(300);
      assertEquals(xWingFighter.getFuelLevel(), 30);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfFuelLevelRangeException.class);
    }
  }

  @Test
  public void changeDestructionLevel() {
    try {
      xWingFighter.changeDestructionLevel(10);
      assertEquals(xWingFighter.getDestructionLevel(), 40);
      xWingFighter.changeDestructionLevel(100);
    } catch (Exception e) {
      assertEquals(e.getClass(), ShipIsDeadException.class);
    }
  }

  @Test
  public void attack() {
    try {
      XWingFighter xWingFighter = new XWingFighter(20,
          30, false);
      XWingFighter xWingFighter1 = new XWingFighter(20,
          30, true);
      StarDestroyer starDestroyer = new StarDestroyer(20,
          20, true);
      xWingFighter1.attack(starDestroyer, 100);
    } catch (Exception e) {
      assertEquals(e.getClass(), ShipIsDeadException.class);
      e.printStackTrace();
    }
  }

  @Test
  public void getFuelLevel() {
    assertEquals(xWingFighter.getFuelLevel(), 20);
  }

  @Test
  public void setFuelLevel() {
    xWingFighter.setFuelLevel(20);
    assertEquals(xWingFighter.getFuelLevel(), 20);
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(xWingFighter.getDestructionLevel(), 30);
  }

  @Test
  public void setDestructionLevel() {
    xWingFighter.setDestructionLevel(20);
    assertEquals(xWingFighter.getDestructionLevel(), 20);
  }
  @Test
  public void isDestroyed() {
    assertFalse(xWingFighter.isDestroyed());
  }
  @Test
  public void setDestroyed() {
    xWingFighter.setDestroyed(true);
    assertTrue(xWingFighter.isDestroyed());
  }

  @Test
  public void getMaxAttackLevel() {
    assertEquals(xWingFighter.getMaxAttackLevel(), 40);
  }

  @Test
  public void setMaxAttackLevel() {
    xWingFighter.setMaxAttackLevel(20);
    assertEquals(xWingFighter.getMaxAttackLevel(), 20);
  }
}