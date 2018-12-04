package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.Objects;

/**
 * A class includes name information.
 */
public class Name {

  private String firstName;
  private String lastName;
  
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Auto generated equals and hashcode method.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Name name = (Name) object;
    return Objects.equals(firstName, name.firstName)
        && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return 0;
  }

  /**
   * Override method of to string method.
   * @return String standard output
   */
  @Override
  public String toString() {
    return firstName + ",  " + lastName;
  }

  /**
   * Get first name method.
   *
   * @return String of first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set first name method.
   * @param firstName the name you want to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get the last name.
   *
   * @return String of last name
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
