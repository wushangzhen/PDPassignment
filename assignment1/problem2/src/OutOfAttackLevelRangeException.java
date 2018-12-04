package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * An exception represents out of attack level situations.
 */
public class OutOfAttackLevelRangeException extends Exception {

  OutOfAttackLevelRangeException() {
    System.out.println("Attack level is out of ship's max attack level");
  }

}
