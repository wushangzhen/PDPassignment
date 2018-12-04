package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test for price class.
 */
public class PriceTest {
  private final int DOLLARS_FOR_FITTED_SHAFT = 2;
  private final int CENTS_FOR_FITTED_SHAFT = 93;
  private Price priceFittedShaft = new Price(DOLLARS_FOR_FITTED_SHAFT, CENTS_FOR_FITTED_SHAFT);
  @Test
  public void getDollars() {
    assertEquals(priceFittedShaft.getDollars(), DOLLARS_FOR_FITTED_SHAFT);
  }

  @Test
  public void setDollars() {
    final int CHANGED_DOLLAR = 3;
    priceFittedShaft.setDollars(CHANGED_DOLLAR);
    assertEquals(priceFittedShaft.getDollars(), CHANGED_DOLLAR);
  }

  @Test
  public void getCents() {
    assertEquals(priceFittedShaft.getCents(), CENTS_FOR_FITTED_SHAFT);
  }

  @Test
  public void setCents() {
    final int CHANGED_CENT = 3;
    priceFittedShaft.setCents(CHANGED_CENT);
    assertEquals(priceFittedShaft.getCents(), CHANGED_CENT);
  }

  /**
   * A test for cents > 9 || cents < 10
   */
  @Test
  public void getAmount() {
    final String RESULT_WITH_SINGLE_CENT = "$ 2.93";
    assertEquals(priceFittedShaft.getAmount(), RESULT_WITH_SINGLE_CENT);
    final int CHANGED_CENT = 3;
    final String RESULT_WITH_MULTIPLE_CENT = "$ 2.03";
    priceFittedShaft.setCents(CHANGED_CENT);
    assertEquals(priceFittedShaft.getAmount(), RESULT_WITH_MULTIPLE_CENT);

  }
}