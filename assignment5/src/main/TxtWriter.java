package edu.neu.ccs.cs5010.assignment5;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * A txt writer class.
 */
public class TxtWriter {

  private String fileDir;

  /**
   * Txt writer constructor.
   * @param fileDir the output dir String
   */
  public TxtWriter(String fileDir) {
    this.fileDir = fileDir;
  }

  /**
   * Write the email function
   * @param emailTemplate list of String of email template
   * @param customerInfo list of String of customer info
   */
  public void writeEmails(List<String> emailTemplate, CustomerInfo customerInfo) {
    try {
      final String FILE_NAME = System.getProperty("user.dir") + "/" + fileDir + "/"
          + customerInfo.getFirstName() + "_" + customerInfo.getLastName() + ".txt";
      File emailTXT = new File(FILE_NAME);
      BufferedWriter bw = new BufferedWriter(new FileWriter(emailTXT, true));
      StringBuffer sb = new StringBuffer();
      for (String line : emailTemplate) {
        line = replaceKeyInfo(line, customerInfo);
        sb.append(line);
        sb.append("\n");
      }
      bw.write(sb.toString());
      bw.newLine();
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * write letter function.
   * @param letterTemplate List of String letter template
   * @param customerInfo List of String customer info
   */
  public void writeLetter(List<String> letterTemplate, CustomerInfo customerInfo) {
    try {
      final String FILE_NAME = System.getProperty("user.dir") + "/" + fileDir + "/"
          + customerInfo.getFirstName() + "_" + customerInfo.getLastName() + ".txt";
      File emailTXT = new File(FILE_NAME);
      BufferedWriter bw = new BufferedWriter(new FileWriter(emailTXT, true));
      StringBuffer sb = new StringBuffer();
      for (String line : letterTemplate) {
        line = replaceKeyInfo(line, customerInfo);
        System.out.println(line);
        sb.append(line);
        sb.append("\n");
      }
      bw.write(sb.toString());
      bw.newLine();
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * replace the key information in the template.
   * @param line template line
   * @param customerInfo customer information
   * @return String of replaced line
   */
  public String replaceKeyInfo(String line, CustomerInfo customerInfo) {
    line = line.replaceAll("\\[\\[email\\]\\]", customerInfo.getEmail());
    line = line.replaceAll("\\[\\[first_name\\]\\]", customerInfo.getFirstName());
    line = line.replaceAll("\\[\\[last_name\\]\\]", customerInfo.getLastName());
    line = line.replaceAll("\\[\\[company_name\\]\\]", customerInfo.getCompanyName());
    line = line.replaceAll("\\[\\[address\\]\\]", customerInfo.getAddress());
    line = line.replaceAll("\\[\\[county\\]\\]", customerInfo.getCounty());
    line = line.replaceAll("\\[\\[state\\]\\]", customerInfo.getState());
    line = line.replaceAll("\\[\\[zip\\]\\]", customerInfo.getZip());
    line = line.replaceAll("\\[\\[email\\]\\]", customerInfo.getEmail());
    line = line.replaceAll("\\[\\[city\\]\\]", customerInfo.getCity());
    return line;
  }

  public String getFileDir() {
    return fileDir;
  }

  public void setFileDir(String fileDir) {
    this.fileDir = fileDir;
  }
}
