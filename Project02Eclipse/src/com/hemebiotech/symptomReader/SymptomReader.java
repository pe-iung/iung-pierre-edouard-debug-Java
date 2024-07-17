package com.hemebiotech.symptomReader;

import java.io.IOException;
import java.util.List;

public interface SymptomReader {
	List<String> getSymptoms() throws IOException;
}
