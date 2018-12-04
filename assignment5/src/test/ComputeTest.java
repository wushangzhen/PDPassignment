package edu.neu.ccs.cs5010.assignment5;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComputeTest {
  private Compute compute = new Compute();
  private String[] commandNormal = new String[10];
  private String[] commandWrong = new String[1];
  private String[] commandWithOutRequired = new String[2];
  private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();


  @Test
  public void compute() {
    compute.compute(commandNormal);
    compute.compute(commandWrong);
    compute.compute(commandWithOutRequired);
  }

  @Test
  public void checkDIRAndCSV() {
    Set<String> set = new HashSet<>();
    assertFalse(compute.checkDIRAndCSV(set));
  }

  @Test
  public void printUsage() {
    StringBuilder sb = new StringBuilder();
    sb.append("Usage:\n");
    sb.append("\t--email\tonly generate email messages\n");
    sb.append("\t--email-template <file> accept a filename that holds the email template.\n");
    sb.append("\t\tRequired if --email is used\n\n");
    sb.append("\t--letter\tonly generate letters\n");
    sb.append( "\t--letter-template <file> accept a filename "
        + "that holds the email template.\n");
    sb.append("\t\tRequired if --letter is used\n\n");
    sb.append( "\t--output-dir <path> accept the name of a folder, "
        + "all output is placed in this folder\n\n");
    sb.append("\t--csv-file <path> accept the name of the csv file to process\n\n");
    sb.append("Examples\n\n");
    sb.append("\t--email --email-template email-template.txt --output-dir-emails "
        + "-- csv-file customer.csv\n\n");
    sb.append("\t--letter --letter-template letter-template.txt --output-dir-letters "
        + "-- csv-file customer.csv\n\n");
    compute.printUsage();
    assertEquals(outStream.toString(), sb.toString());
  }

  @Before
  public void setUp() throws Exception {
    commandNormal[0] = compute.getEmailCommand();
    commandNormal[1] = compute.getLetterCommand();
    commandNormal[2] = compute.getEmailTemplateCommand();
    String emailTemplate = "email-template.txt";
    String letterTemplate = "letter-template.txt";
    String csvTemplate = "insurance-company-members.csv";
    commandNormal[3] = emailTemplate;
    commandNormal[4] = compute.getLetterTemplateCommand();
    commandNormal[5] = letterTemplate;
    commandNormal[6] = compute.getCsvCommand();
    commandNormal[7] = csvTemplate;
    commandNormal[8] = compute.getOutputDir();
    commandNormal[9] = "Emails";
    commandWrong[0] = compute.getEmailTemplateCommand();
    commandWithOutRequired[0] = compute.getEmailTemplateCommand();
    commandWithOutRequired[1] = letterTemplate;
    System.setOut(new PrintStream(outStream));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(System.out);
    System.setIn(System.in);
  }
}