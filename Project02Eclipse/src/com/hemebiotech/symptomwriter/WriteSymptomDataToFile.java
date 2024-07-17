package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements SymptomWriter {

    private String filepath;

    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }

    /**
     * <p> write the symptoms in a text file
     *
     * @param symptoms the MAP of counted and sorted symptoms
     * @return a Map of counted (but unsorted) <symptoms,count>
     * this Map will not be sorted alphabetically yet
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        if (filepath != null) {

            try {
                FileWriter writer = new FileWriter(this.filepath);
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
