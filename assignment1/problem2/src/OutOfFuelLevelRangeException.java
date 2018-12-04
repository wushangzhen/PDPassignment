package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * An exception represents out of fuel level range situations.
 */
public class OutOfFuelLevelRangeException extends Exception {

  OutOfFuelLevelRangeException() {
    System.out.println("The ship fuel level is out of bound");
  }
}
