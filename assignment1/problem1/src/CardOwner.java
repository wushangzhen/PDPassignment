package edu.neu.ccs.cs5010.assignment1.problem1;

/**
 * A class of storing the card owner's information.
 */
public class CardOwner {

  private String firstName;
  private String lastName;
  private String address;
  private String emailAddress;

  CardOwner(String firstName, String lastName,
      String address, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.emailAddress = emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}

