package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * An exception which is thrown when invalid deceleration occurs.
 */
public class InvalidDecelerationException extends Exception {

  InvalidDecelerationException() {
    System.out.println("The deceleration process is invalid");
  }
}
