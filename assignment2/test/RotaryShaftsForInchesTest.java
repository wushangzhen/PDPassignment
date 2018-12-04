package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test for inches rotary shaft.
 */
public class RotaryShaftsForInchesTest {
  private final String DIAMETER_FITTED_SHAFT = "1/8\"";
  private final String SKU_NUMBER_FITTED_SHAFT = "1327k93";
  private final String LENGTH_FOR_FITTED_SHAFT = "3\"";
  private final int DOLLARS_FOR_FITTED_SHAFT = 2;
  private final int CENTS_FOR_FITTED_SHAFT = 93;
  private Price priceFittedShaft = new Price(DOLLARS_FOR_FITTED_SHAFT, CENTS_FOR_FITTED_SHAFT);
  RotaryShaftsForInches fittedShaft = new RotaryShaftsForInches(SKU_NUMBER_FITTED_SHAFT,
      priceFittedShaft, LENGTH_FOR_FITTED_SHAFT, DIAMETER_FITTED_SHAFT);
  private final String CHANGED_DIAMETER_FOR_SHAFT = "9mm";

  @Test
  public void getLength() {
    assertEquals(fittedShaft.getLength(), LENGTH_FOR_FITTED_SHAFT);
  }

  @Test
  public void setLength() {
    final String CHANGED_LENGTH = "1/32\"";
    fittedShaft.setLength(CHANGED_LENGTH);
    assertEquals(fittedShaft.getLength(), CHANGED_LENGTH);
  }

  @Test
  public void getDiameter() {
    assertEquals(fittedShaft.getDiameter(), DIAMETER_FITTED_SHAFT);
  }

  @Test
  public void setDiameter() {
    fittedShaft.setLength(CHANGED_DIAMETER_FOR_SHAFT);
    assertEquals(fittedShaft.getDiameter(), DIAMETER_FITTED_SHAFT);
  }

  @Test
  public void getShaftDiameter() {
    assertEquals(fittedShaft.getShaftDiameter(), DIAMETER_FITTED_SHAFT);
  }

  @Test
  public void getCategory() {
    assertEquals(fittedShaft.getCategory(), Category.ROTARY_SHAFTS);
  }

  @Test
  public void setCategory() {
    fittedShaft.setCategory(Category.SPROCKET);
    assertEquals(fittedShaft.getCategory(), Category.SPROCKET);
  }

  @Test
  public void getSkuNumber() {
    assertEquals(fittedShaft.getSkuNumber(), SKU_NUMBER_FITTED_SHAFT);
  }

  @Test
  public void setSkuNumber() {
    final String CHANGED_SKU_NUMBER = "6663K11";
    fittedShaft.setSkuNumber(CHANGED_SKU_NUMBER);
    assertEquals(fittedShaft.getSkuNumber(), CHANGED_SKU_NUMBER);
  }

  @Test
  public void getPrice() {
    assertEquals(fittedShaft.getPrice(), priceFittedShaft);
  }

  @Test
  public void setPrice() {
    final int CHANGED_DOLLARS = 3;
    final int CHANGED_CENTS = 1;
    Price changedPrice = new Price(CHANGED_DOLLARS, CHANGED_CENTS);
    fittedShaft.setPrice(changedPrice);
    assertEquals(fittedShaft.getPrice(), changedPrice);
  }

  @Test
  public void getMeasurement() {
    assertEquals(fittedShaft.getMeasurement(), Measurement.INCH);
  }

  @Test
  public void setMeasurement() {
    fittedShaft.setMeasurement(Measurement.METRIC);
    assertEquals(fittedShaft.getMeasurement(), Measurement.METRIC);
  }
}