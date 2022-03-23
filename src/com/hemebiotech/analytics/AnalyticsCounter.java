package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsInFileList = reader.getSymptoms();

		ISymptomCounter counter = new CountSymptomDataFromList((ArrayList<String>) symptomsInFileList);

		HashMap<String, Integer> symptomMap = counter.countSymptoms();

		// next generate output
		ISymptomWriter writer = new WriteSymptomDataFromMap(symptomMap);
		writer.writeSymptoms();
	}
}
