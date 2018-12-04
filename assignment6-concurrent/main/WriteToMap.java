package edu.neu.ccs.cs5010.assignment6.concurrent;

import edu.neu.ccs.cs5010.assignment6.sequential.Bucket;
import edu.neu.ccs.cs5010.assignment6.sequential.Requests;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * The type Write to map.
 */
public class WriteToMap implements Runnable {

  private ConcurrentSkipListMap<String, List<Requests>> bucket;
  private ConcurrentSkipListMap<String, Bucket> bucketMap;

  /**
   * Instantiates a new Write to map.
   *
   * @param blockingQueue the blocking queue
   * @param bucketMap the bucket map
   */
  public WriteToMap(BlockingQueue<Requests> blockingQueue,
      ConcurrentSkipListMap<String, Bucket> bucketMap) {
    this.blockingQueue = blockingQueue;
    this.bucketMap = bucketMap;
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
        blockingQueue.add(requests);
        return;
      }
      try {
        synchronized (bucketMap) {
          parseArrayToBucket(requests, bucketMap);
        }
      } catch (Exception e) {
        //e.printStackTrace();
      }
    }
  }

  /**
   * Parse array to bucket.
   *
   * @param requests the requests
   * @param oneSecondBucket the one second bucket
   */
  public void parseArrayToBucket(Requests requests,
      ConcurrentSkipListMap<String, Bucket> oneSecondBucket) {
    synchronized (this) {
      synchronized (bucketMap) {
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
  }

  private BlockingQueue<Requests> blockingQueue;

  private String outputFileName;

}
