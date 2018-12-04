package edu.neu.ccs.cs5010.assignment2;

/**
 * A class represents metric sprockets.
 */
public class SprocketForMetric extends Sprocket implements StockItem, ForShaftMounted {

  SprocketForMetric(String skuNumber, Price price, int teethNumber,
      String forShaftDiameter, Measurement measurementForShaft) {
    super(Category.SPROCKET, skuNumber, price, teethNumber, forShaftDiameter,
        measurementForShaft, Measurement.METRIC);
  }

}
