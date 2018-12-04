package edu.neu.ccs.cs5010.assignment4.driver;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovingVioTypeTest {

  @Test
  public void test() {
    assertEquals(MovingVioType.SPEEDING.toString(),
        "Speeding");
    assertEquals(MovingVioType.RECKLESS_DRIVING.toString(),
        "Reckless driving");
    assertEquals(MovingVioType.DISTRACTED_DRIVING.toString(),
        "Distracted driving");
    assertEquals(MovingVioType.DRIVING_UNDER_INFLUENCE.toString(),
        "Driving under influence");
    assertEquals(MovingVioType.DRIVING_WITHOUT_VALID_LICENCE.toString(),
        "Driving without a valid license");
    assertEquals(MovingVioType.DRIVING_WITHOUT_VALID_INSURANCE.toString(),
        "Driving without a valid insurance");
    assertEquals(MovingVioType.FAILURE_TO_RESPECT_TRAFFIC_SIGNS.toString(),
        "Failure to respect traffic signs");
  }
}