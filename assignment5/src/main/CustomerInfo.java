package edu.neu.ccs.cs5010.assignment5;

/**
 * A class will store the customers' information.
 */
public class CustomerInfo {

  private String firstName;
  private String lastName;
  private String companyName;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;
  private String phone1;
  private String phone2;
  private String email;
  private String web;

  /**
   * A constructor for customer information.
   * @param firstName String of first name
   * @param lastName String of last name
   * @param companyName String of company name
   * @param address String of address
   * @param city String of city
   * @param county String of county
   * @param state String of state
   * @param zip String of zip
   * @param phone1 String of phone1
   * @param phone2 String of phone2
   * @param email String of email
   * @param web String of web
   */
  public CustomerInfo(String firstName, String lastName, String companyName, String address,
      String city, String county, String state, String zip, String phone1, String phone2,
      String email, String web) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.companyName = companyName;
    this.address = address;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zip = zip;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.email = email;
    this.web = web;
  }


  /**
   *  Getters and setters.
   */

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

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }
}
