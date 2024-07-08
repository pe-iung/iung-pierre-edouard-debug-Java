package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface SymptomReader {
	List<String> getSymptoms();
	Map<String, Integer> countSymptoms(List<String> myDuplicatedSymptoms);
}
