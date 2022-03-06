package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		List<String> symptomList = Arrays.asList("headache","rash","pupils");

		HashMap<String, Integer> symptomMap = new HashMap<String, Integer>();
		for (int i =0; i < symptomList.size(); i++) {
			symptomMap.put(symptomList.get(i), 0);
		}
		int j = 0;
		while (line != null) {
			j++;
			System.out.println("symptom from file: " + line);

			for(int k =0; k < symptomList.size(); k++) {
				if (line.contains(symptomList.get(k))) {
					symptomMap.put(symptomList.get(k), symptomMap.get(symptomList.get(k)) + 1);
				}
			}

			line = reader.readLine();	// get another symptom
		}

		System.out.printf(String.valueOf(symptomMap));

		reader.close();

		// next generate output
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
