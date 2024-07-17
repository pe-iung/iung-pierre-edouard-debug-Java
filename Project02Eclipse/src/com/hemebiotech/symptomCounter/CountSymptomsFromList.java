package com.hemebiotech.symptomCounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptomsFromList implements SymptomCounter {
    @Override
    public Map<String, Integer> countSymptoms(List<String> symptoms) {


        Map<String, Integer> result = new HashMap<String, Integer>();

        for (String symptom : symptoms) {

            var value =  result.getOrDefault(symptom.toLowerCase(), 0);

            result.put(symptom.toLowerCase(), value + 1);


        }

        return result;
    }

    // Creating a TreeMap, which will automatically sort alphabetically the entries by key, as my key are String
    public Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms){

        return new TreeMap<>(unsortedSymptoms);
    }
}
