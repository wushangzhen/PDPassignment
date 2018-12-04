package edu.neu.ccs.cs5010.assignment1.problem4;


/**
 * A class represents make and model information.
 */
public class MakeAndModel {

  String make;
  String model;

  MakeAndModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
