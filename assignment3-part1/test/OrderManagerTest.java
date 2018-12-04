package edu.neu.ccs.cs5010.assignment3.part1;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment2.BallBearing;
import edu.neu.ccs.cs5010.assignment2.BallBearingForShielded;
import edu.neu.ccs.cs5010.assignment2.BasicFactor;
import edu.neu.ccs.cs5010.assignment2.Measurement;
import edu.neu.ccs.cs5010.assignment2.Price;
import edu.neu.ccs.cs5010.assignment2.RotaryShaftsForInches;
import edu.neu.ccs.cs5010.assignment2.RotaryShaftsForMetric;
import edu.neu.ccs.cs5010.assignment2.SprocketForMetric;
import edu.neu.ccs.cs5010.assignment2.SprocketForStandard;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * order manager test
 */
public class OrderManagerTest {
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

  private Map<String, BasicFactor> map = new HashMap<String, BasicFactor>();
  private StockService stockService;
  private List<String> currentOrderList;
  private OrderManager orderManager;
  final String WRONG_SKU = "#SSSS";

 final int DOLLARS_FOR_SPROCKETS = 3;
  private final int CENTS_FOR_SPROCKETS = 35;
  private Price priceSprocket = new Price(DOLLARS_FOR_SPROCKETS, CENTS_FOR_SPROCKETS);
  private final String SKU_NUMBER_SPROCKETS = "64205K71";
  private final int NUMBER_OF_TEETH = 8;
  private final String DIAMETER_FOR_SHAFT_SPROCKET = "1/8\"";
  SprocketForStandard sprocket = new SprocketForStandard(SKU_NUMBER_SPROCKETS, priceSprocket,
      NUMBER_OF_TEETH, DIAMETER_FOR_SHAFT, Measurement.INCH);

  private final String DIAMETER_SHAFT_INCH = "1/8\"";
  private final String SKU_NUMBER_SHAFT_INCH = "1327k93";
  private final String LENGTH_FOR_SHAFT_INCH = "3\"";
  private final int DOLLARS_FOR_SHAFT_INCH = 2;
  private final int CENTS_FOR_SHAFT_INCH = 93;
  private Price priceInchShaft = new Price(DOLLARS_FOR_SHAFT_INCH, CENTS_FOR_SHAFT_INCH);
  RotaryShaftsForInches inchShaft = new RotaryShaftsForInches(SKU_NUMBER_SHAFT_INCH,
      priceInchShaft, LENGTH_FOR_SHAFT_INCH, DIAMETER_SHAFT_INCH);
  private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
  private ByteArrayInputStream bais;

  /**
   * A test for add order operations.
   */
  @Test
  public void addToOrder() {
    assertTrue(orderManager.addToOrder(SKU_NUMBER_BALL_BEARING));
    assertFalse(orderManager.addToOrder(WRONG_SKU));
  }

  /**
   * A test for remove the order.
   */
  @Test
  public void removeOneFromOrder() {
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    assertTrue(orderManager.removeOneFromOrder(SKU_NUMBER_BALL_BEARING));
    assertFalse(orderManager.removeOneFromOrder(WRONG_SKU));
  }

  /**
   * A test for validate the measurement system.
   */
  @Test
  public void validateMeasurementSystem() {
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    assertTrue(orderManager.validateMeasurementSystem());
    orderManager.addToOrder(SKU_NUMBER_FITTED_SHAFT);
    assertTrue(orderManager.validateMeasurementSystem());
    orderManager.addToOrder(SKU_NUMBER_SPROCKETS);
    assertFalse(orderManager.validateMeasurementSystem());
  }

  /**
   * A test for filter measurement system.
   */
  @Test
  public void filterByMeasurementSystem() {
    final int FILTERED_SIZE = 2;
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    orderManager.addToOrder(SKU_NUMBER_FITTED_SHAFT);
    orderManager.addToOrder(SKU_NUMBER_SPROCKETS);
    orderManager.filterByMeasurementSystem(Measurement.METRIC);
    assertEquals(currentOrderList.size(), FILTERED_SIZE);
    orderManager.printDocket();
  }

