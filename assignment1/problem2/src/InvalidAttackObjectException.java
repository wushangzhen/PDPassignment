package edu.neu.ccs.cs5010.assignment1.probem2;

/**
 * An exception represents invalid attack object.
 */
public class InvalidAttackObjectException extends Exception {

  InvalidAttackObjectException() {
    System.out.println("They are in the same side, the attack can not be executed");
  }

}
