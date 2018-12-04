package edu.neu.ccs.cs5010.assignment7.step1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

public class ProcessorTest {

  @Test
  public void process() throws FileNotFoundException {
    String[] cmd = {"WearableWorkloadDefault-Javatest-POSTraw.csv", "WearableWorkloadDefault-Javatest-GETraw.csv",
        "100", "8"};
    new Processor().process(cmd);
  }
}