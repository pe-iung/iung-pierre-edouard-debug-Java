package com.hemebiotech.analytics;

import com.hemebiotech.symptommanager.SymptomManager;
import com.hemebiotech.symptommanager.SymptomManagerImpl;

public class Main {

	public static void main(String args[]) throws Exception {

		SymptomManager manager = new SymptomManagerImpl();
		var mySymptomslist = manager.getSymptoms();
		var mySymptomsCountedAndUnsorted = manager.countSymptoms(mySymptomslist);
		var mySymptomsCountedAndSorted = manager.sortSymptoms(mySymptomsCountedAndUnsorted);
		manager.writeSymptoms(mySymptomsCountedAndSorted);

	}
}
