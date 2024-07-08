package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {


	public static void main(String args[]) throws Exception {

		// read the symptoms from input file
		ReadSymptomDataFromFile myReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> myDuplicatedSymptoms = myReader.getSymptoms();

		// count the symptoms and delete duplicates symptoms
		Map<String, Integer> myCountedSymptoms = myReader.countSymptoms(myDuplicatedSymptoms);

		// sort the symptoms and delete duplicates symptoms
		Map<String, Integer> mySortedSymptoms = myReader.sortSymptoms(myCountedSymptoms);

		// write the symptoms in the output.txt file
		WriteSymptomDataToFile myWriter = new WriteSymptomDataToFile();
		myWriter.writeSymptoms(mySortedSymptoms);


	}
}
