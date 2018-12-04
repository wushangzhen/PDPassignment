package edu.neu.ccs.cs5010.assignment2;

/**
 * An abstract class represents the basic factor of a stockItem and implement stockItem interface.
 */
public abstract class BasicFactor implements StockItem {

  private Category category;
  private String skuNumber;
  private Price price;
  private Measurement measurement;

  BasicFactor(Category category, String skuNumber,
      Price price, Measurement measurement) {
    this.category = category;
    this.skuNumber = skuNumber;
    this.price = price;
    this.measurement = measurement;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getSkuNumber() {
    return this.skuNumber;
  }

  public void setSkuNumber(String skuNumber) {
    this.skuNumber = skuNumber;
  }

  public Price getPrice() {
    return this.price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Measurement getMeasurement() {
    return measurement;
  }

  public void setMeasurement(Measurement measurement) {
    this.measurement = measurement;
  }

  /**
   * An abstract method that get shaft's diameter and shaft-mounted devices' for shaft diameter
   * value.
   * @return A string represents for shaft diameter
   */
  public abstract String getShaftDiameter();
}
