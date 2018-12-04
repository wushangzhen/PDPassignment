package edu.neu.ccs.cs5010.assignment3.part1;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment2.BallBearing;
import edu.neu.ccs.cs5010.assignment2.BallBearingForShielded;
import edu.neu.ccs.cs5010.assignment2.BasicFactor;
import edu.neu.ccs.cs5010.assignment2.Measurement;
import edu.neu.ccs.cs5010.assignment2.Price;
import edu.neu.ccs.cs5010.assignment2.RotaryShaftsForMetric;
import edu.neu.ccs.cs5010.assignment2.SprocketForStandard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for stock service.
 */
public class StockServiceTest {
  private final int DOLLARS_FOR_BALL_BEARING = 12;
  private final int CENTS_FOR_BALL_BEARING = 21;
  private Price priceBallBearing = new Price(DOLLARS_FOR_BALL_BEARING, CENTS_FOR_BALL_BEARING);
  private final String SKU_NUMBER_BALL_BEARING = "5972K261";
  private final String WIDTH_BALL_BEARING = "6mm";
  private final String DIAMETER_FOR_SHAFT = "7mm";
  BallBearing ballBearing = new BallBearingForShielded(SKU_NUMBER_BALL_BEARING, priceBallBearing,
      WIDTH_BALL_BEARING, DIAMETER_FOR_SHAFT);

  private final String DIAMETER_FITTED_SHAFT = "7mm";
  private final String SKU_NUMBER_FITTED_SHAFT = "1265K57";
  private final String LENGTH_FOR_FITTED_SHAFT = "200mm";
  private final int DOLLARS_FOR_FITTED_SHAFT = 21;
  private final int CENTS_FOR_FITTED_SHAFT = 53;
  private Price priceFittedShaft = new Price(DOLLARS_FOR_FITTED_SHAFT, CENTS_FOR_FITTED_SHAFT);
  RotaryShaftsForMetric fittedShaft = new RotaryShaftsForMetric(SKU_NUMBER_FITTED_SHAFT,
      priceFittedShaft, LENGTH_FOR_FITTED_SHAFT, DIAMETER_FITTED_SHAFT);

  private final int DOLLARS_FOR_SPROCKETS = 3;
  private final int CENTS_FOR_SPROCKETS = 35;
  private Price priceSprocket = new Price(DOLLARS_FOR_SPROCKETS, CENTS_FOR_SPROCKETS);
  private final String SKU_NUMBER_SPROCKETS = "64205K71";
  private final int NUMBER_OF_TEETH = 8;
  private final String DIAMETER_FOR_SHAFT_SPROCKET = "1/8\"";
  SprocketForStandard sprocket = new SprocketForStandard(SKU_NUMBER_SPROCKETS, priceSprocket,
      NUMBER_OF_TEETH, DIAMETER_FOR_SHAFT, Measurement.INCH);

  private Map<String, BasicFactor> map = new HashMap<String, BasicFactor>();
  private StockService stockService;

  @Before
  public void setUp() throws Exception {
    this.map.put(SKU_NUMBER_BALL_BEARING, ballBearing);
    this.map.put(SKU_NUMBER_FITTED_SHAFT, fittedShaft);
    this.stockService = new StockService(map);
  }

  /**
   * Getters and setters test.
   */
  @Test
  public void getStockItemMap() {
    assertEquals(stockService.getStockItemMap(), map);
  }

  @Test
  public void setStockItemMap() {
    this.map.put(SKU_NUMBER_SPROCKETS, sprocket);
    stockService.setStockItemMap(map);
    assertEquals(stockService.getStockItemMap(), map);
  }
}