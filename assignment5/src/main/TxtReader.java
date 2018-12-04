package edu.neu.ccs.cs5010.assignment5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Txt reader class.
 */
public class TxtReader {

  private String emailTemplatePath;
  private String letterTemplatePath;

  /**
   *Constructor for txt reader.
   * @param emailTemplatePath String of email template
   * @param letterTemplatePath String of letter template
   */
  public TxtReader(String emailTemplatePath, String letterTemplatePath) {
    this.emailTemplatePath = emailTemplatePath;
    this.letterTemplatePath = letterTemplatePath;
  }

  /**
   * Read Email template.
   * @return List of String which will represent the email template
   */
  public List<String> readEmailTemplate() {
    try {
      List<String> data = new ArrayList<>();
      if (emailTemplatePath.equals("")) {
        return data;
      }
      String path = System.getProperty("user.dir") + "/" + emailTemplatePath;
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String line = null;
      while ((line = reader.readLine()) != null) {
        data.add(line);
      }
      reader.close();
      return data;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
      //return null;
    }
  }

  /**
   * read Letter template.
   * @return List of String of letter template
   */
  public List<String> readLetterTemplate() {
    try {
      List<String> data = new ArrayList<>();
      if (letterTemplatePath.equals("")) {
        return data;
      }
      String path = System.getProperty("user.dir") + "/" + letterTemplatePath;
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String line = null;
      while ((line = reader.readLine()) != null) {
        data.add(line);
      }
      reader.close();
      return data;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * Getters and setters
   */

  public String getEmailTemplatePath() {
    return emailTemplatePath;
  }

  public void setEmailTemplatePath(String emailTemplatePath) {
    this.emailTemplatePath = emailTemplatePath;
  }

  public String getLetterTemplatePath() {
    return letterTemplatePath;
  }

  public void setLetterTemplatePath(String letterTemplatePath) {
    this.letterTemplatePath = letterTemplatePath;
  }
}
