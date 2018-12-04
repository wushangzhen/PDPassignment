package edu.neu.ccs.cs5010.assignment6.concurrent;

import edu.neu.ccs.cs5010.assignment6.sequential.Bucket;
import edu.neu.ccs.cs5010.assignment6.sequential.Requests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The type Processor.
 */
public class Processor {

  /**
   * The File path post.
   */
  String filePathPost;
  /**
   * The File path get.
   */
  String filePathGet;
  /**
   * The Min time.
   */
  long minTime = Long.MAX_VALUE;
  /**
   * The Max time.
   */
  long maxTime = Long.MIN_VALUE;
  /**
   * The Total latency.
   */
  long totalLatency = 0;
  /**
   * The Total request.
   */
  long totalRequest = 0;
  /**
   * The Threshold.
   */
  String threshold;
  /**
   * The Highest request.
   */
  long highestRequest = 0;
  /**
   * The Bucket map post.
   */
  ConcurrentSkipListMap<String, Bucket> bucketMapPost;
  /**
   * The Bucket map get.
   */
  ConcurrentSkipListMap<String, Bucket> bucketMapGet;

  /**
   * Process.
   *
   * @param args the args
   */
  public void process(String[] args) {
    this.filePathPost = args[0];
    this.filePathGet = args[1];
    this.threshold = args[2];
    try {
      String[] pathArray = new String[2];
      pathArray[0] = args[0];
      pathArray[1] = args[1];
      Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            bucketMapPost = executor(pathArray[0]);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
      t1.start();
      t1.join();
      Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            minTime = Long.MAX_VALUE;
            maxTime = Long.MIN_VALUE;
            totalLatency = 0;
            totalRequest = 0;
            highestRequest = 0;
            bucketMapGet = executor(pathArray[1]);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
      t2.start();
      t2.join();
      Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            minTime = Long.MAX_VALUE;
            maxTime = Long.MIN_VALUE;
            totalLatency = 0;
            totalRequest = 0;
            highestRequest = 0;
            executor();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
      t3.start();
      t3.join();
      Thread t4 = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            minTime = Long.MAX_VALUE;
            maxTime = Long.MIN_VALUE;
            totalLatency = 0;
            totalRequest = 0;
            highestRequest = 0;
            ConcurrentSkipListMap<String, Bucket> peakPhaseBucket = findPeakPhase();
            ConcurrentLinkedQueue<String> queuePost = new ConcurrentLinkedQueue<>();
            StringBuilder sb = new StringBuilder();
            List<Long> latencyList = new ArrayList<>();
            List<Long> throughPut = new ArrayList<>();
            writeQueue(peakPhaseBucket, sb, queuePost, latencyList, throughPut);
            setPeakValues(queuePost, sb, latencyList, throughPut);
            final String fileName =
                System.getProperty("user.dir") + "/" + filePathPost.replaceAll("raw", "peak");
            File filePost = new File(fileName);
            filePost.delete();
            FileOutputStream outPost = new FileOutputStream(fileName, true);
            ThreadPoolExecutor pools = getThreadPool();
            writeFile(pools, queuePost, outPost);
            pools.shutdown();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
      t4.start();
      t4.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets peak values.
   *
   * @param queuePost the queue post
   * @param sb the sb
   * @param latencyList the latency list
   * @param throughPut the throughPut
   */
  public void setPeakValues(ConcurrentLinkedQueue<String> queuePost, StringBuilder sb,
      List<Long> latencyList, List<Long> throughPut) {
    sb.setLength(0);
    sb.append("Duration Peak Phase: " + (maxTime - minTime) + "\n");
    sb.append("Mean Response Time: " + totalLatency / totalRequest + "\n");
    int index = (int) Math.floor(latencyList.size() * 0.99);
    Collections.sort(latencyList);
    sb.append("The 99th Percentile Latency: " + latencyList.get(index) + "\n");
    index = (int) Math.floor(throughPut.size() * 0.05);
    Collections.sort(throughPut);
    sb.append("The 5th Percentile throughPut: " + throughPut.get(index) + "\n");
    sb.append("Mean throughPut: " + totalRequest / (maxTime - minTime) + "\n");
    sb.append("Highest Interval Request: " + highestRequest + "\n");
    queuePost.add(sb.toString());
    queuePost.add("-1");
  }

  /**
   * Find peak phase concurrent skip list map.
   *
   * @return the concurrent skip list map
   */
  public ConcurrentSkipListMap<String, Bucket> findPeakPhase() {
    ConcurrentSkipListMap<String, Bucket> peakPhaseBucket = new ConcurrentSkipListMap<>();
    String start = "";
    for (String key : bucketMapPost.keySet()) {
      if (bucketMapPost.get(key).getSize() >= Long.parseLong(threshold)) {
        start = key;
        break;
      }
    }
    String end = "";
    for (String key : bucketMapPost.descendingKeySet()) {
      if (bucketMapPost.get(key).getSize() >= Long.parseLong(threshold)) {
        end = key;
        break;
      }
    }
    for (String key : bucketMapPost.keySet()) {
      if (Long.parseLong(key) < Long.parseLong(start) || Long.parseLong(key) > Long
          .parseLong(end)) {
        continue;
      } else {
        peakPhaseBucket.put(key, bucketMapPost.get(key));
      }
    }
    return peakPhaseBucket;
  }

  /**
   * Executor.
   */
  public void executor() {
    try {
      String fileName =
          System.getProperty("user.dir") + "/" + filePathPost.replaceAll("raw", "GETcombined");
      File file = new File(fileName);
      StringBuilder sb = new StringBuilder();
      long maxSize = Long.MIN_VALUE;
      maxSize = writeCombineFile(sb, maxSize);
      sb.append("\n\n");
      sb.append("Overall throughPut: " + totalRequest / (maxTime - minTime) + "\n");
      sb.append("Peak throughPut: " + maxSize);
      BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
      bw.write(sb.toString());
      bw.newLine();
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private ConcurrentSkipListMap<String, Bucket> executor(String path) throws Exception {
    String filePath = System.getProperty("user.dir") + "/" + path;
    BlockingQueue<Requests> blockingQueue = new ArrayBlockingQueue<>(DEFAULT_QUEUE_SIZE);
    ThreadPoolExecutor pools = getThreadPool();
    pools.execute(new InnerReader(blockingQueue, filePath, DEFAULT_QUEUE_SIZE));
    ConcurrentSkipListMap<String, Bucket> bucketMap = new ConcurrentSkipListMap<>();
    for (int i = 0; i < 5; i++) {
      pools.execute(new WriteToMap(blockingQueue, bucketMap));
    }
    pools.shutdown();
    while (true) {
      if (pools.isTerminated()) {
        break;
      }
    }
    final String fileName =
        System.getProperty("user.dir") + "/" + path.replaceAll("raw", "result");
    StringBuilder sb = new StringBuilder();
    ConcurrentLinkedQueue<String> queuePost = new ConcurrentLinkedQueue<>();
    List<Long> latencyList = new ArrayList<>();
    List<Long> throughPut = new ArrayList<>();
    writeQueue(bucketMap, sb, queuePost, latencyList, throughPut);
    setValues(sb, queuePost, latencyList);
    File filePost = new File(fileName);
    boolean isDeleted = filePost.delete();
    FileOutputStream outPost = new FileOutputStream(fileName, true);
    pools = getThreadPool();
    writeFile(pools, queuePost, outPost);
    pools.shutdown();
    return bucketMap;
  }

  /**
   * Write combine file long.
   *
   * @param sb the sb
   * @param maxSize the max size
   * @return the long
   */
  public long writeCombineFile(StringBuilder sb, long maxSize) {
    for (String time : bucketMapPost.keySet()) {
      minTime = Math.min(minTime, Long.parseLong(time));
      maxTime = Math.max(maxTime, Long.parseLong(time));
      long curTotalSize = bucketMapPost.get(time).getSize();
      sb.append("\"" + time + "\",");
      sb.append("\"" + bucketMapPost.get(time).getSize() + "\",");
      sb.append(
          "\"" + bucketMapPost.get(time).getLatency() / bucketMapPost.get(time).getSize() + "\",");
      if (bucketMapGet.containsKey(time)) {
        curTotalSize += bucketMapGet.get(time).getSize();
        sb.append("\"" + time + "\",");
        sb.append("\"" + bucketMapGet.get(time).getSize() + "\",");
        sb.append(
            "\"" + bucketMapGet.get(time).getLatency() / bucketMapPost.get(time).getSize() + "\",");
      } else {
        sb.append("\"\",").append("\"\",").append("\"\",");
      }
      sb.append("\"" + curTotalSize + "\"");
      sb.append("\n");
      totalRequest += curTotalSize;
      maxSize = Math.max(maxSize, curTotalSize);
    }
    return maxSize;
  }



  private void setValues(StringBuilder sb, ConcurrentLinkedQueue<String> queuePost,
      List<Long> latencyList) {
    sb.setLength(0);
    sb.append("Test Length: " + (maxTime - minTime) + "\n");
    sb.append("Mean Latency: " + totalLatency / ((maxTime - minTime) * 1000) + "\n");
    int index = (int) Math.ceil(latencyList.size() * 0.99);
    Collections.sort(latencyList);
    sb.append("The 99th Percentile Latency: " + latencyList.get(index) + "\n");
    sb.append("Total throughPut: " + totalRequest / (maxTime - minTime) + "\n");
    queuePost.add(sb.toString());
    queuePost.add("-1");
  }

  private void writeFile(ThreadPoolExecutor pools, ConcurrentLinkedQueue<String> queuePost,
      FileOutputStream outPost) {
    while (true) {
      if (queuePost.isEmpty()) {
        break;
      } else {
        String string = queuePost.peek();
        if (string == null) {
          continue;
        }
        if (string.equals("-1")) {
          break;
        }
        pools.execute(new InnerWriter(queuePost, filePathPost, outPost));
      }
    }
  }

  /**
   * Write queue.
   *
   * @param bucketMap the bucket map
   * @param sb the sb
   * @param queuePost the queue post
   * @param latencyList the latency list
   * @param throughPut the throughPut
   */
  public void writeQueue(ConcurrentSkipListMap<String, Bucket> bucketMap, StringBuilder sb,
      ConcurrentLinkedQueue<String> queuePost, List<Long> latencyList, List<Long> throughPut) {
    for (String key : bucketMap.keySet()) {
      sb.setLength(0);
      long curSize = bucketMap.get(key).getSize();
      highestRequest = Math.max(curSize, highestRequest);
      long curLatency = bucketMap.get(key).getLatency();
      totalLatency += curLatency;
      totalRequest += curSize;
      throughPut.add(curSize);
      long meanLatency = curLatency / curSize;
      latencyList.add(meanLatency);
      minTime = Math.min(minTime, Long.parseLong(key));
      maxTime = Math.max(maxTime, Long.parseLong(key));
      sb.append("\"" + key + "\",");
      sb.append("\"" + curSize + "\",");
      sb.append("\"" + meanLatency + "\"");
      sb.append("\n");
      queuePost.add(sb.toString());
    }
  }

  /**
   * Gets thread pool.
   *
   * @return the thread pool
   */
  public static ThreadPoolExecutor getThreadPool() {
    return new ThreadPoolExecutor(10, 1000, 5, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());
  }

  private static final int DEFAULT_QUEUE_SIZE = 10000;
}
