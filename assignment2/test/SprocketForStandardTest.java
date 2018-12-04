package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment2.exception.DiameterNotMatchedException;
import edu.neu.ccs.cs5010.assignment2.exception.MeasurementNotMatchedException;
import org.junit.Test;

/**
 * A test for standard sprocket.
 */
public class SprocketForStandardTest {
  private final int DOLLARS_FOR_SPROCKETS = 3;
  private final int CENTS_FOR_SPROCKETS = 35;
  private Price priceSprocket = new Price(DOLLARS_FOR_SPROCKETS, CENTS_FOR_SPROCKETS);
  private final String SKU_NUMBER_SPROCKETS = "64205K71";
  private final int NUMBER_OF_TEETH = 8;
  private final String DIAMETER_FOR_SHAFT = "1/8\"";
  SprocketForStandard sprocket = new SprocketForStandard(SKU_NUMBER_SPROCKETS, priceSprocket,
      NUMBER_OF_TEETH, DIAMETER_FOR_SHAFT, Measurement.INCH);

  private final String DIAMETER_FITTED_SHAFT = "1/8\"";
  private final String SKU_NUMBER_FITTED_SHAFT = "1327k93";
  private final String LENGTH_FOR_FITTED_SHAFT = "3\"";
  private final int DOLLARS_FOR_FITTED_SHAFT = 2;
  private final int CENTS_FOR_FITTED_SHAFT = 93;
  private Price priceFittedShaft = new Price(DOLLARS_FOR_FITTED_SHAFT, CENTS_FOR_FITTED_SHAFT);
  RotaryShaftsForInches fittedShaft = new RotaryShaftsForInches(SKU_NUMBER_FITTED_SHAFT,
      priceFittedShaft, LENGTH_FOR_FITTED_SHAFT, DIAMETER_FITTED_SHAFT);
  private final String CHANGED_DIAMETER_FOR_SHAFT = "9mm";
  private final String CHANGED_SKU_NUMBER = "5972K222";


  @Test
  public void getForShaftDiameter() {
    assertEquals(sprocket.getForShaftDiameter(), DIAMETER_FOR_SHAFT);
  }

  @Test
  public void setForShaftDiameter() {
    sprocket.setForShaftDiameter(CHANGED_DIAMETER_FOR_SHAFT);
    assertEquals(sprocket.getForShaftDiameter(), CHANGED_DIAMETER_FOR_SHAFT);
  }

  @Test
  public void getMeasurementForShaft() {
    assertEquals(sprocket.getMeasurementForShaft(), Measurement.INCH);
  }

  @Test
  public void setMeasurementForShaft() {
    sprocket.setMeasurementForShaft(Measurement.INCH);
    assertEquals(sprocket.getMeasurementForShaft(), Measurement.INCH);
  }

  @Test
  public void fitsShaft() throws Exception {
    assertEquals(sprocket.fitsShaft(fittedShaft), true);
  }

  @Test(expected = DiameterNotMatchedException.class)
  public void fitsShaftDiameterNotMatchedException() throws Exception {
    fittedShaft.setDiameter(CHANGED_DIAMETER_FOR_SHAFT);
    assertEquals(sprocket.fitsShaft(fittedShaft), true);

  }

  @Test(expected = MeasurementNotMatchedException.class)
  public void fitShaftMeasurementNotMatchedException() throws Exception {
    fittedShaft.setMeasurement(Measurement.METRIC);
    assertEquals(sprocket.fitsShaft(fittedShaft), true);
  }

  @Test
  public void getShaftDiameter() {
    assertEquals(sprocket.getShaftDiameter(), sprocket.getForShaftDiameter());
  }

  @Test
  public void getCategory() {
    assertEquals(sprocket.getCategory(), Category.SPROCKET);
  }

  @Test
  public void setCategory() {
    sprocket.setCategory(Category.SPROCKET);
    assertEquals(sprocket.getCategory(), Category.SPROCKET);
  }

  @Test
  public void getSkuNumber() {
    assertEquals(sprocket.getSkuNumber(), SKU_NUMBER_SPROCKETS);
  }

  @Test
  public void setSkuNumber() {
    sprocket.setSkuNumber(CHANGED_SKU_NUMBER);
    assertEquals(sprocket.getSkuNumber(), CHANGED_SKU_NUMBER);
  }

  @Test
  public void getPrice() {
    assertEquals(sprocket.getPrice(), priceSprocket);
  }

  @Test
  public void setPrice() {
    final int CHANGED_DOLLARS = 2;
    final int CHANGED_CENTS = 1;
    Price changedPrice = new Price(CHANGED_DOLLARS, CHANGED_CENTS);
    sprocket.setPrice(changedPrice);
    assertEquals(sprocket.getPrice(), changedPrice);
  }

  @Test
  public void getMeasurement() {
    assertEquals(sprocket.getMeasurement(), Measurement.STANDARD);
  }

  @Test
  public void setMeasurement() {
    sprocket.setMeasurement(Measurement.INCH);
    assertEquals(sprocket.getMeasurement(), Measurement.INCH);
  }

  @Test
  public void getTeethNumber() {
    assertEquals(sprocket.getTeethNumber(), NUMBER_OF_TEETH);
  }

  @Test
  public void setTeethNumber() {
    final int CHANGED_TEETH_NUMBER = 100;
    sprocket.setTeethNumber(CHANGED_TEETH_NUMBER);
    assertEquals(sprocket.getTeethNumber(), CHANGED_TEETH_NUMBER);
  }
}
