package edu.neu.ccs.cs5010.assignment1.probem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AWingFighterTest {
  AWingFighter aWingFighter = new AWingFighter(20, 30, false);
  AWingFighter aWingFighter1 = new AWingFighter(20, 30, false);


  @Test
  public void changeFuel() {
    try {
      aWingFighter.changeFuel(10);
      aWingFighter1.changeFuel(300);
      System.out.println(aWingFighter1.getFuelLevel());
      assertEquals(aWingFighter.getFuelLevel(), 30);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfFuelLevelRangeException.class);
    }
  }

  @Test
  public void changeDestructionLevel() {
    try {
      aWingFighter.changeDestructionLevel(10);
      assertEquals(aWingFighter.getDestructionLevel(), 40);
      aWingFighter.changeDestructionLevel(100);
      AWingFighter aWingFighter2 = new AWingFighter(20,
          100, true);
      aWingFighter2.changeDestructionLevel(100);
    } catch (Exception e) {
      assertEquals(e.getClass(), ShipIsDeadException.class);
    }
  }

  @Test
  public void attack() {
    try {
      XWingFighter xWingFighter = new XWingFighter(20,
          30, false);
      StarDestroyer starDestroyer = new StarDestroyer(20,
          30, false);
      aWingFighter.attack(starDestroyer, 20);
      aWingFighter.attack(starDestroyer, 100);
      assertEquals(starDestroyer.getDestructionLevel(), 50);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAttackLevelRangeException.class);
      e.printStackTrace();
    }
  }

  @Test
  public void getFuelLevel() {
    assertEquals(aWingFighter.getFuelLevel(), 20);
  }

  @Test
  public void setFuelLevel() {
    aWingFighter.setFuelLevel(20);
    assertEquals(aWingFighter.getFuelLevel(), 20);
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(aWingFighter.getDestructionLevel(), 30);
  }

  @Test
  public void setDestructionLevel() {
    aWingFighter.setDestructionLevel(20);
    assertEquals(aWingFighter.getDestructionLevel(), 20);
  }
  @Test
  public void isDestroyed() {
    assertFalse(aWingFighter.isDestroyed());
  }
  @Test
  public void setDestroyed() {
    aWingFighter.setDestroyed(true);
    assertTrue(aWingFighter.isDestroyed());
  }

  @Test
  public void getMaxAttackLevel() {
    assertEquals(aWingFighter.getMaxAttackLevel(), 30);
  }

  @Test
  public void setMaxAttackLevel() {
    aWingFighter.setMaxAttackLevel(20);
    assertEquals(aWingFighter.getMaxAttackLevel(), 20);
  }
}