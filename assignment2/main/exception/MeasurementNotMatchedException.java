package edu.neu.ccs.cs5010.assignment2.exception;

/**
 * An Exception throws when the shaft-mounted device's measurement are not matched with shafts'.
 */
public class MeasurementNotMatchedException extends Exception {

  public MeasurementNotMatchedException() {
    System.out.println("The Measurement is not matched");
  }

}
