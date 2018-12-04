package edu.neu.ccs.cs5010.assignment6.sequential;

/**
 * The type Bucket.
 */
public class Bucket {

  private String timeStampSecond;
  private long size;
  private long latency;

  /**
   * Instantiates a new Bucket.
   *
   * @param timeStamp the time stamp
   * @param size the size
   * @param latency the latency
   */
  public Bucket(String timeStamp, long size, long latency) {
    this.timeStampSecond = timeStamp;
    this.size = size;
    this.latency = latency;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public long getSize() {
    return size;
  }

  /**
   * Gets latency.
   *
   * @return the latency
   */
  public long getLatency() {
    return latency;
  }
}
