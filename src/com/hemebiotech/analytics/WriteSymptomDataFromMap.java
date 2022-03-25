package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Simple brute force implementation
 */
public class WriteSymptomDataFromMap implements ISymptomWriter {

  private final HashMap<String, Integer> symptomMap;
  private final String outputFile;

  /**
   * @param symptomMap a map that tracks number of occurrences per symptom
   * @param outputFile the name of an output file
   */
  public WriteSymptomDataFromMap(HashMap<String, Integer> symptomMap, String outputFile) {
    this.symptomMap = symptomMap;
    this.outputFile = outputFile;
  }

  @Override
  public void writeSymptoms() throws IOException {
    FileWriter writer = new FileWriter(outputFile);

    symptomMap.forEach((key, value) -> {
      try {
        writer.write(key + ": " + value.toString() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    writer.close();
  }

}
