package edu.neu.ccs.cs5010.assignment2.exception;

/**
 * A exception throws when shaft-mounted devices are not matched with shaft diameter.
 */
public class DiameterNotMatchedException extends Exception {

  public DiameterNotMatchedException() {
    System.out.println("The Diameter is not matched");
  }

}
