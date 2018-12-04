package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import org.junit.Test;

public class InitializationTest {
  String emailTemplate = "email-template.txt";
  String letterTemplate = "letter-template.txt";
  String csvTemplate = "insurance-company-members.csv";
  Initialization initialization = new Initialization(csvTemplate, emailTemplate, letterTemplate);
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

  @Test
  public void setDataToDataBase() {
    DataBase dataBase = initialization.setDataToDataBase();
    assertFalse(initialization.setDataToDataBase().equals(dataBase));
  }

  @Test
  public void createNewCustomer() {
    String[] data = {FIRST_NAME, LAST_NAME, COMPANY_NAME, ADDRESS, CITY,
        COUNTY, STATE, ZIP, PHONE1, PHONE2, EMAIL, WEB};
    CustomerInfo customerInfo = new CustomerInfo(FIRST_NAME, LAST_NAME, COMPANY_NAME, ADDRESS,
        CITY, COUNTY, STATE, ZIP, PHONE1, PHONE2, EMAIL, WEB);
    assertFalse(initialization.createNewCustomer(data).equals(customerInfo));
  }
}