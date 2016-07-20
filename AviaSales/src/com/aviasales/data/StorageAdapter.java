package com.aviasales.data;

import com.aviasales.interfaces.Savable;
import com.aviasales.models.Flight;
import com.aviasales.models.Person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Takes care of loading and saving information to files
 * @author ildarworld
 *
 */



public class StorageAdapter<T> {
	/**
	 * Reads all files with flights
	 * @return all flights from the files
	 * @throws IOException 
	 */
	private final static String DB_FILES_PATH = "src/com/aviasales/data/";
	private static ArrayList<Flight> flights;
	private static ArrayList<Person> persons;
	
	/*static void loadObjects(ArrayList<Savable> objects, String className) throws IOException {
		// ArrayList<Savable> objects = new ArrayList<Savable>();
		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + className + ".db"));
		try {

			String line = br.readLine();
			while (line != null) {
				objects.add(Savable.getObjectFromString(line));
			}

			// return objects;
		} finally {

			System.out.println("LOAD IS FINISHED ");
			br.close();
		}
	}*/
	
	public static ArrayList<Flight> loadFlights() throws IOException {

		flights = new ArrayList<Flight>();

		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + "Flights.db"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");

				Flight cf = Flight.getObjectFromString(line);
				flights.add(cf);

				line = br.readLine();

			}
			return flights;

		} finally {

			System.out.println("LOAD IS FINISHED ");
			br.close();
		}

	}

	/**
	 * save array list of child of Savable interface to file
	 * @param objects
	 * @throws IOException
	 * @return 
	 */
	public static int saveObject(ArrayList<Savable> objects) throws IOException{
		  
		BufferedWriter outputWriter = null;
		if (objects.isEmpty())
			return 0;
		try {

			outputWriter = new BufferedWriter(new FileWriter(DB_FILES_PATH + objects.get(0).getClassName() + ".db"));

			System.out.println(DB_FILES_PATH + objects.get(0).getClassName() + ".db");

			for (Savable tf : objects) {
				outputWriter.write(tf.makeSavebleString());
				outputWriter.newLine();
				System.out.println(tf.makeSavebleString());
			}
			outputWriter.flush();
			outputWriter.close();

			return 1;

		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * Reads a person's information from a file
	 * @param email determines who is the person 
	 * @return the person information
	 * @throws IOException 
	 */
	public static ArrayList<Person> loadPerson() throws IOException{
		persons = new ArrayList<Person>();
		
		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + "Persons.db"));

	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            Person p = Person.getObjectFromString(line);
	            line = br.readLine();
	            persons.add(p);
	        }
	    } finally {
	    	
	    	System.out.println("LOAD IS FINISHED ");
	        br.close();
	    }
		return persons;
	}
	
}
