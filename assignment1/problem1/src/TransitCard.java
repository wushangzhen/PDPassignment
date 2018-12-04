package edu.neu.ccs.cs5010.assignment1.problem1;

/**
 * This class represents transitCard. It includes CardOwner and CurrentBalance class and all
 * features needed.
 */
public class TransitCard {

  private CardOwner cardOwner;
  private CurrentBalance currentBalance;

  /**
   * Construct TransitCard object using cardOwner and currentBalance.
   *
   * @param cardOwner An Object of class CardOwner
   * @param currentBalance A Object of class CurrentBalance
   */
  TransitCard(CardOwner cardOwner, CurrentBalance currentBalance) {
    this.cardOwner = cardOwner;
    this.currentBalance = currentBalance;
  }

  /**
   * Execute the depositMoney method to update the current balance.
   *
   * @param newDeposit A Object of class Deposit
   * @return a boolean parameter that indicates whether the depositMoney Method is successful
   * @throws NameNotMatchedException when name is not matched, throw the exception
   */
  public boolean depositMoney(Deposit newDeposit) throws NameNotMatchedException {
    if (checkNames(newDeposit.getFirstName(), newDeposit.getLastName())) {
      int newDollars = newDeposit.getDollars();
      int newCents = newDeposit.getCents();
      currentBalance.updateCurrentBalance(newDollars, newCents);
      return true;
    } else {
      throw new NameNotMatchedException(newDeposit.getFirstName(),
          newDeposit.getLastName());
    }
  }

  /**
   * Check the first name and last name.
   *
   * @param firstName Owner's first name
   * @param lastName Owner's last name
   * @return whether the name matches
   */
  private boolean checkNames(String firstName, String lastName) {
    if (cardOwner.getFirstName().equals(firstName)
        && cardOwner.getLastName().equals(lastName)) {
      return true;
    } else {
      return false;
    }
  }

  public CardOwner getCardOwner() {
    return cardOwner;
  }

  public void setCardOwner(CardOwner cardOwner) {
    this.cardOwner = cardOwner;
  }

  public CurrentBalance getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(CurrentBalance currentBalance) {
    this.currentBalance = currentBalance;
  }
}

