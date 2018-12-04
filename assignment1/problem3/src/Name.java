package edu.neu.ccs.cs5010.assignment1.problem3;

/**
 * A class represents name.
 */
public class Name {

  private String firstName;
  private String lastName;

  Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
