package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadSymptomDataFromFile implements the ISymptomReader interface
 * and reads data from a given file (identified via filePath)
 * and returns a list of symptom-strings.
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

  private final String filepath;

  /**
   * @param filepath a full or partial path to file with symptom strings in it, one per line
   */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  /**
   * A list of all symptoms obtained from a text file data source, duplicates are
   * @return a list of all symptoms
   * possible/probable
   */
  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<>();

    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        if (line == null) {
          throw new EmptyFileException();
        }

        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (EmptyFileException e) {
        e.printStackTrace(e.getMessage());
      }
    }

    return result;
  }

}
