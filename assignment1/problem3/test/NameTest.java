package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {
  Name name = new Name("Shangzhen", "Wu");

  @Test
  public void getFirstName() {
    assertEquals(name.getFirstName(), "Shangzhen");
  }

  @Test
  public void setFirstName() {
    name.setFirstName("Ziling");
    assertEquals(name.getFirstName(), "Ziling");
  }

  @Test
  public void getLastName() {
    assertEquals(name.getLastName(), "Wu");
  }

  @Test
  public void setLastName() {
    name.setLastName("Yang");
    assertEquals(name.getLastName(), "Yang");
  }
}