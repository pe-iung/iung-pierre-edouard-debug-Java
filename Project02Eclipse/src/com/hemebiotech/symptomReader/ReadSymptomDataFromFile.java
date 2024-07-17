package com.hemebiotech.symptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadSymptomDataFromFile implements SymptomReader {

	private String filepath;

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() throws IOException{
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}



}
