package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Country;
import model.CountryData;

public class Main {
	
	public static void main(String[] args) throws IOException {
		CountryData data = new CountryData();
		
		File file = new File("input/test.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		
		String line = "";
		
		line = reader.readLine();
		int n = Integer.parseInt(line);
		
		for(int i = 0; i < n; i++) {
			line = reader.readLine();
			String[] attributes = line.split(";");
			data.addCountry(new Country(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]),
					Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]), Integer.parseInt(attributes[6])));
		}
		
		reader.close();
		
		// Sort data and print the respective information
		data.sortMales();
		System.out.println(data.printMales());
		
		data.sortFemales();
		System.out.println(data.printFemales()); 
		
		data.sortAll();
		System.out.println(data.printAll());
	}
}
