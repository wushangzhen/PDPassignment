package edu.neu.ccs.cs5010.assignment2;

/**
 * A class represents shielded ball bearings.
 */
public class BallBearingForShielded extends BallBearing implements StockItem {

  BallBearingForShielded(String skuNumber, Price price, String width,
      String forShaftNumber) {
    super(Category.BALL_BEARING, skuNumber, price, SealType.SHIELDED, width, forShaftNumber,
        Measurement.METRIC, Measurement.METRIC);
  }
}
