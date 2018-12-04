package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTest {
  @Test
  public void categoryClassTest() {
    for (Category type : Category.values()) {
      switch (type) {
        case SPROCKET:
          continue;
        case ROTARY_SHAFTS:
          continue;
        case BALL_BEARING:
          continue;
      }
    }
    for (String s : new String[] {"SPROCKET", "BALL_BEARING", "ROTARY_SHAFTS"}) {
      Category.valueOf(s);
    }
  }
}
