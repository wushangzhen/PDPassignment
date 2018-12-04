package edu.neu.ccs.cs5010.assignment7.step1;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentSkipListMap;
import org.junit.Test;

public class GenerateChartTest {

  @Test
  public void compute() {
    ConcurrentSkipListMap<Integer, Long> test = new ConcurrentSkipListMap<>();
    new GenerateChart().compute(test, "test");
  }
}