  /**
   * A test for order category.
   */
  @Test
  public void orderCategory() {
    final String MIXED = "Mixed";
    final String BALL_BEARING = "BALL_BEARING";
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    assertEquals(orderManager.orderCategory(), BALL_BEARING);
    orderManager.addToOrder(SKU_NUMBER_FITTED_SHAFT);
    assertEquals(orderManager.orderCategory(), MIXED);
  }

  /**
   * A test for print the docket.
   */
  @Test
  public void printDocket() {
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    orderManager.addToOrder(SKU_NUMBER_FITTED_SHAFT);
    orderManager.addToOrder(SKU_NUMBER_SPROCKETS);
    orderManager.printDocket();
    String string = "The commodity is moved to orderList\n"
        + "The commodity is moved to orderList\n"
        + "The commodity is moved to orderList\n"
        + "Category: BALL_BEARING SKU Number: 5972K261 Price: $ 12.21\n"
        + "Category: ROTARY_SHAFTS SKU Number: 1265K57 Price: $ 21.53\n"
        + "Category: SPROCKET SKU Number: 64205K71 Price: $ 3.35\n"
        + "The total cost is $ 37.09\n";
    assertEquals(outStream.toString(), string);

  }

  /**
   * A test for check fit.
   */
  @Test
  public void checkFit() {
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    orderManager.addToOrder(SKU_NUMBER_FITTED_SHAFT);
    assertTrue(orderManager.checkFit(SKU_NUMBER_FITTED_SHAFT, SKU_NUMBER_BALL_BEARING));
    orderManager.addToOrder(SKU_NUMBER_SPROCKETS);
    assertFalse(orderManager.checkFit(SKU_NUMBER_BALL_BEARING, SKU_NUMBER_SPROCKETS));
    orderManager.addToOrder(SKU_NUMBER_SHAFT_INCH);
    assertFalse(orderManager.checkFit(SKU_NUMBER_BALL_BEARING, SKU_NUMBER_SHAFT_INCH));
    assertFalse(orderManager.checkFit(SKU_NUMBER_SPROCKETS, SKU_NUMBER_SHAFT_INCH));
    assertTrue(orderManager.checkFit(SKU_NUMBER_SPROCKETS, SKU_NUMBER_FITTED_SHAFT));
    assertFalse(orderManager.checkFit(SKU_NUMBER_FITTED_SHAFT, SKU_NUMBER_SHAFT_INCH));
  }

  /**
   * A test for check if is pair.
   */
  @Test
  public void checkIfIsPair() {
    orderManager.addToOrder(SKU_NUMBER_BALL_BEARING);
    orderManager.addToOrder(SKU_NUMBER_FITTED_SHAFT);
    assertEquals(orderManager.checkIfIsPair(SKU_NUMBER_FITTED_SHAFT, SKU_NUMBER_BALL_BEARING),
        SKU_NUMBER_FITTED_SHAFT);
    assertEquals(orderManager.checkIfIsPair(SKU_NUMBER_BALL_BEARING, SKU_NUMBER_FITTED_SHAFT),
        SKU_NUMBER_FITTED_SHAFT);
  assertEquals(orderManager.checkIfIsPair(SKU_NUMBER_BALL_BEARING, SKU_NUMBER_BALL_BEARING),
        null);


  }

  @Before
  public void setUp() throws Exception {
    this.map.put(SKU_NUMBER_BALL_BEARING, ballBearing);
    this.map.put(SKU_NUMBER_FITTED_SHAFT, fittedShaft);
    this.map.put(SKU_NUMBER_SPROCKETS, sprocket);
    this.map.put(SKU_NUMBER_SHAFT_INCH, inchShaft);
    this.stockService = new StockService(map);
    this.currentOrderList = new ArrayList<>();
    this.orderManager = new OrderManager(this.currentOrderList, this.stockService);
    System.setOut(new PrintStream(outStream));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(System.out);
    System.setIn(System.in);
  }
}