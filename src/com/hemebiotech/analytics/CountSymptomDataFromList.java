package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Simple brute force implementation
 *
 */
public class CountSymptomDataFromList implements ISymptomCounter {

	private final ArrayList<String> symptomList;

	/**
	 *
	 * @param symptomList a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public CountSymptomDataFromList(ArrayList<String> symptomList) {
		this.symptomList = symptomList;
	}
	
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
