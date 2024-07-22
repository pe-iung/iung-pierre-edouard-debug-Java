package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements SymptomWriter {

    private final String filepath;

    public WriteSymptomDataToFile(String filepath)  throws  IllegalArgumentException  {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        this.filepath = filepath;
    }

    /**
     * <p> write the symptoms in a text file
     *
     * @param symptoms the MAP of counted and sorted symptoms
     * @throws IOException
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
