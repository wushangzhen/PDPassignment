package edu.neu.ccs.cs5010.assignment2;

/**
 * A class represents standard typr of sprockets.
 */
public class SprocketForStandard extends Sprocket implements StockItem, ForShaftMounted {

  SprocketForStandard(String skuNumber, Price price, int teethNumber,
      String forShaftDiameter, Measurement measurementForShaft) {
    super(Category.SPROCKET, skuNumber, price, teethNumber, forShaftDiameter,
        measurementForShaft, Measurement.STANDARD);
  }
}
