package edu.neu.ccs.cs5010.assignment2;

/**
 * An interface represents all the methods can be implemented by shaft-mounted devices.
 */
public interface ForShaftMounted {

  boolean fitsShaft(RotaryShaft rotaryShaft) throws Exception;
}
