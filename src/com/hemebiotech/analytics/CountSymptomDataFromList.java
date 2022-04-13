package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * CountSymptomDataFromList implements the ISymptomCounter interface and takes in a list of symptom strings
 * and transform it to a map of alphabetically sorted entries of symptom names with their respective occurrences.
 */
public class CountSymptomDataFromList implements ISymptomCounter {

  private final ArrayList<String> symptomList;

  /**
   * @param symptomList a raw listing of all Symptoms obtained from a data source, duplicates are
   * possible/probable
   */
  public CountSymptomDataFromList(ArrayList<String> symptomList) {
    this.symptomList = symptomList;
  }

  /**
   *
   * countSymptoms sorts the provided symptomList alphabetically and counts occurrences
   * @return symptomMap which is a map of symptoms and their respective occurrences
   */
  @Override
  public HashMap<String, Integer> countSymptoms() {
    Collections.sort(symptomList);
    LinkedHashMap<String, Integer> symptomMap = new LinkedHashMap<>();

    for (String symptomString : symptomList) {
      if (!symptomMap.containsKey(symptomString)) {
        symptomMap.put(symptomString, 1);
      } else {
        symptomMap.put(symptomString, symptomMap.get(symptomString) + 1);
      }
    }

    return symptomMap;
  }

}
