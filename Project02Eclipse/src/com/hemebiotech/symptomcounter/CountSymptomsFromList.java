package com.hemebiotech.symptomcounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptomsFromList implements SymptomCounter {
    /**
     * <p> Count the symptoms given as inputs of our program
     * @param symptoms the list of input symptoms
     * @return a Map of counted (but unsorted) <symptoms,count>
     * this Map will not be sorted alphabetically yet
     */

    @Override
    public Map<String, Integer> countSymptoms(List<String> symptoms) {


        Map<String, Integer> result = new HashMap<String, Integer>();

        for (String symptom : symptoms) {

            var value =  result.getOrDefault(symptom.toLowerCase(), 0);

            result.put(symptom.toLowerCase(), value + 1);


        }

        return result;
    }
    /**
     * <p> Sort the symptoms by using a TreeMap as output
     * @param unsortedSymptoms the Map<key,value> of counted symptoms
     *                         where key = a given symptom,
     *                         value = counter for the given symptom
     * @return a TreeMap of sorted <symptoms,count>
     * this TreeMap will automatically sort alphabetically the entries by key, as my key are String
     */
    // Creating a TreeMap,
    public Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms){

        return new TreeMap<>(unsortedSymptoms);
    }
}
