package edu.neu.ccs.cs5010.assignment1.problem4;


/**
 * A class represents truck.
 */
public class Truck extends Vehicle {

  Truck(String color, MakeAndModel makeAndModel,
      LicensePlate licensePlate, double velocity,
      String direction) {
    super(color, makeAndModel, licensePlate, velocity, 60, direction);
  }
}
