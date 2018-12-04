package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.Objects;
import java.util.Set;

/**
 * A class of insurance information.
 */
public class InsuranceInfo {

  private Name owner;
  private Set<Name> peopleCovered;
  private DateInfo expirationDateInfo;

  /**
   * The constructor of insurance info.
   * @param owner owner
   * @param peopleCovered A set of people covered
   * @param expirationDateInfo A date indicates expiration date info
   */
  public InsuranceInfo(Name owner,
      Set<Name> peopleCovered,
      DateInfo expirationDateInfo) {
    this.owner = owner;
    this.peopleCovered = peopleCovered;
    this.expirationDateInfo = expirationDateInfo;
  }

  /**
   * Getters and setters for field.
   */
  public Name getOwner() {
    return owner;
  }

  public void setOwner(Name owner) {
    this.owner = owner;
  }

  public Set<Name> getPeopleCovered() {
    return peopleCovered;
  }

  public void setPeopleCovered(
      Set<Name> peopleCovered) {
    this.peopleCovered = peopleCovered;
  }

  public DateInfo getExpirationDateInfo() {
    return expirationDateInfo;
  }

  public void setExpirationDateInfo(
      DateInfo expirationDateInfo) {
    this.expirationDateInfo = expirationDateInfo;
  }

  /**
   * Auto generate equals and hashcode method.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    InsuranceInfo that = (InsuranceInfo) object;
    return Objects.equals(owner, that.owner)
        && Objects.equals(peopleCovered, that.peopleCovered)
        && Objects.equals(expirationDateInfo, that.expirationDateInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, peopleCovered, expirationDateInfo);
  }
}
