package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataFromMap implements ISymptomWriter {

	private HashMap<String, Integer> symptomMap;


	/**
	 *
	 * @param symptomMap a map that tracks number of occurences per symptom
	 */
	public WriteSymptomDataFromMap(HashMap<String, Integer> symptomMap) {
		this.symptomMap = symptomMap;
	}
	
	@Override
	public void WriteSymptoms() throws IOException {
		FileWriter writer = new FileWriter ("result.out");

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
