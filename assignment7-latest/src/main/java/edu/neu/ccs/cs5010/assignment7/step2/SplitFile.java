package edu.neu.ccs.cs5010.assignment7.step2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


/**
 * The type Split file.
 */
public class SplitFile {

  /**
   * The File path.
   */
  String filePath;
  /**
   * The Number.
   */
  int number;
  /**
   * The Lines per file.
   */
  long linesPerFile;

  /**
   * Instantiates a new Split file.
   *
   * @param filePath the file path
   * @param number the number
   */
  public SplitFile(String filePath, int number) {
    this.filePath = filePath;
    this.number = number;
  }

  /**
   * Compute.
   */
  public void compute() {
    readData();
    split();
  }

  /**
   * Read data.
   */
  public void readData() {
    try {
      String path = System.getProperty("user.dir") + "/" + filePath;
      long linesNumber = 0;
      InputStream input = new FileInputStream(path);
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(input, StandardCharsets.UTF_8), 5 * 1024 * 1024);
      String line = null;
      while ((line = reader.readLine()) != null) {
        linesNumber++;
      }
      reader.close();
      linesPerFile = linesNumber / number;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * Split.
   */
  public void split() {
    try {
      String path = System.getProperty("user.dir") + "/" + filePath;
      long linesNumber = 0;
      InputStream input = new FileInputStream(path);
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(input, StandardCharsets.UTF_8), 5 * 1024 * 1024);
      String line = null;
      int numOfFiles = 0;
      StringBuffer sb = new StringBuffer();
      while ((line = reader.readLine()) != null) {
        sb.append(line);
        sb.append("\n");
        linesNumber++;
        if (linesNumber == linesPerFile && numOfFiles < number - 1) {
          System.out.println(linesNumber);
          sb.deleteCharAt(sb.length() - 1);
          writeFile(sb, ++numOfFiles);
          linesNumber = 0;
          sb.setLength(0);
        }
      }
      if (sb.length() != 0) {
        writeFile(sb, ++numOfFiles);
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * Write file.
   *
   * @param sb the sb
   * @param rank the rank
   * @throws Exception the exception
   */
  public void writeFile(StringBuffer sb, int rank) throws Exception {
    String path = System.getProperty("user.dir") + "/"
        + filePath.replaceAll("raw", "raw-" + rank + "-" + number);
    System.out.println(rank);
    OutputStream output = new FileOutputStream(path);
    BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(output, StandardCharsets.UTF_8));
    bw.write(sb.toString());
    sb.setLength(0);
    bw.flush();
    bw.close();
    output.close();
  }
}
