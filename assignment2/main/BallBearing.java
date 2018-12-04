package edu.neu.ccs.cs5010.assignment2;

import edu.neu.ccs.cs5010.assignment2.exception.DiameterNotMatchedException;
import edu.neu.ccs.cs5010.assignment2.exception.MeasurementNotMatchedException;

/**
 * An abstract class Ball Bearing extends from BasicFactor and implement StockItem interface.
 */
public abstract class BallBearing extends BasicFactor implements StockItem,
    ForShaftMounted {

  private SealType sealType;
  private String width;
  private String forShaftDiameter;
  private Measurement measurementForShaft;

  /**
   * A constructor for Ball Bearing.
   * @param category An enum class for category
   * @param skuNumber A string represents SKU number
   * @param price A class represents price
   * @param sealType A class represent the ball bearing seal type
   * @param width A string represents width
   * @param forShaftDiameter A string represents fitted shaft diameter
   * @param measurementForShaft An enum class represents fitted shaft measurement
   * @param measurement An enum class represents ball bearing's measurement
   */
  public BallBearing(Category category, String skuNumber, Price price,
      SealType sealType, String width, String forShaftDiameter,
      Measurement measurementForShaft, Measurement measurement) {
    super(category, skuNumber, price, measurement);
    this.sealType = sealType;
    this.width = width;
    this.forShaftDiameter = forShaftDiameter;
    this.measurementForShaft = measurementForShaft;
  }

  public SealType getSealType() {
    return sealType;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public String getForShaftDiameter() {
    return forShaftDiameter;
  }

  public void setForShaftDiameter(String forShaftDiameter) {
    this.forShaftDiameter = forShaftDiameter;
  }

  public Measurement getMeasurementForShaft() {
    return measurementForShaft;
  }

  public void setMeasurementForShaft(Measurement measurementForShaft) {
    this.measurementForShaft = measurementForShaft;
  }

  /**
   * An Override method which checks whether shaft matches ball bearing.
   * @param rotaryShaft A rotary shaft
   * @return Boolean value which means whether they are matched
   * @throws Exception Throws when diameter not matched and measurement not matched
   */
  @Override
  public boolean fitsShaft(RotaryShaft rotaryShaft) throws Exception {
    if (rotaryShaft.getMeasurement().equals(this.getMeasurementForShaft())) {
      if (rotaryShaft.getDiameter().equals(this.getForShaftDiameter())) {
        return true;
      } else {
        throw new DiameterNotMatchedException();
      }
    } else {
      throw new MeasurementNotMatchedException();
    }
  }

  /**
   * A overRide method to get for shaft diameter parameter.
   * @return A String represents for shaft diameter
   */
  @Override
  public String getShaftDiameter() {
    return forShaftDiameter;
  }
}
