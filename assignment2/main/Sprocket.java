package edu.neu.ccs.cs5010.assignment2;

import edu.neu.ccs.cs5010.assignment2.exception.DiameterNotMatchedException;
import edu.neu.ccs.cs5010.assignment2.exception.MeasurementNotMatchedException;

/**
 * An abstract class sprockets extends from basic factor.
 */
public abstract class Sprocket extends BasicFactor implements StockItem,
    ForShaftMounted {

  private int teethNumber;
  private String forShaftDiameter;
  private Measurement measurementForShaft;

  /**
   * A constructor for sprocket.
   * @param category An enum class represents category
   * @param skuNumber A string represent SKU number
   * @param price A class represents price
   * @param teethNumber A int type of parameter represents the number of teeth of sprocket
   * @param forShaftDiameter A string represents fitted shaft diameter
   * @param measurementForShaft A class named measurement for fitted shaft
   * @param measurement sprocket measurement
   */
  public Sprocket(Category category, String skuNumber, Price price,
      int teethNumber, String forShaftDiameter,
      Measurement measurementForShaft,
      Measurement measurement) {
    super(category, skuNumber, price, measurement);
    this.teethNumber = teethNumber;
    this.forShaftDiameter = forShaftDiameter;
    this.measurementForShaft = measurementForShaft;
  }

  public int getTeethNumber() {
    return teethNumber;
  }

  public void setTeethNumber(int teethNumber) {
    this.teethNumber = teethNumber;
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

  public void setMeasurementForShaft(Measurement measurementForShaftDiameter) {
    this.measurementForShaft = measurementForShaftDiameter;
  }
  /**
   * An Override method which checks whether shaft matches sprocket.
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
   * An override method which can get sprocket for shaft diameter.
   * @return A string represent for shaft diameter
   */
  @Override
  public String getShaftDiameter() {
    return forShaftDiameter;
  }
}
