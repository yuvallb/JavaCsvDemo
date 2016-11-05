package org.b7hackaton2016.csvdemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

// this app will read a csv file, and write a new file with some extra data

public class App {
	public static void main(String[] args) throws IOException {

		if (args.length < 1) {
			System.out.println("Please enter name of CSV file to read");
			return;
		}
		final String inFileName = args[0];
		final String outFileName = inFileName.replaceAll(".csv", ".modified.csv");

		CSVReader reader = new CSVReader(new FileReader(inFileName));
		List<String[]> originalData = new ArrayList<String[]>();
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			originalData.add(nextLine);
			System.out.println("Reading :" + nextLine[0] + " , " + nextLine[1] + " , " + nextLine[3] + "...");
		}
		reader.close();

		CSVWriter writer = new CSVWriter(new FileWriter(outFileName), '\t');
		// feed in the array
		int i = 0;
		for (String[] entries : originalData) {
			entries[0] = "new data " + i++;
			writer.writeNext(entries);
		}
		String[] entries1 = new String[] { "111", "aaa", "bbb" };
		writer.writeNext(entries1);
		String[] entries2 = new String[] { "222", "foo", "bar" };
		writer.writeNext(entries2);

		writer.close();
	}
}
