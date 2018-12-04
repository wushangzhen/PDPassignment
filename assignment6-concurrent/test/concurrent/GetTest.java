package edu.neu.ccs.cs5010.assignment6.sequential;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetTest {
  Requests get = new Get("111", "1",  "1");

  @Test
  public void getTimeStamp() {
    assertEquals(get.getTimeStamp(), "111");
  }

  @Test
  public void getLatency() {
    assertEquals(get.getLatency(), "1");
  }
}