package edu.neu.ccs.cs5010.assignment5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Csv reader class.
 */
public class CsvReader {

  private String filePath;

  /**
   * csv reader constructor.
   * @param filePath the string of file path.
   */
  public CsvReader(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Read data method.
   * @return List of String array
   */
  public List<String[]> readData() {
    try {
      String path = System.getProperty("user.dir") + "/" + filePath;
      BufferedReader reader = new BufferedReader(new FileReader(path));
      List<String[]> data = new ArrayList<>();
      String headLine = reader.readLine();
      String line = null;
      String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
      while ((line = reader.readLine()) != null) {
        String items[] = line.split(csvSplitBy);
        for (int i = 0; i < items.length; i++) {
          items[i] = items[i].replaceAll("\"", "");
        }
        if (items.length == 1) {
          continue;
        }
        data.add(items);
      }
      reader.close();
      return data;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * Getters and setters.
   */
  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
}
