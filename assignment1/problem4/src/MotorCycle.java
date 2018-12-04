package edu.neu.ccs.cs5010.assignment1.problem4;


/**
 * A class of motorcycle.
 */
public class MotorCycle extends Vehicle {

  MotorCycle(String color, MakeAndModel makeAndModel,
      LicensePlate licensePlate, double velocity,
      String direction) {
    super(color, makeAndModel, licensePlate, velocity, 65, direction);
  }
}
