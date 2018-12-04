package edu.neu.ccs.cs5010.assignment2;

/**
 * A class represents rotary shafts measured by inches.
 */
public class RotaryShaftsForInches extends RotaryShaft implements StockItem {

  RotaryShaftsForInches(String skuNumber, Price price, String length, String diameter) {
    super(Category.ROTARY_SHAFTS, skuNumber, price, length, diameter, Measurement.INCH);
  }
}
