package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * A class of bus.
 */
public class Bus extends Vehicle {

  Bus(String color, MakeAndModel makeAndModel,
      LicensePlate licensePlate, double velocity,
      String direction) {
    super(color, makeAndModel, licensePlate, velocity, 60, direction);
  }
}
