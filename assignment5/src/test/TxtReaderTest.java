package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class TxtReaderTest {
  TxtReader txtReader = new TxtReader("", "");
  TxtReader txtReaderWrong = new TxtReader(null, null);

  @Test(expected = RuntimeException.class)
  public void readEmailTemplate() throws Exception {
    List<String> data = txtReader.readEmailTemplate();
    assertEquals(txtReader.readEmailTemplate(), data);
    txtReaderWrong.readEmailTemplate();
  }

  @Test(expected = RuntimeException.class)
  public void readLetterTemplate() {
    List<String> data = txtReader.readLetterTemplate();
    assertEquals(txtReader.readLetterTemplate(), data);
    txtReaderWrong.readLetterTemplate();
  }

  @Test
  public void getEmailTemplatePath() {
    assertEquals(txtReader.getEmailTemplatePath(), "");
  }

  @Test
  public void setEmailTemplatePath() {
    txtReader.setEmailTemplatePath("");
    assertEquals(txtReader.getEmailTemplatePath(), "");
  }

  @Test
  public void getLetterTemplatePath() {
    assertEquals(txtReader.getLetterTemplatePath(), "");
  }

  @Test
  public void setLetterTemplatePath() {
    txtReader.setLetterTemplatePath("");
    assertEquals(txtReader.getLetterTemplatePath(), "");
  }
}