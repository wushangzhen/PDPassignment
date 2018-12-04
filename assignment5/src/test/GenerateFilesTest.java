package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import org.junit.Before;
import org.junit.Test;

public class GenerateFilesTest {
  DataBase database;
  GenerateFiles generateFiles;

  @Before
  public void setUp() throws Exception {
    String emailTemplate = "email-template.txt";
    String letterTemplate = "letter-template.txt";
    String csvTemplate = "insurance-company-members.csv";
    String outPut = "email";
    Initialization initialization = new Initialization(csvTemplate, emailTemplate, letterTemplate);
    database = initialization.setDataToDataBase();
    generateFiles = new GenerateFiles(database, outPut);
  }
}