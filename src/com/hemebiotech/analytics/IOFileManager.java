package com.hemebiotech.analytics;

public class IOFileManager {
  /**
   * a manager file that stores the names the input and output files and keeps them private.
   */

  private final String inputFileName = "symptoms.txt";
  private final String outputFileName = "result.out";

  String getInputFile() {
    return inputFileName;
  }

  String getOutputFile() {
    return outputFileName;
  }

}