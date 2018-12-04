package edu.neu.ccs.cs5010.assignment1.probem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TieFighterTest {
  TieFighter tieFighter = new TieFighter(20, 30, false);
  TieFighter tieFighter1 = new TieFighter(20, 30, false);


  @Test
  public void changeFuel() {
    try {
      tieFighter.changeFuel(10);
      tieFighter1.changeFuel(300);
      assertEquals(tieFighter.getFuelLevel(), 30);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfFuelLevelRangeException.class);
    }
  }

  @Test
  public void changeDestructionLevel() {
    try {
      tieFighter.changeDestructionLevel(10);
      assertEquals(tieFighter.getDestructionLevel(), 40);
      tieFighter.changeDestructionLevel(100);
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
          20, true);
      tieFighter.attack(xWingFighter, 20);
      assertEquals(xWingFighter.getDestructionLevel(), 50);
      tieFighter.attack(xWingFighter, 100);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAttackLevelRangeException.class);
      e.printStackTrace();
    }
  }

  @Test
  public void getFuelLevel() {
    assertEquals(tieFighter.getFuelLevel(), 20);
  }

  @Test
  public void setFuelLevel() {
    tieFighter.setFuelLevel(20);
    assertEquals(tieFighter.getFuelLevel(), 20);
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(tieFighter.getDestructionLevel(), 30);
  }

  @Test
  public void setDestructionLevel() {
    tieFighter.setDestructionLevel(20);
    assertEquals(tieFighter.getDestructionLevel(), 20);
  }
  @Test
  public void isDestroyed() {
    assertFalse(tieFighter.isDestroyed());
  }
  @Test
  public void setDestroyed() {
    tieFighter.setDestroyed(true);
    assertTrue(tieFighter.isDestroyed());
  }

  @Test
  public void getMaxAttackLevel() {
    assertEquals(tieFighter.getMaxAttackLevel(), 25);
  }

  @Test
  public void setMaxAttackLevel() {
    tieFighter.setMaxAttackLevel(20);
    assertEquals(tieFighter.getMaxAttackLevel(), 20);
  }
}