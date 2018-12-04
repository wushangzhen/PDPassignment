package edu.neu.ccs.cs5010.assignment7.step1;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The type Inner writer.
 */
public class InnerWriter implements Runnable {

  private ConcurrentLinkedQueue<String> queue;
  private FileOutputStream out;
  private String outputFileName;

  /**
   * Instantiates a new Inner writer.
   *
   * @param queue the queue
   * @param outputFileName the output file name
   * @param out the out
   */
  public InnerWriter(ConcurrentLinkedQueue<String> queue, String outputFileName,
      FileOutputStream out) {
    this.queue = queue;
    this.outputFileName = outputFileName.replaceAll("raw", "result");
    this.out = out;
  }

  @Override
  public void run() {
    synchronized (queue) {
      while (!queue.peek().equals("-1")) {
        String str = queue.poll();
        if (str == null) {
          return;
        }
        try {
          out.write(str.getBytes(Charset.forName("UTF-8")));
        } catch (Exception e) {
          //e.printStackTrace();
        }
      }
    }
  }
}
