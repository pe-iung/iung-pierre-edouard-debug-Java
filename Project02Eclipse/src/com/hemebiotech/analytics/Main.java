package com.hemebiotech.analytics;

import com.hemebiotech.symptommanager.SymptomManager;
import com.hemebiotech.symptommanager.SymptomManagerImpl;

/**
 * This program will take a list of symptoms as inputs
 * and return a sorted and counted list of symptoms as output (without symptoms duplicated)
 */
public class Main {

    public static void main(String[] args) throws Exception {

		SymptomManager manager = new SymptomManagerImpl();
		var mySymptomslist = manager.getSymptoms();
		var mySymptomsCountedAndUnsorted = manager.countSymptoms(mySymptomslist);
		var mySymptomsCountedAndSorted = manager.sortSymptoms(mySymptomsCountedAndUnsorted);
		manager.writeSymptoms(mySymptomsCountedAndSorted);

	}
}
