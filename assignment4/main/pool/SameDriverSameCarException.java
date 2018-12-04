package edu.neu.ccs.cs5010.assignment4.pool;

/**
 * A exception indicates the same driver and same car.
 */
public class SameDriverSameCarException extends Exception {


  public SameDriverSameCarException() {
    System.out.println("The same Driver and same car has existed");
  }
}
