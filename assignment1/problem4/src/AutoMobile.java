package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * A class of AutoMobile.
 */
public class AutoMobile extends Vehicle {

  AutoMobile(String color, MakeAndModel makeAndModel,
      LicensePlate licensePlate, double velocity,
      String direction) {
    super(color, makeAndModel, licensePlate, velocity, 70, direction);
  }
}
