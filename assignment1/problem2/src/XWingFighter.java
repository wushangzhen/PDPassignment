package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * A class represents Xwing Fighter starships.
 */
public class XWingFighter extends ResistanceStarships {

  XWingFighter(int fuelLevel, int destructionLevel,
      boolean isDestroyed) {
    super(fuelLevel, destructionLevel, isDestroyed, 40);
  }
}
