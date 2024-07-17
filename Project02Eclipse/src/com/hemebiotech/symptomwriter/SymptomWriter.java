package com.hemebiotech.symptomwriter;

import java.io.IOException;
import java.util.Map;

public interface SymptomWriter {
	void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
