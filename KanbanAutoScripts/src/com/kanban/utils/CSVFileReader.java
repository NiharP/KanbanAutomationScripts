package com.kanban.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kanban.beans.TestDataStructure;

public class CSVFileReader {
	private static BufferedReader reader = null;

	public static List<TestDataStructure> getTestData(String ccaType) {
		ArrayList<TestDataStructure> testData = new ArrayList<TestDataStructure>();
		try {
			reader = new BufferedReader(new FileReader(
					"src//testData//TariffsDeviceExtras.csv"));
			String readLine;
			

			while ((readLine = reader.readLine()) != null) {
				String data[] = readLine.split(",");

				if (ccaType.equalsIgnoreCase(data[0])) {
					TestDataStructure dataStructure = new TestDataStructure();
					dataStructure.setTariff(data[1]);
					dataStructure.setDevice(data[2]);
					dataStructure.setExtra(data[3]);
					
					testData.add(dataStructure);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return testData;
	}
}
