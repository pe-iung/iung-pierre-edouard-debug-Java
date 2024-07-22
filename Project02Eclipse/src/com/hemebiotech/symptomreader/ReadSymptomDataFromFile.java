package com.hemebiotech.symptomreader;

import com.hemebiotech.symptomwriter.WriteSymptomDataToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements SymptomReader {

    private final String filepath;

    /** <p> constructor for ReadSymptomDataFromFile implementing SymptomWriter
     *
     * @param filepath indicates the path to the input file to read
     * @throws IllegalArgumentException if filepath is null or blank
     */
    public ReadSymptomDataFromFile(String filepath) throws  IllegalArgumentException {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        this.filepath = filepath;
    }

    /** <p> getSymptoms method read the symptoms from a file
     *
     * @return a List of symptoms as Strings, this list may have some duplicates symptoms
     * @throws Exception if issues raised while reading the symptoms
     */
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
