package com.hemebiotech.symptomreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReadSymptomDataFromFile implements SymptomReader {

    private final String filepath;

    public ReadSymptomDataFromFile(String filepath) throws  IllegalArgumentException {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        this.filepath = filepath;
    }


    @Override
    public List<String> getSymptoms() throws Exception {
        List<String> result = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();

            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
            reader.close();


            return result;

    }


}
