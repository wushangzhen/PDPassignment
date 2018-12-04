package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TxtWriterTest {
  String fileDir = "Email";
  TxtWriter txtWriter = new TxtWriter(null);

  @Test(expected = RuntimeException.class)
  public void writeEmails() {
    txtWriter.writeEmails(null, null);
  }

  @Test(expected = RuntimeException.class)
  public void writeLetter() {
    txtWriter.writeLetter(null, null);
  }

  @Test
  public void getFileDir() {
    assertEquals(txtWriter.getFileDir(), null);
  }

  @Test
  public void setFileDir() {
    txtWriter.setFileDir("xxx");
    assertEquals(txtWriter.getFileDir(), "xxx");
  }
}