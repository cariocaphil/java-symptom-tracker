package com.hemebiotech.analytics;


import java.util.HashMap;

/**
 *
 * Anything that will sort and count symptom data contained in a list of symptoms. The important part is the return value from
 * the operation, which is a map of symptom data.
 */
public interface ISymptomCounter {

  /**
   * simply sorts and counts occurrences
   * @return a map of symptoms with their respective occurrences
   */
  HashMap<String, Integer> countSymptoms();
}
