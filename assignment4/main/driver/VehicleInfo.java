package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.Objects;

/**
 * A class for vehicle information.
 */
public class VehicleInfo {

  private String make;
  private String model;
  private String yearOfVehicle;
  private String officialOwner;

  /**
   * Auto generated equal and hashCode method.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    VehicleInfo that = (VehicleInfo) object;
    return Objects.equals(make, that.make)
        && Objects.equals(model, that.model)
        && Objects.equals(yearOfVehicle, that.yearOfVehicle)
        && Objects.equals(officialOwner, that.officialOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, yearOfVehicle, officialOwner);
  }

  /**
   * A constructor of vehicle information.
   * @param make make
   * @param model model
   * @param yearOfVehicle year of vehicle
   * @param officialOwner official owner
   */
  public VehicleInfo(String make, String model, String yearOfVehicle, String officialOwner) {
    this.make = make;
    this.model = model;
    this.yearOfVehicle = yearOfVehicle;
    this.officialOwner = officialOwner;
  }

  /**
   * Some getters and setters.
   */
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

  public String getYearOfVehicle() {
    return yearOfVehicle;
  }

  public void setYearOfVehicle(String yearOfVehicle) {
    this.yearOfVehicle = yearOfVehicle;
  }

  public String getOfficialOwner() {
    return officialOwner;
  }

  public void setOfficialOwner(String officialOwner) {
    this.officialOwner = officialOwner;
  }

  /**
   * override toString method to get the standard output.
   *
   * @return The standard output
   */
  @Override
  public String toString() {
    return yearOfVehicle + " " + model + ", " + make;
  }
}
