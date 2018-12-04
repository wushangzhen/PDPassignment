package edu.neu.ccs.cs5010.assignment6.sequential;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import org.junit.Test;

public class BucketTest {
  Bucket bucket = new Bucket("1", 1, 1);

  @Test
  public void getSize() {
    assertEquals(bucket.getSize(), 1);
  }

  @Test
  public void getLatency() {
    assertEquals(bucket.getLatency(), 1);
  }

}