package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment2.exception.DiameterNotMatchedException;
import edu.neu.ccs.cs5010.assignment2.exception.MeasurementNotMatchedException;
import org.junit.Test;

/**
 * A test for sealed ball bearing.
 */
public class BallBearingForSealedTest {
  private final int DOLLARS_FOR_BALL_BEARING = 20;
  private final int CENTS_FOR_BALL_BEARING = 26;
  private Price priceBallBearing = new Price(DOLLARS_FOR_BALL_BEARING, CENTS_FOR_BALL_BEARING);
  private final String SKU_NUMBER_BALL_BEARING = "5972K225";
  private final String WIDTH_BALL_BEARING = "6mm";
  private final String DIAMETER_FOR_SHAFT = "7mm";
  BallBearing ballBearing = new BallBearingForSealed(SKU_NUMBER_BALL_BEARING, priceBallBearing,
      WIDTH_BALL_BEARING, DIAMETER_FOR_SHAFT);

  private final String DIAMETER_FITTED_SHAFT = "7mm";
  private final String SKU_NUMBER_FITTED_SHAFT = "1265K57";
  private final String LENGTH_FOR_FITTED_SHAFT = "200mm";
  private final int DOLLARS_FOR_FITTED_SHAFT = 21;
  private final int CENTS_FOR_FITTED_SHAFT = 53;
  private Price priceFittedShaft = new Price(DOLLARS_FOR_FITTED_SHAFT, CENTS_FOR_FITTED_SHAFT);
  RotaryShaftsForMetric fittedShaft = new RotaryShaftsForMetric(SKU_NUMBER_FITTED_SHAFT,
      priceFittedShaft, LENGTH_FOR_FITTED_SHAFT, DIAMETER_FITTED_SHAFT);
  private final String CHANGED_WIDTH = "7mm";
  private final String CHANGED_DIAMETER_FOR_SHAFT = "9mm";
  private final String CHANGED_SKU_NUMBER = "5972K222";


  @Test
  public void getSealType() {
    assertEquals(ballBearing.getSealType(), SealType.SEALED);
  }

  @Test
  public void getWidth() {
    assertEquals(ballBearing.getWidth(), WIDTH_BALL_BEARING);
  }

  @Test
  public void setWidth() {
    ballBearing.setWidth(CHANGED_WIDTH);
    assertEquals(ballBearing.getWidth(), CHANGED_WIDTH);
  }

  @Test
  public void getForShaftDiameter() {
    assertEquals(ballBearing.getForShaftDiameter(), DIAMETER_FOR_SHAFT);
  }

  @Test
  public void setForShaftDiameter() {
    ballBearing.setForShaftDiameter(CHANGED_DIAMETER_FOR_SHAFT);
    assertEquals(ballBearing.getForShaftDiameter(), CHANGED_DIAMETER_FOR_SHAFT);
  }

  @Test
  public void getMeasurementForShaft() {
    assertEquals(ballBearing.getMeasurementForShaft(), Measurement.METRIC);
  }

  @Test
  public void setMeasurementForShaft() {
    ballBearing.setMeasurementForShaft(Measurement.INCH);
    assertEquals(ballBearing.getMeasurementForShaft(), Measurement.INCH);
  }

  /**
   * A test for fitted shaft value.
   * @throws Exception No exception will be thrown
   */
  @Test
  public void fitsShaft() throws Exception {
    assertEquals(ballBearing.fitsShaft(fittedShaft), true);
  }

  /**
   * A test for diameter not matched exception.
   * @throws Exception Name not matched
   */
  @Test(expected = DiameterNotMatchedException.class)
  public void fitsShaftDiameterNotMatchedException() throws Exception {
    fittedShaft.setDiameter(CHANGED_DIAMETER_FOR_SHAFT);
    assertEquals(ballBearing.fitsShaft(fittedShaft), true);

  }

  /**
   * A test for measurement not matched exception.
   * @throws Exception measurement not matched
   */
  @Test(expected = MeasurementNotMatchedException.class)
  public void fitShaftMeasurementNotMatchedException() throws Exception {
    fittedShaft.setMeasurement(Measurement.INCH);
    assertEquals(ballBearing.fitsShaft(fittedShaft), true);
  }

  @Test
  public void getShaftDiameter() {
    assertEquals(ballBearing.getShaftDiameter(), ballBearing.getForShaftDiameter());
  }

  @Test
  public void getCategory() {
    assertEquals(ballBearing.getCategory(), Category.BALL_BEARING);
  }

  @Test
  public void setCategory() {
    ballBearing.setCategory(Category.SPROCKET);
    assertEquals(ballBearing.getCategory(), Category.SPROCKET);
  }

  @Test
  public void getSkuNumber() {
    assertEquals(ballBearing.getSkuNumber(), SKU_NUMBER_BALL_BEARING);
  }

  @Test
  public void setSkuNumber() {
    ballBearing.setSkuNumber(CHANGED_SKU_NUMBER);
    assertEquals(ballBearing.getSkuNumber(), CHANGED_SKU_NUMBER);
  }

  @Test
  public void getPrice() {
    assertEquals(ballBearing.getPrice(), priceBallBearing);
  }

  @Test
  public void setPrice() {
    final int CHANGED_DOLLARS = 1;
    final int CHANGED_CENTS = 1;
    Price changedPrice = new Price(CHANGED_DOLLARS, CHANGED_CENTS);
    ballBearing.setPrice(changedPrice);
    assertEquals(ballBearing.getPrice(), changedPrice);
  }

  @Test
  public void getMeasurement() {
    assertEquals(ballBearing.getMeasurement(), Measurement.METRIC);
  }

  @Test
  public void setMeasurement() {
    ballBearing.setMeasurement(Measurement.INCH);
    assertEquals(ballBearing.getMeasurement(), Measurement.INCH);
  }

}