package edu.neu.ccs.cs5010.assignment7.step1;

/**
 * The type Requests.
 */
public abstract class Requests {

  private String timeStamp;
  private String latency;
  private String responseCode;

  /**
   * Instantiates a new Requests.
   *
   * @param timeStamp the time stamp
   * @param latency the latency
   * @param responseCode the response code
   */
  public Requests(String timeStamp, String latency, String responseCode) {
    this.timeStamp = timeStamp;
    this.latency = latency;
    this.responseCode = responseCode;
  }

  /**
   * Gets time stamp.
   *
   * @return the time stamp
   */
  public String getTimeStamp() {
    return timeStamp;
  }

  /**
   * Gets latency.
   *
   * @return the latency
   */
  public String getLatency() {
    return latency;
  }
}

