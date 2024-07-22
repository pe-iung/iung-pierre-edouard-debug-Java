package com.hemebiotech.symptommanager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SymptomManager {

    List<String> getSymptoms() throws Exception;

    Map<String, Integer> countSymptoms(List<String> symptoms);

    Map<String, Integer> sortSymptoms(Map<String, Integer> unsortedSymptoms);

    void writeSymptoms(Map<String, Integer> symptoms) throws Exception;


}

