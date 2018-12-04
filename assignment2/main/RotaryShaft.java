package edu.neu.ccs.cs5010.assignment2;

/**
 *An abstract class for rotary shaft which extends from basic factor super class.
 */
public abstract class RotaryShaft extends BasicFactor implements StockItem {

  private String length;
  private String diameter;

  /**
   * A constructor for RotaryShaft.
   * @param category A class represents category
   * @param skuNumber A string represents sku number
   * @param price A class represents price
   * @param length A String represents length
   * @param diameter A String represents diameter
   * @param measurement A enum class for measurement
   */
  public RotaryShaft(Category category, String skuNumber, Price price,
      String length, String diameter, Measurement measurement) {
    super(category, skuNumber, price, measurement);
    this.length = length;
    this.diameter = diameter;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public String getDiameter() {
    return diameter;
  }

  public void setDiameter(String diameter) {
    this.diameter = diameter;
  }

  /**
   * An override method to get rotary shafts' diameter.
   * @return A String represents shaft's diameter
   */
  @Override
  public String getShaftDiameter() {
    return diameter;
  }
}
