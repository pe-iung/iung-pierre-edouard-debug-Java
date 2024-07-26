package com.hemebiotech.symptommanager;

import com.hemebiotech.symptomcounter.CountSymptomsFromList;
import com.hemebiotech.symptomcounter.SymptomCounter;
import com.hemebiotech.symptomreader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomreader.SymptomReader;
import com.hemebiotech.symptomwriter.SymptomWriter;
import com.hemebiotech.symptomwriter.WriteSymptomDataToFile;

import java.util.List;
import java.util.Map;

/**
 * SymptomManagerImpl is coordinating the reading, counting/sorting and writing part of this program
 */
public class SymptomManagerImpl implements SymptomManager {

    private static final String INPUT_SYMPTOMS_FILE = "Project02Eclipse/symptoms.txt";
    private static final String OUTPUT_SYMPTOMS_FILE = "Project02Eclipse/result.out";

    private final SymptomReader symptomReader;
    private final SymptomCounter symptomCounter;
    private final SymptomWriter symptomWriter;

    /**
     *   constructor for SymptomManagerImpl implementing SymptomManager
     *
     * @throws Exception in case of issue when ReadSymptomDataFromFile, CountSymptomsFromList,
     * or WriteSymptomDataToFile objects are created with args input & output file
     */
    public SymptomManagerImpl() throws Exception {
        symptomReader = new ReadSymptomDataFromFile(INPUT_SYMPTOMS_FILE);
        symptomCounter = new CountSymptomsFromList();
        symptomWriter = new WriteSymptomDataToFile(OUTPUT_SYMPTOMS_FILE);
    }

    /**
     * read the symptoms from our symptomReader, in this case the symptomReader reads input file
     * @return a List of symptoms
     * @throws Exception if something un-expected happen reading the symptoms
     */
    public List<String> getSymptoms() throws Exception {
        return symptomReader.getSymptoms();
    }

    /**
     * count the symptoms from a reader
     * @param  symptoms is a list of symptoms (uncounted, unsorted)
     * @return a Map with key=symptom, value = counter of occurrences for this symptom
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        return symptomCounter.countSymptoms(symptoms);
    }

    /**
     * sort the symptoms from a reader
     * @param  unsortedSymptoms is a Map of counted symptoms
     * (key=symptom, value=counter of symptoms) but not yet sorted
     * @return an alphabetically sorted Map with key=symptom, value = counter of occurrences for this symptom
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms) {
        return symptomCounter.sortSymptoms(unsortedSymptoms);
    }

    /**
     * write the sorted and counted symptoms in on output file
     * @param  symptoms is a Map of counted and sorted symptoms
     * (key=symptom, value=counter of symptoms)
     * @throws Exception if something unexpected happen when writing symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms) throws Exception {
        symptomWriter.writeSymptoms(symptoms);
    }


}
