package edu.neu.ccs.cs5010.assignment6.concurrent;

import edu.neu.ccs.cs5010.assignment6.sequential.Get;
import edu.neu.ccs.cs5010.assignment6.sequential.Post;
import edu.neu.ccs.cs5010.assignment6.sequential.Requests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

/**
 * The type Inner reader.
 */
public class InnerReader implements Runnable {

  /**
   * Instantiates a new Inner reader.
   *
   * @param blockingQueue the blocking queue
   * @param inputFileName the input file name
   * @param maxQueueSize the max queue size
   */
  public InnerReader(BlockingQueue<Requests> blockingQueue, String inputFileName,
      int maxQueueSize) {
    this.blockingQueue = blockingQueue;
    this.inputFileName = inputFileName;
    this.maxQueueSize = maxQueueSize;
  }

  @Override
  public synchronized void run() {
    File inputFile = new File(inputFileName);
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile),
          5 * 1024 * 1024);
      String line;
      String csvSplitBy = ",";
      while ((line = bufferedReader.readLine()) != null) {
        line = line.replaceAll("\"", "");
        String items[] = line.split(csvSplitBy);
        Requests request = null;
        if (items[1].equals("POST")) {
          request = new Post(items[0], items[2], items[3]);
          try {
            addData(request);
          } catch (Exception e) {
            //e.printStackTrace();
          }
        } else {
          request = new Get(items[0], items[2], items[3]);
          try {
            addData(request);
          } catch (Exception e) {
            //e.printStackTrace();
          }
        }
      }
      addData(new Get("-1", "-1", "-1"));
      bufferedReader.close();
    } catch (Exception e) {
      //e.printStackTrace();
    }
  }


  /**
   * Add data.
   *
   * @param requests the requests
   * @throws Exception the exception
   */
  public void addData(Requests requests) throws Exception {
    while (blockingQueue.size() >= maxQueueSize) {
      //TimeUnit.SECONDS.sleep(1);
    }
    if (requests != null) {
      blockingQueue.add(requests);
    }
  }

  private BlockingQueue<Requests> blockingQueue;

  private String inputFileName;

  private int maxQueueSize;

}
