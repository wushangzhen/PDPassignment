package edu.neu.ccs.cs5010.assignment1.problem1;

/**
 * A class represents Deposit information.
 */
public class Deposit {

  private String firstName;
  private String lastName;
  private int dollars; // pay attention to bound
  private int cents;

  Deposit(String firstName, String lastName, int dollars, int cents)
      throws OutOfDepositRangeException {
    if (checkDepositRange(dollars, cents)) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.dollars = dollars;
      this.cents = cents;
    } else {
      throw new OutOfDepositRangeException(dollars, cents);
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getDollars() {
    return dollars;
  }

  public int getCents() {
    return cents;
  }

  /**
   * A method to check the range of Deposit.
   *
   * @param dollars deposited dollars
   * @param cents deposited cents
   * @return whether it is out of bound
   */
  public boolean checkDepositRange(int dollars, int cents) {
    int upperBound = getAmountCents(50, 0);
    int lowerBound = getAmountCents(5, 0);
    int newDepositAmount = getAmountCents(dollars, cents);
    if (newDepositAmount <= upperBound && newDepositAmount >= lowerBound) {
      return true;
    } else {
      return false;
    }
  }

  public int getAmountCents(int dollars, int cents) {
    return dollars * 100 + cents;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setDollars(int dollars) {
    this.dollars = dollars;
  }

  public void setCents(int cents) {
    this.cents = cents;
  }
}
