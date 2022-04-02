package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * AnalyticsCounter orchestrates the interplay between a reader of data, a counter, and a report-output writer class.
 */

public class AnalyticsCounter {

  private List<String> symptomsInFileList = new ArrayList<>();
  private HashMap<String, Integer> symptomMap = new HashMap<>();

  /**
   * reads the source input file and
   * transforms the symptom-data contained there into a list
   */
  public void readDataFromFile() {
    ISymptomReader reader = new ReadSymptomDataFromFile(Constants.inputFileName);
    symptomsInFileList = reader.getSymptoms();
  }

  /**
   * sorts the list of symptoms and
   * counts their occurrences
   */
  public void countData() {
    ISymptomCounter counter = new CountSymptomDataFromList((ArrayList<String>) symptomsInFileList);
    symptomMap = counter.countSymptoms();
  }

  /**
   * prints the analyzed data into an output file
   */
  public void writeOutput() {
    ISymptomWriter writer = new WriteSymptomDataFromMap(symptomMap, Constants.outputFileName);
    try {
      writer.writeSymptoms();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
