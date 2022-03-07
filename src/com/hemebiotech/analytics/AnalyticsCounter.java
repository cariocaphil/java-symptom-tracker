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

		HashMap<String, Integer> symptomMap = new HashMap<String, Integer>();

		int j = 0;
		while (line != null) {
			j++;
			System.out.println("symptom from file: " + line);

			if (!symptomMap.containsKey(line)) {
				symptomMap.put(line, 1);
			} else {
				symptomMap.put(line, symptomMap.get(line) + 1);
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
