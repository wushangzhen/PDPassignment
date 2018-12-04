package edu.neu.ccs.cs5010.assignment1.problem4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakeAndModelTest {
  MakeAndModel makeAndModel = new MakeAndModel("BMW", "2015");
  @Test
  public void getMake() {
    assertEquals(makeAndModel.getMake(), "BMW");
  }

  @Test
  public void setMake() {
    makeAndModel.setMake("Audi");
    assertEquals(makeAndModel.getMake(), "Audi");
  }

  @Test
  public void getModel() {
    assertEquals(makeAndModel.getModel(), "2015");

  }

  @Test
  public void setModel() {
    makeAndModel.setModel("2016");
    assertEquals(makeAndModel.getModel(), "2016");
  }
}