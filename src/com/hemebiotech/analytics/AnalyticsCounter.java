package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsInFileList = reader.GetSymptoms();

		HashMap<String, Integer> symptomMap = new HashMap<String, Integer>();

		for (String symptomString : symptomsInFileList) {
			if (!symptomMap.containsKey(symptomString)) {
				symptomMap.put(symptomString, 1);
			} else {
				symptomMap.put(symptomString, symptomMap.get(symptomString) + 1);
			}
		}

		System.out.printf(String.valueOf(symptomMap));

		// next generate output
		WriteSymptomDataFromMap writer = new WriteSymptomDataFromMap(symptomMap);
		writer.WriteSymptoms();
	}
}
