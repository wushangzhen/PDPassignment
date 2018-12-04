package edu.neu.ccs.cs5010.assignment2;

/**
 * A class represents the stock item's prices.
 */
public class Price {

  private int dollars;
  private int cents;

  public Price(int dollars, int cents) {
    this.dollars = dollars;
    this.cents = cents;
  }

  public int getDollars() {
    return dollars;
  }

  public void setDollars(int dollars) {
    this.dollars = dollars;
  }

  public int getCents() {
    return cents;
  }

  public void setCents(int cents) {
    this.cents = cents;
  }

  /**
   * A method will output the right format of price.
   * @return A String represents price
   */
  public String getAmount() {
    String centsStr = null;
    if (cents < 10) {
      centsStr = "0" + String.valueOf(cents);
    } else {
      centsStr = String.valueOf(cents);
    }
    String result = "$ " + String.valueOf(dollars) + "." + centsStr;
    return result;

  }
}
