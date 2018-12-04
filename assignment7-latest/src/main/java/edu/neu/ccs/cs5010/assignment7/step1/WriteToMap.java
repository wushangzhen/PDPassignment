package edu.neu.ccs.cs5010.assignment7.step1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * The type Write to map.
 */
public class WriteToMap implements Runnable {

  private ConcurrentSkipListMap<String, Bucket> bucketMapSecond;
  private ConcurrentSkipListMap<Integer, Long> latencyMap;
  /**
   * The Count.
   */
  int count = 0;

  /**
   * Instantiates a new Write to map.
   *
   * @param blockingQueue the blocking queue
   * @param bucketMap the bucket map
   * @param latencyMap the latency map
   */
  public WriteToMap(BlockingQueue<Requests> blockingQueue,
      ConcurrentSkipListMap<String, Bucket> bucketMap,
      ConcurrentSkipListMap<Integer, Long> latencyMap) {
    this.blockingQueue = blockingQueue;
    this.bucketMapSecond = bucketMap;
    this.latencyMap = latencyMap;
  }

  @Override
  public synchronized void run() {
    while (true) {
      if (blockingQueue.size() == 0) {
        continue;
      }
      Requests requests = blockingQueue.poll();
      if (requests == null) {
        continue;
      }
      if (requests.getTimeStamp().equals("-1")) {
        System.out.println("xxxxx");
        return;
      }
      try {
        parseRequestToBucket(requests, bucketMapSecond);
        parseLatencyToBucket(requests);
      } catch (Exception e) {
        //e.printStackTrace();
      }
    }
  }

  private void parseLatencyToBucket(Requests requests) {
    synchronized (latencyMap) {
      String latency = requests.getLatency();
      int key = Integer.parseInt(latency);
      this.latencyMap.putIfAbsent(key, 0L);
      this.latencyMap.put(key, this.latencyMap.get(key) + 1);
    }
  }

  /**
   * Parse array to bucket.
   *
   * @param requests the requests
   * @param oneSecondBucket the one second bucket
   */
  public void parseRequestToBucket(Requests requests,
      ConcurrentSkipListMap<String, Bucket> oneSecondBucket) {
    synchronized (bucketMapSecond) {
      String timeStamp = requests.getTimeStamp();
      timeStamp = timeStamp.substring(0, timeStamp.length() - 3);
      if (oneSecondBucket.containsKey(timeStamp)) {
        long curSize = oneSecondBucket.get(timeStamp).getSize();
        long newLatency = oneSecondBucket.get(timeStamp).getLatency()
            + Long.parseLong(requests.getLatency());
        oneSecondBucket.put(timeStamp,
            new Bucket(timeStamp, curSize + 1, newLatency));
      } else {
        oneSecondBucket.put(timeStamp,
            new Bucket(timeStamp, 1, Long.parseLong(requests.getLatency())));
      }
    }
  }

  private BlockingQueue<Requests> blockingQueue;
}
