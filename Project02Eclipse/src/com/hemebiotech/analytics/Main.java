package com.hemebiotech.analytics;

import com.hemebiotech.symptommanager.SymptomManager;
import com.hemebiotech.symptommanager.SymptomManagerImpl;
import java.util.List;
import java.util.Map;

/**
 * This program will take a list of symptoms as inputs
 * and return a sorted and counted list of symptoms as output (without symptoms duplicated)
 */
public class Main {

    public static void main(String[] args) throws Exception {

        try {
            SymptomManager manager = new SymptomManagerImpl();
            final List<String> mySymptomslist = manager.getSymptoms();
            final Map<String, Integer> mySymptomsCountedAndUnsorted = manager.countSymptoms(mySymptomslist);
            final Map<String, Integer> mySymptomsCountedAndSorted = manager.sortSymptoms(mySymptomsCountedAndUnsorted);
            manager.writeSymptoms(mySymptomsCountedAndSorted);
        } catch (Exception e) {
            System.out.printf("An error has occured : %s",  e.getMessage());
        }

    }
}
