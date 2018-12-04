package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * An abstract class represents the Starship category.
 */
public abstract class Starships {

  private int fuelLevel;
  private int destructionLevel;
  private boolean isDestroyed;
  private int maxAttackLevel;

  Starships(int fuelLevel, int destructionLevel,
      boolean isDestroyed, int maxAttackLevel) {
    this.fuelLevel = fuelLevel;
    this.destructionLevel = destructionLevel;
    this.isDestroyed = isDestroyed;
    this.maxAttackLevel = maxAttackLevel;
  }


  /**
   * A method to change the Starship's fuel level.
   *
   * @param number The number the fuel level is about to change
   * @throws Exception Two Exceptions are thrown, including the situations that fuel level is out of
   *     range and ship is already dead
   */
  public void changeFuel(int number) throws Exception {
    if (this.isDestroyed == false) {
      int tempFuelLevel = this.fuelLevel + number;
      if (tempFuelLevel <= 100 && tempFuelLevel >= 0) {
        this.fuelLevel += number;
      } else {
        throw new OutOfFuelLevelRangeException();
      }
    } else {
      throw new ShipIsDeadException();
    }
  }

  /**
   * A method to change destruction level.
   *
   * @param attackLevel The level of destruction the ship receives
   * @throws ShipIsDeadException An exception is thrown when the ship is already dead
   */
  public void changeDestructionLevel(int attackLevel) throws ShipIsDeadException {
    if (this.isDestroyed == false) {
      this.destructionLevel += attackLevel;
      if (this.destructionLevel > 100) {
        this.isDestroyed = true;
      }
    } else {
      throw new ShipIsDeadException();
    }
  }

  /**
   * A method for starship to attack their enemy.
   *
   * @param starShip The attack object
   * @param attackLevel The attack level the ship is about to deliver
   * @throws Exception An Exception is thrown when ship is dead;
   */
  public void attack(Starships starShip, int attackLevel) throws Exception {
    if (isDestroyed == false && !starShip.isDestroyed) {
      if (attackLevel > this.maxAttackLevel || attackLevel < 0) {
        throw new OutOfAttackLevelRangeException();
      }
      try {
        starShip.changeDestructionLevel(attackLevel);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      throw new ShipIsDeadException();
    }
  }

  public int getFuelLevel() {
    return fuelLevel;
  }

  public void setFuelLevel(int fuelLevel) {
    this.fuelLevel = fuelLevel;
  }

  public int getDestructionLevel() {
    return destructionLevel;
  }

  public void setDestructionLevel(int destructionLevel) {
    this.destructionLevel = destructionLevel;
  }

  public void setDestroyed(boolean destroyed) {
    isDestroyed = destroyed;
  }

  public int getMaxAttackLevel() {
    return maxAttackLevel;
  }

  public void setMaxAttackLevel(int maxAttackLevel) {
    this.maxAttackLevel = maxAttackLevel;
  }

  public boolean isDestroyed() {
    return isDestroyed;
  }
}
