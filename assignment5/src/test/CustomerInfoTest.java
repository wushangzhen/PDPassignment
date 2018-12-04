package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.lab2.assignment1.Address;
import org.junit.Assert;
import org.junit.Test;

public class CustomerInfoTest {
  private final String FIRST_NAME = "James";
  private final String LAST_NAME = "Butt";
  private final String COMPANY_NAME = "Benton, John B Jr";
  private final String ADDRESS = "6649 N Blue Gum St";
  private final String CITY = "New Orleans";
  private final String COUNTY = "Orleans";
  private final String STATE = "LA";
  private final String ZIP = "70116";
  private final String PHONE1 = "504-621-8927";
  private final String PHONE2 = "504-845-1427";
  private final String EMAIL = "jbutt@gmail.com";
  private final String WEB = "http://www.bentonjohnbjr.com";
  private final String CHANGED_ITEM = "0000";

  CustomerInfo customerInfo = new CustomerInfo(FIRST_NAME, LAST_NAME, COMPANY_NAME, ADDRESS,
      CITY, COUNTY, STATE, ZIP, PHONE1, PHONE2, EMAIL, WEB);

  @Test
  public void getFirstName() {
    assertEquals(customerInfo.getFirstName(), FIRST_NAME);
  }

  @Test
  public void setFirstName() {
    customerInfo.setFirstName(CHANGED_ITEM);
    assertEquals(customerInfo.getFirstName(), CHANGED_ITEM);
  }

  @Test
  public void getLastName() {
    assertEquals(customerInfo.getLastName(), LAST_NAME);
  }

  @Test
  public void setLastName() {
    customerInfo.setLastName(CHANGED_ITEM);
    assertEquals(customerInfo.getLastName(), CHANGED_ITEM);
  }

  @Test
  public void getCompanyName() {
    assertEquals(customerInfo.getCompanyName(), COMPANY_NAME);
  }

  @Test
  public void setCompanyName() {
    customerInfo.setCompanyName(CHANGED_ITEM);
    assertEquals(customerInfo.getCompanyName(), CHANGED_ITEM);
  }

  @Test
  public void getAddress() {
    assertEquals(customerInfo.getAddress(), ADDRESS);
  }

  @Test
  public void setAddress() {
    customerInfo.setAddress(CHANGED_ITEM);
    assertEquals(customerInfo.getAddress(), CHANGED_ITEM);

  }

  @Test
  public void getCity() {
    assertEquals(customerInfo.getCity(), CITY);
  }

  @Test
  public void setCity() {
    customerInfo.setCity(CHANGED_ITEM);
    assertEquals(customerInfo.getCity(), CHANGED_ITEM);
  }

  @Test
  public void getCounty() {
    assertEquals(customerInfo.getCounty(), COUNTY);
  }

  @Test
  public void setCounty() {
    customerInfo.setCounty(CHANGED_ITEM);
    assertEquals(customerInfo.getCounty(), CHANGED_ITEM);
  }

  @Test
  public void getState() {
    assertEquals(customerInfo.getState(), STATE);
  }

  @Test
  public void setState() {
    customerInfo.setState(CHANGED_ITEM);
    assertEquals(customerInfo.getState(), CHANGED_ITEM);
  }

  @Test
  public void getZip() {
    assertEquals(customerInfo.getZip(), ZIP);
  }

  @Test
  public void setZip() {
    customerInfo.setZip(CHANGED_ITEM);
    assertEquals(customerInfo.getZip(), CHANGED_ITEM);
  }

  @Test
  public void getPhone1() {
    assertEquals(customerInfo.getPhone1(), PHONE1);
  }

  @Test
  public void setPhone1() {
    customerInfo.setPhone1(CHANGED_ITEM);
    assertEquals(customerInfo.getPhone1(), CHANGED_ITEM);
  }

  @Test
  public void getEmail() {
    assertEquals(customerInfo.getEmail(), EMAIL);
  }

  @Test
  public void setEmail() {
    customerInfo.setEmail(CHANGED_ITEM);
    assertEquals(customerInfo.getEmail(), CHANGED_ITEM);
  }

  @Test
  public void getWeb() {
    assertEquals(customerInfo.getWeb(), WEB);
  }

  @Test
  public void setWeb() {
    customerInfo.setWeb(CHANGED_ITEM);
    assertEquals(customerInfo.getWeb(), CHANGED_ITEM);
  }

  @Test
  public void getPhone2() {
    assertEquals(customerInfo.getPhone2(), PHONE2);
  }

  @Test
  public void setPhone2() {
    customerInfo.setPhone2(CHANGED_ITEM);
    assertEquals(customerInfo.getPhone2(), CHANGED_ITEM);
  }
}