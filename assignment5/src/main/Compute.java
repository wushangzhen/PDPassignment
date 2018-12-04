package edu.neu.ccs.cs5010.assignment5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A class for main function.
 */
public class Compute {

  private static final String EMAIL_COMMAND = "--email";
  private static final String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static final String LETTER_COMMAND = "--letter";
  private static final String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_COMMAND = "--csv-file";

  /**
   * getters and setters.
   */
  public static String getEmailCommand() {
    return EMAIL_COMMAND;
  }

  public static String getEmailTemplateCommand() {
    return EMAIL_TEMPLATE_COMMAND;
  }

  public static String getLetterCommand() {
    return LETTER_COMMAND;
  }

  public static String getLetterTemplateCommand() {
    return LETTER_TEMPLATE_COMMAND;
  }

  public static String getOutputDir() {
    return OUTPUT_DIR;
  }

  public static String getCsvCommand() {
    return CSV_COMMAND;
  }


  /**
   * main function will takes command line arguments.
   * @param args command line arguments
   */
  public void compute(String[] args) {
    Set<String> commandOptions = new HashSet<>();
    Map<String, String> addressMap = new HashMap<>();
    for (int i = 0; i < args.length; i++) {
      commandOptions.add(args[i]);
      if (args[i].equals(EMAIL_TEMPLATE_COMMAND)
          || args[i].equals(LETTER_TEMPLATE_COMMAND)
          || args[i].equals(OUTPUT_DIR)
          || args[i].equals(CSV_COMMAND)) {
        if (i != args.length - 1) {
          addressMap.put(args[i], args[i + 1]);
        } else {
          System.out.println(args[i] + " should have a valid address");
          printUsage();
          return;
        }
      }
    }
    addressMap.putIfAbsent(EMAIL_TEMPLATE_COMMAND, "");
    addressMap.putIfAbsent(LETTER_TEMPLATE_COMMAND, "");
    if (!commandOptions.contains(EMAIL_COMMAND) || !commandOptions.contains(LETTER_COMMAND)) {
      printUsage();
      return;
    }
    if (checkDirAndCsv(commandOptions)) {
      generate(addressMap);
      return;
    }
    printUsage();
  }

  /**
   * Generate files.
   * @param addressMap address map record the address
   */
  public void generate(Map<String, String> addressMap) {
    String csvPath = addressMap.get(CSV_COMMAND);
    String dirPath = addressMap.get(OUTPUT_DIR);
    String emailPath = addressMap.get(EMAIL_TEMPLATE_COMMAND);
    String letterPath = addressMap.get(LETTER_TEMPLATE_COMMAND);
    Initialization initialization = new Initialization(csvPath, emailPath, letterPath);
    GenerateFiles generateFiles = new GenerateFiles(initialization.setDataToDataBase(), dirPath);
    generateFiles.generateEmails();
    generateFiles.generateLetters();
  }

  /**
   * Check whether if exist dir and csv command.
   * @param commandOptions command line options
   * @return boolean value
   */
  public boolean checkDirAndCsv(Set<String> commandOptions) {
    if (commandOptions.contains(OUTPUT_DIR)) {
      if (commandOptions.contains(CSV_COMMAND)) {
        return true;
      }
    }
    return false;
  }

  /**
   * print the usage of function.
   */
  public void printUsage() {
    StringBuilder sb = new StringBuilder();
    sb.append("Usage:\n");
    sb.append("\t--email\tonly generate email messages\n");
    sb.append("\t--email-template <file> accept a filename that holds the email template.\n");
    sb.append("\t\tRequired if --email is used\n\n");
    sb.append("\t--letter\tonly generate letters\n");
    sb.append("\t--letter-template <file> accept a filename "
        + "that holds the email template.\n");
    sb.append("\t\tRequired if --letter is used\n\n");
    sb.append("\t--output-dir <path> accept the name of a folder, "
        + "all output is placed in this folder\n\n");
    sb.append("\t--csv-file <path> accept the name of the csv file to process\n\n");
    sb.append("Examples\n\n");
    sb.append("\t--email --email-template email-template.txt --output-dir-emails "
        + "-- csv-file customer.csv\n\n");
    sb.append("\t--letter --letter-template letter-template.txt --output-dir-letters "
        + "-- csv-file customer.csv\n\n");
    System.out.print(sb.toString());
  }

}
