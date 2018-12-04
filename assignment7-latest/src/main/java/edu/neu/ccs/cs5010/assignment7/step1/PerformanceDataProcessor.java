package edu.neu.ccs.cs5010.assignment7.step1;

import java.io.FileNotFoundException;

/**
 * The type Performance data processor.
 */
public class PerformanceDataProcessor {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws FileNotFoundException the file not found exception
   */
  public static void main(String[] args) throws FileNotFoundException {
    //WearableWorkloadDefault-1024-1000i-CPUrelaxed-long-Python-POSTraw.csv
    // WearableWorkloadDefault-1024-1000i-CPUrelaxed-long-Python-GETraw.csv 1000
    // WearableWorkloadDefault-Javatest-POSTraw.csv WearableWorkloadDefault-Javatest-GETraw.csv 100

    // WearableWorkloadDefault-1024-1000i-CPUrelaxed-long-Python-POSTraw.csv WearableWorkloadDefault-1024-1000i-CPUrelaxed-long-Python-GETraw.csv 5000 8
    long startTime = System.currentTimeMillis();
    //System.out.println(startTime);
    new Processor().process(args);
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime + "ms");
  }
}
