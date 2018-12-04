package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * A class represents resistance starship.
 */
public abstract class ResistanceStarships extends Starships {

  ResistanceStarships(int fuelLevel, int destructionLevel,
      boolean isDestroyed, int maxAttackLevel) {
    super(fuelLevel, destructionLevel, isDestroyed, maxAttackLevel);
  }

  /**
   * Override the method attack which allows the Resistance starship can only attack their enemy.
   *
   * @param starShip The attack object
   * @param attackLevel The attack level the ship is about to deliver
   */
  @Override
  public void attack(Starships starShip, int attackLevel) throws Exception {
    if (starShip instanceof FirstOrderStarship) {
      super.attack(starShip, attackLevel);
    } else {
      throw new InvalidAttackObjectException();
    }
  }
}
