package com.hemebiotech.analytics;

public class IOFileManager {

  private final String inputFileName = "symptoms.txt";
  private final String outputFileName = "result.out";

  String getInputFile() {
    return inputFileName;
  }

  String getOutputFile() {
    return outputFileName;
  }

}