package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SealTypeTest {

  @Test
  public void sealTypeClassTest() {
    for (SealType type : SealType.values()) {
      switch (type) {
        case SEALED:
          continue;
        case SHIELDED:
          continue;
      }
    }
    for (String s : new String[] {"SEALED", "SHIELDED"}) {
      SealType.valueOf(s);
    }
  }
}