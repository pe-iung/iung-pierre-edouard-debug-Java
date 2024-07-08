package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadSymptomDataFromFile implements SymptomReader {

	private String filepath;

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public Map<String, Integer> countSymptoms(List<String> myDuplicatedSymptoms) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String symptom : myDuplicatedSymptoms) {

			// we put the string to lower case to avoid potential typo duplication.
			// e.g headache and Headache could be considered as 2 different symptoms if we do not use .toLowerCase()
			if (result.containsKey(symptom.toLowerCase())) { // todo : should I check typo upper/lower case ?
				result.put(symptom.toLowerCase(), result.get(symptom) + 1);
			}
			else {
				result.put(symptom, 1);
			}

		}
		return result;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Creating a TreeMap, which will automatically sort alphabetically the entries by key, as my key are String
		TreeMap<String, Integer> mySortedSymptoms = new TreeMap<>(symptoms);
		return mySortedSymptoms;
	}

}
