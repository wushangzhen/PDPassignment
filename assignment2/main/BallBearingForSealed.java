package edu.neu.ccs.cs5010.assignment2;

/**
 * A class for sealed ball bearings.
 */
public class BallBearingForSealed extends BallBearing implements StockItem {

  BallBearingForSealed(String skuNumber, Price price, String width,
      String forShaftNumber) {
    super(Category.BALL_BEARING, skuNumber, price, SealType.SEALED, width,
        forShaftNumber, Measurement.METRIC, Measurement.METRIC);
  }

}
