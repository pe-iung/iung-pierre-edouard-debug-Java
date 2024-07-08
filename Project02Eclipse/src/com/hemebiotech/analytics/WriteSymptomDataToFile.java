package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements SymptomWriter {

    public WriteSymptomDataToFile () {}

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        try {
            FileWriter writer = new FileWriter("result.out"); // TODO add this filepath to the methode arguments
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
