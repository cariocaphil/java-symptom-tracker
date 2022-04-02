package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {

  private final IOFileManager fileManager = new IOFileManager();
  private List<String> symptomsInFileList = new ArrayList<>();
  private HashMap<String, Integer> symptomMap = new HashMap<>();

  // first get input
  void readDataFromFile() {
    ISymptomReader reader = new ReadSymptomDataFromFile(fileSpecifications.getInputFile());
    symptomsInFileList = reader.getSymptoms();
  }

  // sort and count
  void countData() {
    ISymptomCounter counter = new CountSymptomDataFromList((ArrayList<String>) symptomsInFileList);
    symptomMap = counter.countSymptoms();
  }

  // next generate output
  void writeOutput() {
    ISymptomWriter writer = new WriteSymptomDataFromMap(symptomMap,
        fileSpecifications.getOutputFile());
    try {
      writer.writeSymptoms();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
