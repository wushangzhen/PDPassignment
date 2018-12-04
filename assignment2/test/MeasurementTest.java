package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasurementTest {
  @Test
  public void measurementClassTest() {
    for (Measurement type : Measurement.values()) {
      switch (type) {
        case STANDARD:
          continue;
        case INCH:
          continue;
        case METRIC:
          continue;
      }
    }
    for (String s : new String[] {"STANDARD", "INCH", "METRIC"}) {
      Measurement.valueOf(s);
    }
  }

}