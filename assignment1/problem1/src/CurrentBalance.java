package edu.neu.ccs.cs5010.assignment1.problem1;

/**
 * A class to store the information of current balance.
 */
public class CurrentBalance {

  private int dollars;
  private int cents;

  CurrentBalance(int dollars, int cents) {
    this.dollars = dollars;
    this.cents = cents;
  }

  /**
   * A method to update the current balance number.
   *
   * @param dollars the dollar amount deposited.
   * @param cents the cent amount deposited.
   */
  public void updateCurrentBalance(int dollars, int cents) {
    cents += this.getCents();
    this.setDollars(this.getDollars() + dollars);
    int centsToDollars = 0;
    if (cents >= 100) {
      centsToDollars += (cents / 100);
      this.setCents(cents % 100);
    }
    this.setDollars(this.getDollars() + centsToDollars);
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
