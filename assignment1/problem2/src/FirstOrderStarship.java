package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * A class represents First Order Starship.
 */
public abstract class FirstOrderStarship extends Starships {

  FirstOrderStarship(int fuelLevel, int destructionLevel,
      boolean isDestroyed, int maxAttackLevel) {
    super(fuelLevel, destructionLevel, isDestroyed, maxAttackLevel);
  }

  /**
   * Override the attack method to allow first order ship can only attack their enemy.
   *
   * @param starShip The attack object
   * @param attackLevel The attack level the ship is about to deliver
   */
  @Override
  public void attack(Starships starShip, int attackLevel) throws Exception {
    if (starShip instanceof ResistanceStarships) {
      super.attack(starShip, attackLevel);
    } else {
      throw new InvalidAttackObjectException();
    }
  }
}
