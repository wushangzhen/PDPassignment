package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class CsvReaderTest {
  String csvTemplate = "insurance-company-members.csv";
  CsvReader csvReader = new CsvReader(csvTemplate);

  @Test
  public void getFilePath() {
    assertEquals(csvReader.getFilePath(), csvTemplate);
  }

  @Test
  public void setFILE_PATH() {
    csvReader.setFilePath("*");
    assertEquals(csvReader.getFilePath(), "*");
  }

  @Test(expected = RuntimeException.class)
  public void readData() {
    csvReader.setFilePath("*");
    csvReader.readData();
  }
}