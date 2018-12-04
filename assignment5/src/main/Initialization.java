package edu.neu.ccs.cs5010.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to initialization.
 */
public class Initialization {

  CsvReader csvReader;
  TxtReader txtReader;

  /**
   * A constructor for initialization.
   * @param csvPath String of csvPath
   * @param eTemplateDir String of email template
   * @param lTemplateDir String of letter template
   */
  public Initialization(String csvPath, String eTemplateDir, String lTemplateDir) {
    csvReader = new CsvReader(csvPath);
    txtReader = new TxtReader(eTemplateDir, lTemplateDir);
  }

  /**
   * Set data to data base.
   * @return Database
   */
  public DataBase setDataToDataBase() {
    DataBase dataBase = new DataBase();
    List<String[]> datas = csvReader.readData();
    List<CustomerInfo> customerInfoList = new ArrayList<>();
    for (int i = 0; i < datas.size(); i++) {
      customerInfoList.add(createNewCustomer(datas.get(i)));
    }
    dataBase.setCustomerInfoList(customerInfoList);
    dataBase.setEmailTemplate(txtReader.readEmailTemplate());
    dataBase.setLetterTemplate(txtReader.readLetterTemplate());
    return dataBase;
  }

  /**
   * Create the new Customer.
   * @param data String array for construct customer
   * @return Customer info object
   */
  public CustomerInfo createNewCustomer(String[] data) {
    return new CustomerInfo(data[0], data[1], data[2], data[3], data[4], data[5],
        data[6], data[7], data[8], data[9], data[10], data[11]);
  }
}
