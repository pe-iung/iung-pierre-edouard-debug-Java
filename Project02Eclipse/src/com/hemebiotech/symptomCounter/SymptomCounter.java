package com.hemebiotech.symptomCounter;

import java.util.List;
import java.util.Map;

public interface SymptomCounter {

    Map<String, Integer> countSymptoms(List<String> symptoms);
    Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms);
}
