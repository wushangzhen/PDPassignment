package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.Objects;

/**
 * A class includes all the information of license.
 */
public class LicenseInfo {

  private String number; // should be unique which means we have to judge
  private Name name;
  private String address;
  private DateInfo birthDay;
  private Country country;
  private String stateOfIssuance;
  private DateInfo issuanceDateInfo;
  private DateInfo expirationDateInfo;


  /**
   * A constructor of License Information.
   * @param number number
   * @param name name
   * @param address string
   * @param birthDay date
   * @param country country class
   * @param stateOfIssuance string of issuance
   * @param issuanceDateInfo string of issuance date info
   * @param expirationDateInfo string of expiration date information
   */
  public LicenseInfo(String number, Name name, String address,
      DateInfo birthDay, Country country, String stateOfIssuance,
      DateInfo issuanceDateInfo,
      DateInfo expirationDateInfo) {
    this.number = number;
    this.name = name;
    this.address = address;
    this.birthDay = birthDay;
    this.country = country;
    this.stateOfIssuance = stateOfIssuance;
    this.issuanceDateInfo = issuanceDateInfo;
    this.expirationDateInfo = expirationDateInfo;
  }

  /**
   * Getters and Setters for class fields.
   */
  public String getNumber() {
    return number;
  }

  /**
   * Set the number.
   * @param number String number
   */
  public void setNumber(String number) {
    this.number = number;
  }

  /**
   * Get the name field.
   * @return name
   */
  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  /**
   * Get the address.
   * @return address
   */
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public DateInfo getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(DateInfo birthDay) {
    this.birthDay = birthDay;
  }

  /**
   * Get the country.
   * @return country
   */
  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public String getStateOfIssuance() {
    return stateOfIssuance;
  }

  public void setStateOfIssuance(String stateOfIssuance) {
    this.stateOfIssuance = stateOfIssuance;
  }

  /**
   * Get the issuance date information.
   */
  public DateInfo getIssuanceDateInfo() {
    return issuanceDateInfo;
  }

  /**
   * Set the issuance date information.
   *
   * @param issuanceDateInfo issuance date information
   */
  public void setIssuanceDateInfo(
      DateInfo issuanceDateInfo) {
    this.issuanceDateInfo = issuanceDateInfo;
  }

  /**
   * Get the expiration date information.
   */
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LicenseInfo that = (LicenseInfo) o;
    return Objects.equals(number, that.number)
        && Objects.equals(name, that.name) && Objects.equals(address, that.address)
        && Objects.equals(birthDay, that.birthDay) && country == that.country
        && Objects.equals(stateOfIssuance, that.stateOfIssuance)
        && Objects.equals(issuanceDateInfo, that.issuanceDateInfo)
        && Objects.equals(expirationDateInfo, that.expirationDateInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, address, birthDay, country, stateOfIssuance, issuanceDateInfo,
        expirationDateInfo);
  }
}
