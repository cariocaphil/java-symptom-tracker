package com.hemebiotech.analytics;


import java.util.HashMap;

public interface ISymptomCounter {
    /**
     * @return a map of symptoms with their respective occurences
     */
    HashMap<String, Integer> countSymptoms();
}
