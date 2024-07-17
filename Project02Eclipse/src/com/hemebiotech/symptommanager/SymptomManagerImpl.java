package com.hemebiotech.symptommanager;

import com.hemebiotech.symptomcounter.CountSymptomsFromList;
import com.hemebiotech.symptomcounter.SymptomCounter;
import com.hemebiotech.symptomreader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomreader.SymptomReader;
import com.hemebiotech.symptomwriter.SymptomWriter;
import com.hemebiotech.symptomwriter.WriteSymptomDataToFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * SymptomManagerImpl is coordinating the reading, counting/sorting and writting part of this program
 */
public class SymptomManagerImpl implements SymptomManager {

    private static final String INPUT_SYMPTOMS_FILE = "Project02Eclipse/symptoms.txt";
    private static final String OUTPUT_SYMPTOMS_FILE = "Project02Eclipse/result.out";

    SymptomReader symptomReader = new ReadSymptomDataFromFile(INPUT_SYMPTOMS_FILE);
    SymptomCounter symptomCounter = new CountSymptomsFromList();

    SymptomWriter symptomWriter = new WriteSymptomDataToFile(OUTPUT_SYMPTOMS_FILE);


    public List<String> getSymptoms() throws IOException {
        return symptomReader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        return symptomCounter.countSymptoms(symptoms);
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms) {
        return symptomCounter.sortSymptoms(unsortedSymptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        symptomWriter.writeSymptoms(symptoms);
    }


}
