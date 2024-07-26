package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * class WriteSymptomDataToFile implementing SymptomWriter
 * to write the result data in an output file
 */

public class WriteSymptomDataToFile implements SymptomWriter {

    private final String filepath;

    /**
     *   constructor for WriteSymptomDataToFile implementing SymptomWriter
     *
     * @param filepath the MAP of counted and sorted symptoms
     * @throws IllegalArgumentException if filepath is null or blank
     */

    public WriteSymptomDataToFile(String filepath)  throws  IllegalArgumentException  {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        this.filepath = filepath;
    }

    /**
     * write the symptoms in a text file
     *
     * @param symptoms the MAP of counted and sorted symptoms
     * @throws IOException when writing in result file
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        FileWriter writer = new FileWriter(this.filepath);
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        writer.close();
    }
}
