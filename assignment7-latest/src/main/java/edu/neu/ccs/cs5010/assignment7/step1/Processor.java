package edu.neu.ccs.cs5010.assignment7.step1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
  private ConcurrentSkipListMap<String, Bucket> bucketMapPost;
  /**
   * The Bucket map get.
   */
  private ConcurrentSkipListMap<String, Bucket> bucketMapGet;

  private ConcurrentSkipListMap<Integer, Long> bucketMapPostLatency;

  private ConcurrentSkipListMap<Integer, Long> bucketMapGetLatency;

  private ConcurrentSkipListMap<String, Bucket> peakPhaseBucket;

  private ConcurrentSkipListMap<String, Bucket> bucketMap;

  private ConcurrentSkipListMap<Integer, Long> latencyMap;
  private String number;

  /**
   * Process.
   *
   * @param args the args
   * @throws FileNotFoundException the file not found exception
   */
  public void process(String[] args) throws FileNotFoundException {
    this.filePathPost = args[0];
    this.filePathGet = args[1];
    this.threshold = args[2];
    this.number = args[3];

    generateOutput(args);
//      Thread t1 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//          generateChart(bucketMapPost, "POST-throughput-plot");
//        }
//      });
//      t1.start();
//    Thread t2 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        generateChart(bucketMapPostLatency, "POST-latency-plot");
//      }
//    });
//    t2.start();
//    Thread t3 = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        generateChart(bucketMapGetLatency, "GET-latency-plot");
//      }
//    });
//    t3.start();
    generateCombined();
    generatePeak();
//    generateChart(peakPhaseBucket, "POST-Peak-plot");
  }

  private <T, U> void generateChart(ConcurrentSkipListMap<T, U> bucketMap, String name) {
    new GenerateChart().compute(bucketMap, name);
  }

  private void generateCombined() {
    resetValues();
    executor();
  }

  private void generatePeak() throws FileNotFoundException {
    resetValues();
    ConcurrentSkipListMap<String, Bucket> peakPhaseBucket = findPeakPhase();
    this.peakPhaseBucket = peakPhaseBucket;
    ConcurrentLinkedQueue<String> queuePost = new ConcurrentLinkedQueue<>();
    StringBuilder sb = new StringBuilder();
    List<Long> latencyList = new ArrayList<>();
    List<Long> throughPut = new ArrayList<>();
    ThreadPoolExecutor pools = getThreadPool();
    writeQueue(peakPhaseBucket, sb, queuePost, latencyList, throughPut);
    setPeakValues(queuePost, sb, latencyList, throughPut);
    final String fileName =
        System.getProperty("user.dir") + "/" + filePathPost.replaceAll("raw", "peak");
    File filePost = new File(fileName);
    boolean deteted = filePost.delete();
    FileOutputStream outPost = new FileOutputStream(fileName, true);
    writeFile(pools, queuePost, outPost);
    pools.shutdown();
  }

  private void generateOutput(String[] args) {
    String[] pathArray = new String[2];
    pathArray[0] = args[0];
    pathArray[1] = args[1];
    for (int i = 0; i < 2; i++) {
      resetValues();
      try {
        executor(pathArray[i], i);
      } catch (Exception e) {
        //e.printStackTrace();
      }
    }
  }

  private void resetValues() {
    minTime = Long.MAX_VALUE;
    maxTime = Long.MIN_VALUE;
    totalLatency = 0;
    totalRequest = 0;
    highestRequest = 0;
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
          System.getProperty("user.dir") + "/"
              + filePathPost.replaceAll("raw", "GETcombined");
      //File file = new File(fileName);
      new File(fileName).delete();
      StringBuilder sb = new StringBuilder();
      long maxSize = Long.MIN_VALUE;
      maxSize = writeCombineFile(sb, maxSize);
      sb.append("\n\n");
      sb.append("Overall throughPut: " + totalRequest / (maxTime - minTime) + "\n");
      sb.append("Peak throughPut: " + maxSize);
      OutputStream out = new FileOutputStream(fileName);
      BufferedWriter bw = new BufferedWriter(
          new OutputStreamWriter(out, StandardCharsets.UTF_8));
      bw.write(sb.toString());
      bw.newLine();
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void executor(String path, int flag) throws Exception {
    String filePath = System.getProperty("user.dir") + "/" + path;
    BlockingQueue<Requests> blockingQueue = new ArrayBlockingQueue<>(DEFAULT_QUEUE_SIZE);
    ThreadPoolExecutor pools = getThreadPool();
    if (number.equals("1")) {
      pools.execute(new InnerReader(blockingQueue,
          filePath, DEFAULT_QUEUE_SIZE));
    } else {
      for (int j = 0; j < Integer.parseInt(number); j++) {
        pools.execute(new InnerReader(blockingQueue,
            filePath.replaceAll("raw", "raw-" + (j + 1) + "-" + number),
            DEFAULT_QUEUE_SIZE));
      }
    }
    ConcurrentSkipListMap<String, Bucket> bucketMap = new ConcurrentSkipListMap<>();
    ConcurrentSkipListMap<Integer, Long> latencyMap = new ConcurrentSkipListMap<>();
    this.bucketMap = bucketMap;
    this.latencyMap = latencyMap;
    for (int i = 0; i < Integer.parseInt(number); i++) {
      pools.execute(new WriteToMap(blockingQueue, bucketMap, latencyMap));
    }
    pools.shutdown();
    while (true) {
      if (pools.isTerminated()) {
        break;
      }
    }
    System.out.println("------");
    final String filePathBucket =
        System.getProperty("user.dir") + "/" + path.replaceAll("raw", "result");
    File fileBucketTime = new File(filePathBucket);
    fileBucketTime.delete();
    final String filePathLatency =
        System.getProperty("user.dir") + "/" + path.replaceAll("raw", "-latency");
    File fileLatency = new File(filePathLatency);
    fileLatency.delete();
    StringBuilder sbTime = new StringBuilder();
    StringBuilder sbLatency = new StringBuilder();
    List<Long> latencyList = new ArrayList<>();
    List<Long> throughPut = new ArrayList<>();
    FileOutputStream outPost = new FileOutputStream(fileBucketTime, true);
    FileOutputStream outLatency = new FileOutputStream(fileLatency, true);
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          writeFile(sbLatency, latencyMap, outLatency);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    t1.start();
    System.out.println("------");
    writeFile(sbTime, bucketMap, outPost, latencyList, throughPut);
    pools.shutdown();
    if (flag == 0) {
      this.bucketMapPost = bucketMap;
      this.bucketMapPostLatency = latencyMap;
    } else {
      this.bucketMapGet = bucketMap;
      this.bucketMapGetLatency = latencyMap;
    }
  }

  private void writeFile(StringBuilder sb, ConcurrentSkipListMap<Integer, Long> latencyMap,
      FileOutputStream outLatency) throws Exception {
    for (Integer key : latencyMap.keySet()) {
      sb.append("\"" + key + "\",");
      sb.append("\"" + latencyMap.get(key) + "\"");
      sb.append("\n");
    }
    outLatency.write(sb.toString().getBytes(Charset.forName("UTF-8")));
  }

  private void writeFile(StringBuilder sb,
      ConcurrentSkipListMap<String, Bucket> bucketMap, FileOutputStream outPost,
      List<Long> latencyList, List<Long> throughPut) throws Exception {
    for (String key : bucketMap.keySet()) {
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
    }
    setValues(sb, latencyList);
    outPost.write(sb.toString().getBytes(Charset.forName("UTF-8")));
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

  private void setValues(StringBuilder sb, //ConcurrentLinkedQueue<String> queuePost,
      List<Long> latencyList) {
    sb.append("Test Length: " + (maxTime - minTime) + "\n");
    sb.append("Mean Latency: " + totalLatency / (maxTime - minTime) + "\n");
    int index = (int) Math.ceil(latencyList.size() * 0.99);
    Collections.sort(latencyList);
    sb.append("The 99th Percentile Latency: " + latencyList.get(index) + "\n");
    sb.append("Total throughPut: " + totalRequest / (maxTime - minTime) + "\n");
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
