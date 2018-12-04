package edu.neu.ccs.cs5010.assignment1.problem1;

/**
 * An exception class which is thrown when deposit amount is out of range.
 */
public class OutOfDepositRangeException extends Exception {

  private int dollars;
  private int cents;

  OutOfDepositRangeException(int dollars, int cents) {
    this.dollars = dollars;
    this.cents = cents;
  }

  /**
   * A method to get total amount of deposit.
   *
   * @return return deposit amount represented by cents
   */
  public String getAmount() {
    String amountStr = String.valueOf(dollars * 100 + cents);
    return amountStr;
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
}
