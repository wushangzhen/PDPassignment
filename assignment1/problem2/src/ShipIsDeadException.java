package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * An exception represents the ship is dead.
 */
public class ShipIsDeadException extends Exception {

  ShipIsDeadException() {
    System.out.println("Ship is destroyed");
  }
}
