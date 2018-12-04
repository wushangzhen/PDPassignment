package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * A class represents TIE Fighter starships.
 */
public class TieFighter extends FirstOrderStarship {

  TieFighter(int fuelLevel, int destructionLevel,
      boolean isDestroyed) {
    super(fuelLevel, destructionLevel, isDestroyed, 25);
  }
}
