package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataBaseTest {
  DataBase dataBase = new DataBase();

  @Test
  public void setEmailTemplate() {
    dataBase.setEmailTemplate(null);
    assertEquals(dataBase.getEmailTemplate(), null);
  }

  @Test
  public void setLetterTemplate() {
    dataBase.setEmailTemplate(null);
    assertEquals(dataBase.getLetterTemplate(), null);
  }

  @Test
  public void setCustomerInfoList() {
    dataBase.setCustomerInfoList(null);
    assertEquals(dataBase.getCustomerInfoList(), null);
  }

  @Test
  public void getCustomerInfoList() {
    assertEquals(dataBase.getCustomerInfoList(), null);
  }

  @Test
  public void getEmailTemplate() {
    assertEquals(dataBase.getEmailTemplate(), null);
  }

  @Test
  public void getLetterTemplate() {
    assertEquals(dataBase.getLetterTemplate(), null);
  }
}