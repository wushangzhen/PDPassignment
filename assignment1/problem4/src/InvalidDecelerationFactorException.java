package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * An exception throws when invalid deceleration factor happens.
 */
public class InvalidDecelerationFactorException extends Exception {

  InvalidDecelerationFactorException() {
    System.out.println("Invalid Deceleration parameter");
  }

}
