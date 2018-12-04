package edu.neu.ccs.cs5010.assignment1.problem4;

import java.util.HashMap;

/**
 * A super abstract class represents vehicle.
 */
public abstract class Vehicle {

  private String color;
  private MakeAndModel makeAndModel;
  private LicensePlate licensePlate;
  private double velocity;
  private int maxVelocity;
  private String direction;
  private HashMap<String, String> rules;

  Vehicle(String color, MakeAndModel makeAndModel,
      LicensePlate licensePlate, double velocity,
      int maxVelocity, String direction) {
    this.color = color;
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.velocity = velocity;
    this.maxVelocity = maxVelocity;
    this.direction = direction;
    rules = new HashMap<String, String>();
    this.rules.put("Northbound", "Southbound");
    this.rules.put("Southbound", "Northbound");
    this.rules.put("Eastbound", "Westbound");
    this.rules.put("Westbound", "Eastbound");
  }

  /**
   * A method to achieve acceleration function.
   * @param accelerationFactor The factor of acceleration
   * @throws Exception Two Exceptions
   */
  void acceleration(double accelerationFactor) throws Exception {
    if (accelerationFactor < 10 || accelerationFactor > 50) {
      throw new InvalidAccelerationFactorException();
    }
    double tempVelocity = this.velocity * (1.0 + accelerationFactor / 100);
    if (tempVelocity > this.maxVelocity) {
      throw new InvalidAccelerationException();
    } else {
      this.setVelocity(tempVelocity);
    }
  }

  /**
   * A method to achieve deceleration function.
   * @param decelerationFactor The factor of deceleration
   * @throws Exception Two Exceptions
   */
  void deceleration(double decelerationFactor) throws Exception {
    if (decelerationFactor < 20 || decelerationFactor > 50) {
      throw new InvalidDecelerationFactorException();
    }
    double tempVelocity = this.velocity * (1.0 - decelerationFactor / 100);
    if (tempVelocity < 40) {
      throw new InvalidDecelerationException();
    } else {
      this.setVelocity(tempVelocity);
    }

  }

  /**
   * A method to change directions.
   * @param direction The direction we should change to
   * @throws InvalidDirectionException An exception will throw when changing invalid direction
   */
  void changeDirection(String direction) throws InvalidDirectionException {
    if (this.rules.get(this.direction).equals(direction)) {
      this.setDirection(direction);
    } else {
      throw new InvalidDirectionException();
    }
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public MakeAndModel getMakeAndModel() {
    return makeAndModel;
  }

  public void setMakeAndModel(MakeAndModel makeAndModel) {
    this.makeAndModel = makeAndModel;
  }

  public LicensePlate getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(LicensePlate licensePlate) {
    this.licensePlate = licensePlate;
  }

  public double getVelocity() {
    return velocity;
  }

  public void setVelocity(double velocity) {
    this.velocity = velocity;
  }

  public int getMaxVelocity() {
    return maxVelocity;
  }

  public void setMaxVelocity(int maxVelocity) {
    this.maxVelocity = maxVelocity;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public HashMap<String, String> getRules() {
    return rules;
  }

  public void setRules(HashMap<String, String> rules) {
    this.rules = rules;
  }
}
