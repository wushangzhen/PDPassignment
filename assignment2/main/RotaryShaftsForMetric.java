package edu.neu.ccs.cs5010.assignment2;

/**
 * A class represents rotary shafts measured by metric.
 */
public class RotaryShaftsForMetric extends RotaryShaft implements StockItem {

  RotaryShaftsForMetric(String skuNumber, Price price, String length, String diameter) {
    super(Category.ROTARY_SHAFTS, skuNumber, price, length, diameter, Measurement.METRIC);
  }
}
