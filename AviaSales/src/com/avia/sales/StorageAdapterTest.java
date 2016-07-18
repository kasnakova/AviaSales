package com.avia.sales;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Test;

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
		ArrayList<Savable> fs = new ArrayList<Savable>();	
		
		for (int i=0; i<10; i++){
			Flight f = new Flight("99A3", "LGW", "DMD", d, d, 123.4, 20);
			fs.add(f);
		}
		StorageAdapter.saveObject(fs);
		assert(1 == StorageAdapter.saveObject(fs));
		
	}

	/**
	 * Test method for {@link StorageAdapter#loadPerson(java.lang.String)}.
	 */
	@Test
	public void testLoadPerson() {
		fail("Not yet implemented");
	}

	@Test public void testLoadObjects() throws IOException{
		ArrayList<Savable> s = StorageAdapter.loadObjects("Flight");
		ArrayList<Flight> f = new ArrayList<Flight>();
		for(Savable flight:s){
			f.add((Flight) flight);
		}
		for(Flight fl:f)
			System.out.println(fl.toString());
		System.out.println(f.size());
		assert(f.size() == 10);
		
	}
	
}
