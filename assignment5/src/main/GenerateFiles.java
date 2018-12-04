package edu.neu.ccs.cs5010.assignment5;

import java.util.List;

/**
 * Generate files.
 */
public class GenerateFiles {

  DataBase dataBase;
  TxtWriter txtWriter;

  /**
   * Constructor dataBase.
   * @param dataBase dataBase
   * @param outputDir String of outputDir
   */
  public GenerateFiles(DataBase dataBase, String outputDir) {
    this.dataBase = dataBase;
    txtWriter = new TxtWriter(outputDir);
  }

  /**
   * Generate Emails.
   */
  public void generateEmails() {
    List<String> emailTemplate = dataBase.getEmailTemplate();
    List<CustomerInfo> customerData = dataBase.getCustomerInfoList();
    for (int i = 0; i < customerData.size(); i++) {
      txtWriter.writeEmails(emailTemplate, customerData.get(i));
    }
  }

  /**
   * Generate letters.
   */
  public void generateLetters() {
    List<String> letterTemplate = dataBase.getLetterTemplate();
    List<CustomerInfo> customerData = dataBase.getCustomerInfoList();
    for (int i = 0; i < customerData.size(); i++) {
      txtWriter.writeLetter(letterTemplate, customerData.get(i));
    }
  }
}
