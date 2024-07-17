package com.hemebiotech.symptomManager;

import com.hemebiotech.symptomCounter.CountSymptomsFromList;
import com.hemebiotech.symptomCounter.SymptomCounter;
import com.hemebiotech.symptomReader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomReader.SymptomReader;
import com.hemebiotech.symptomWriter.SymptomWriter;
import com.hemebiotech.symptomWriter.WriteSymptomDataToFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SymptomManagerImpl implements SymptomManager {

    private static String INPUT_SYMPTOMS_FILE =  "Project02Eclipse/symptoms.txt";
    private static String OUTPUT_SYMPTOMS_FILE =  "Project02Eclipse/result.out";

    SymptomReader symptomReader = new ReadSymptomDataFromFile(INPUT_SYMPTOMS_FILE);
    SymptomCounter symptomCounter = new CountSymptomsFromList();

    SymptomWriter symptomWriter = new WriteSymptomDataToFile(OUTPUT_SYMPTOMS_FILE);


    public List<String> getSymptoms() throws IOException {
        return symptomReader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms){
        return symptomCounter.countSymptoms(symptoms);
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms){
        return symptomCounter.sortSymptoms(unsortedSymptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException{
        symptomWriter.writeSymptoms(symptoms);
    }


}
