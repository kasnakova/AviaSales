package com.aviasales.data;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Test;

import com.aviasales.models.Flight;
import com.aviasales.models.Person;

/**
 * 
 */

/**
 * @author ildarworld
 *
 */
public class StorageAdapterTest {

	/**
	 * Test method for {@link StorageAdapter#loadFlights()}.
	 * @throws IOException 
	 */
	@Test
	public void testLoadFlights() throws IOException {
		ArrayList<Flight> f = new ArrayList<Flight>();
		f = StorageAdapter.loadFlights();
		assert(10 == f.size());
	}

	/**
	 * Test method for {@link StorageAdapter#saveObject(java.util.ArrayList)}.
	 * @throws IOException 
	 */
	@Test
	public void testSaveObject() throws IOException {
		final String DB_FILES_PATH = "src/";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		LocalDateTime d = LocalDateTime.parse("25.07.2016 12:00", formatter);
		ArrayList<Flight> fs = new ArrayList<Flight>();	
		
		for (int i=0; i<10; i++){
			Flight f = new Flight("99A3", "LGW", "DMD", d, d, 123.4, 20);
			fs.add(f);
		}
		StorageAdapter.saveObject(fs);
		assert(1 == StorageAdapter.saveObject(fs));
	}

	/**
	 * Test method for {@link StorageAdapter#loadPerson(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testLoadPerson() throws IOException {
		ArrayList<Person> f = new ArrayList<Person>();
		f = StorageAdapter.loadPerson();
		assert(10 == f.size());
	}
}
