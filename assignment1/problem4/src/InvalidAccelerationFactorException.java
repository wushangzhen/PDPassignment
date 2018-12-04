package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * An exception throws when invalid acceleration factor happens.
 */
public class InvalidAccelerationFactorException extends Exception {

  InvalidAccelerationFactorException() {
    System.out.println("Invalid Acceleration Parameter");
  }
}
