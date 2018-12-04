package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * A class represents StarDestroyer starship.
 */
public class StarDestroyer extends FirstOrderStarship {

  StarDestroyer(int fuelLevel, int destructionLevel,
      boolean isDestroyed) {
    super(fuelLevel, destructionLevel, isDestroyed, 50);
  }
}
