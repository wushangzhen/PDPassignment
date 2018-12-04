package edu.neu.ccs.cs5010.assignment6.concurrent;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessorTest {

  @Test
  public void process() {
    String[] args = new String[3];
    args[0] = "WearableWorkloadDefault-Javatest-POSTraw.csv";
    args[1] = "WearableWorkloadDefault-Javatest-GETraw.csv";
    args[2] = "50";
    new Processor().process(args);
  }

  @Test
  public void findPeakPhase() {
  }
}