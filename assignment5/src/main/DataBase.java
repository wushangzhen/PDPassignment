package edu.neu.ccs.cs5010.assignment5;

import java.util.List;

/**
 * data base class will contain the customer info, email template and letter template.
 */
public class DataBase {

  private List<CustomerInfo> customerInfoList;
  private List<String> emailTemplate;
  private List<String> letterTemplate;

  public void setEmailTemplate(List<String> emailTemplate) {
    this.emailTemplate = emailTemplate;
  }

  public void setLetterTemplate(List<String> letterTemplate) {
    this.letterTemplate = letterTemplate;
  }

  /**
   * Data base constructor.
   */
  public DataBase() {
  }

  public void setCustomerInfoList(
      List<CustomerInfo> customerInfoList) {
    this.customerInfoList = customerInfoList;
  }

  public List<CustomerInfo> getCustomerInfoList() {
    return customerInfoList;
  }

  public List<String> getEmailTemplate() {
    return emailTemplate;
  }

  public List<String> getLetterTemplate() {
    return letterTemplate;
  }
}
