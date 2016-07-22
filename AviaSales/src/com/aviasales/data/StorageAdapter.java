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
import java.util.List;
import java.util.StringTokenizer;

/**
 * Takes care of loading and saving information to files
 * 
 * @author ildarworld
 *
 */

public class StorageAdapter<T> {
	/**
	 * Reads all files with flights
	 * 
	 * @return all flights from the files
	 * @throws IOException
	 */
	private final static String DB_FILES_PATH = "../AviaSalesDb/";
	private static ArrayList<Flight> flights;
	private static ArrayList<Person> persons;

	public static ArrayList<Flight> loadFlights() throws IOException {

		flights = new ArrayList<Flight>();

		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + "Flights.db"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null && !line.equals("")) {
				sb.append(line);
				sb.append("\n");

				Flight cf = Flight.getObjectFromString(line);
				if (cf != null) {
					flights.add(cf);
				}

				line = br.readLine();

			}
			return flights;

		} finally {
			br.close();
		}

	}

	/**
	 * Adds a new flight entered from an administrator to the current list of
	 * flights and then saves them to the file
	 * 
	 * @param flight
	 *            The flight to be added
	 * @return true if adding is successful, false otherwise
	 */
	public static boolean addFlight(Flight flight) {
		try {
			loadFlights();
			flights.add(flight);
			return saveObject(flights);
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * save array list of child of Savable interface to file
	 * 
	 * @param objects
	 * @return
	 */
	public static <T extends Savable> boolean saveObject(ArrayList<T> objects) {

		BufferedWriter outputWriter = null;
		if (objects.isEmpty())
			return true;
		try {
			outputWriter = new BufferedWriter(new FileWriter(DB_FILES_PATH + objects.get(0).getClassName() + ".db"));

			for (int i = 0; i < objects.size(); i++) {
				outputWriter.write(objects.get(i).makeSavebleString());
				outputWriter.newLine();
			}
			outputWriter.flush();
			outputWriter.close();

			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Reads a person's information from a file
	 * 
	 * @param email
	 *            determines who is the person
	 * @return the person information
	 * @throws IOException
	 */
	public static ArrayList<Person> loadPerson() throws IOException {
		persons = new ArrayList<Person>();

		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + "Person.db"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null && !line.equals("")) {
				sb.append(line);
				sb.append("\n");
				Person p = Person.getObjectFromString(line);
				line = br.readLine();
				persons.add(p);
			}
		} finally {
			br.close();
		}
		return persons;
	}

	public static boolean saveFlights() {
		return saveObject(flights);
	}

	/**
	 * Check if there is any personal info saved for a person with the provided
	 * email
	 * 
	 * @param email
	 *            the provided email
	 * @return the person, containing the rest of his info
	 */
	public static Person getPersonByEmail(String email) {
		Person result = null;

		if (loadPeople()) {
			for (Person p : persons) {
				if (email.equals(p.getEmail())) {
					result = p;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Adding the personal information to our database
	 * 
	 * @param person
	 *            the personal information
	 * @return true if adding is successful, false otherwise
	 */
	public static boolean addPerson(Person person) {
		if (loadPeople()) {
			persons.add(person);
			saveObject(persons);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add a range of people's personal information to our database
	 * @param people the people's information to be added
	 * @return true if adding is successful, false otherwise
	 */
	public static boolean addPeople(List<Person> people) {
		if (loadPeople()) {
			persons.addAll(people);
			saveObject(persons);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Load all the people's personal information that we have from our database
	 * @return true if loading was successful, false otherwise
	 */
	private static boolean loadPeople() {
		if (persons == null) {
			try {
				persons = loadPerson();
			} catch (IOException e) {
				return false;
			}
		}

		return true;
	}
}
