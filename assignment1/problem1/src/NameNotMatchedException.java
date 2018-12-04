package edu.neu.ccs.cs5010.assignment1.problem1;

/**
 * An Exception class which is thrown when name is not matched.
 */
public class NameNotMatchedException extends Exception {

  private String firstName;
  private String lastName;

  NameNotMatchedException(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * A method to return first name and last name together.
   *
   * @return A String which contains first name and last name
   */
  public String getWrongName() {
    String wrongName = this.getFirstName() + " " + this.getLastName();
    return wrongName;
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
