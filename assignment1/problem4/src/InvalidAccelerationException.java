package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * An exception which is thrown when invalid acceleration occur.
 */
public class InvalidAccelerationException extends Exception {

  InvalidAccelerationException() {
    System.out.println("The process of acceleration is invalid");
  }
}
