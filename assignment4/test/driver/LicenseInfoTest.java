package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import org.junit.Test;

public class LicenseInfoTest {

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  private final String NUMBER = "WWSZ";

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfoIssuance = new DateInfo(YEAR, MONTH, DAY);

  private final String YEAR_EXPIRATION = "2999";
  private final String MONTH_EXPIRATION = "03";
  private final String DAY_EXPIRATION = "02";
  DateInfo dateInfoExpiration = new DateInfo(YEAR_EXPIRATION, MONTH_EXPIRATION, DAY_EXPIRATION);

  private final String YEAR_BIRTHDAY = "2999";
  private final String MONTH_BIRTHDAY = "03";
  private final String DAY_BIRTHDAY = "02";
  DateInfo dateInfoBirthday = new DateInfo(YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY);
  private final String ADDRESS = "Boren";
  private final String STATE_OF_ISSUANCE = "ISSUED";
  LicenseInfo licenseInfo = new LicenseInfo(NUMBER, name, ADDRESS, dateInfoBirthday,
      Country.U_S, STATE_OF_ISSUANCE, dateInfoIssuance, dateInfoExpiration);
  LicenseInfo licenseInfoTest = new LicenseInfo(NUMBER, name, ADDRESS, dateInfoBirthday,
      Country.U_S, STATE_OF_ISSUANCE, dateInfoIssuance, dateInfoExpiration);

  @Test
  public void getNumber() {
    assertEquals(licenseInfo.getNumber(), NUMBER);
  }

  @Test
  public void setNumber() {
    licenseInfo.setNumber("xxxx");
    assertEquals(licenseInfo.getNumber(), "xxxx");
  }

  @Test
  public void getName() {
    assertEquals(licenseInfo.getName(), name);
  }

  @Test
  public void setName() {
    name.setLastName("xxx");
    licenseInfo.setName(name);
    assertEquals(licenseInfo.getName(), name);
  }

  @Test
  public void getAddress() {
    assertEquals(licenseInfo.getAddress(), ADDRESS);
  }

  @Test
  public void setAddress() {
    licenseInfo.setAddress("xxx");
    assertEquals(licenseInfo.getAddress(), "xxx");
  }

  @Test
  public void getBirthDay() {
    assertEquals(licenseInfo.getBirthDay(), dateInfoBirthday);
  }

  @Test
  public void setBirthDay() {
    licenseInfo.setBirthDay(dateInfoExpiration);
    assertEquals(licenseInfo.getBirthDay(), dateInfoExpiration);
  }

  @Test
  public void getCountry() {
    assertEquals(licenseInfo.getCountry(), Country.U_S);
  }

  @Test
  public void setCountry() {
    licenseInfo.setCountry(Country.CANADA);
    assertEquals(licenseInfo.getCountry(), Country.CANADA);
  }

  @Test
  public void getStateOfIssuance() {
    assertEquals(licenseInfo.getStateOfIssuance(), STATE_OF_ISSUANCE);
  }

  @Test
  public void setStateOfIssuance() {
    licenseInfo.setStateOfIssuance("xxx");
    assertEquals(licenseInfo.getStateOfIssuance(), "xxx");
  }

  @Test
  public void getIssuanceDateInfo() {
    assertEquals(licenseInfo.getIssuanceDateInfo(), dateInfoIssuance);
  }

  @Test
  public void setIssuanceDateInfo() {
    licenseInfo.setIssuanceDateInfo(dateInfoBirthday);
    assertEquals(licenseInfo.getIssuanceDateInfo(), dateInfoBirthday);
  }

  @Test
  public void getExpirationDateInfo() {
    assertEquals(licenseInfo.getExpirationDateInfo(), dateInfoExpiration);
  }

  @Test
  public void setExpirationDateInfo() {
    licenseInfo.setExpirationDateInfo(dateInfoBirthday);
    assertEquals(licenseInfo.getExpirationDateInfo(), dateInfoBirthday);
  }

  @Test
  public void equals() {
    boolean result = licenseInfo.equals(licenseInfoTest);
    assertTrue(result);
    assertTrue(licenseInfo.equals(licenseInfoTest));
    assertFalse(licenseInfo.equals(null));
    assertFalse(licenseInfo.equals(dateInfoBirthday));
    licenseInfo.setCountry(Country.CANADA);
    assertFalse(licenseInfo.equals(licenseInfoTest));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(licenseInfo.hashCode() == licenseInfoTest.hashCode());
  }


}