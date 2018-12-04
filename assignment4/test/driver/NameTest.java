package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

public class NameTest extends Object {

  private final String FIRST_NAME = "Shangzhen";
  private final String LAST_NAME = "Wu";
  private Name name = new Name(FIRST_NAME, LAST_NAME);
  private Name nameTest = new Name(FIRST_NAME, LAST_NAME);
  private Name nameTestWrong = new Name(FIRST_NAME, "WU");

  @Test
  public void equals() {
    assertFalse(name.equals(nameTestWrong));
    assertTrue(name.equals(nameTest));
    assertFalse(name.equals(null));
    assertFalse(name.equals(new Date()));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(name.hashCode() == nameTest.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals(name.toString(), "Shangzhen,  Wu");
  }

  @Test
  public void getFirstName() {
    assertEquals(name.getFirstName(), FIRST_NAME);
  }

  @Test
  public void setFirstName() {
    final String CHANGED_NAME = "sss";
    name.setFirstName(CHANGED_NAME);
    assertEquals(name.getFirstName(), CHANGED_NAME);
  }

  @Test
  public void getLastName() {
    assertEquals(name.getLastName(), LAST_NAME);
  }

  @Test
  public void setLastName() {
    final String CHANGED_NAME = "sss";
    name.setLastName(CHANGED_NAME);
    assertEquals(name.getLastName(), CHANGED_NAME);
  }
}