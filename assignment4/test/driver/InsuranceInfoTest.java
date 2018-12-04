package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class InsuranceInfoTest {

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);


  private final String FIRST_NAME_SECOND = "Shang";
  private final String LAST_NAME_SECOND = "Wu";
  private Name nameSecond = new Name(FIRST_NAME_SECOND, LAST_NAME_SECOND);

  private final String YEAR = "1999";
  private final String MONTH = "03";
  private final String DAY = "02";
  DateInfo dateInfo = new DateInfo(YEAR, MONTH, DAY);
  Set<Name> set = new HashSet<>();
  InsuranceInfo insuranceInfo = new InsuranceInfo(name, set, dateInfo);
  InsuranceInfo insuranceInfoTest = new InsuranceInfo(name, set, dateInfo);
  InsuranceInfo insuranceInfoTestWrong = new InsuranceInfo(name, new HashSet<>(), dateInfo);

  @Test
  public void getOwner() {
    assertEquals(insuranceInfo.getOwner(), name);
  }

  @Test
  public void setOwner() {
    insuranceInfo.setOwner(nameSecond);
    assertEquals(insuranceInfo.getOwner(), nameSecond);
  }

  @Test
  public void getPeopleCovered() {
    assertEquals(insuranceInfo.getPeopleCovered(), set);
  }

  @Test
  public void setPeopleCovered() {
    set.remove(name);
    insuranceInfo.setPeopleCovered(set);
    assertEquals(insuranceInfo.getPeopleCovered(), set);

  }

  @Test
  public void getExpirationDateInfo() {
    assertEquals(insuranceInfo.getExpirationDateInfo(), dateInfo);
  }

  @Test
  public void setExpirationDateInfo() {
    final String YEAR = "1996";
    final String MONTH = "03";
    final String DAY = "02";
    DateInfo dateInfoTest = new DateInfo(YEAR, MONTH, DAY);
    insuranceInfo.setExpirationDateInfo(dateInfoTest);
    assertEquals(insuranceInfo.getExpirationDateInfo(), dateInfoTest);
  }

  @Test
  public void equals() {
    assertTrue(insuranceInfo.equals(insuranceInfoTest));
    assertFalse(insuranceInfo.equals(null));
    assertFalse(insuranceInfo.equals(dateInfo));
    assertFalse(insuranceInfo.equals(insuranceInfoTestWrong));

  }

  @Test
  public void hashCodeTest() {
    assertTrue(insuranceInfo.hashCode() == insuranceInfoTest.hashCode());
  }

  @Before
  public void setUp() throws Exception {
    set.add(name);
    set.add(nameSecond);
  }
}