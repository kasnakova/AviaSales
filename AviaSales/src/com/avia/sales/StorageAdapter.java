package com.avia.sales;

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
	private final static String DB_FILES_PATH = "src/";
	
	static ArrayList<Savable> loadObjects(String className) throws IOException{
		ArrayList<Savable> objects = new ArrayList<Savable>();
		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + className + ".db"));
	    try {
	    	
	        //StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null){
	        	objects.add(Savable.getObjectFromString(line));
	        }
	        
	        return objects;
	    } finally {
	    	
	    	System.out.println("LOAD IS FINISHED ");
	        br.close();
	    }
	}
	
	static ArrayList<Flight> loadFlights() throws IOException{

		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		BufferedReader br = new BufferedReader(new FileReader(DB_FILES_PATH + "Flights.db"));

	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            
	           StringTokenizer st = new StringTokenizer(line,";");
			   while(st.hasMoreTokens()){
					int  numberOfFreePlaces;
					double cost;
					String number, dep, arr;
					LocalDateTime depTime, arrTime;
			        
			        number = st.nextElement().toString();
			        dep = st.nextElement().toString();
			        arr = st.nextElement().toString();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			        depTime = LocalDateTime.parse(st.nextElement().toString(), formatter);
			        if (depTime.isBefore(LocalDateTime.now()))
			        	continue;
			        arrTime = LocalDateTime.parse(st.nextElement().toString(), formatter);
			        cost = Double.valueOf(st.nextElement().toString());
			        numberOfFreePlaces = Integer.parseInt(st.nextElement().toString());
			        
			        Flight cf = new Flight(number, dep, arr, depTime, arrTime, cost, numberOfFreePlaces);
			        flights.add(cf);
			        System.out.println(cf.toString());
			   }
	           
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
	static int saveObject(ArrayList<Savable> objects) throws IOException{
		  
		BufferedWriter outputWriter = null;
		  if (objects.isEmpty())
			  return 0;
		  try
		  {
			  
			  outputWriter = new BufferedWriter(new FileWriter(DB_FILES_PATH + objects.get(0).getClassName() +".db"));
			 
			  System.out.println(DB_FILES_PATH + objects.get(0).getClassName() +".db");
			  
			  for (Savable tf:objects) {
			    outputWriter.write(tf.makeSavebleString());
			    outputWriter.newLine();
			    System.out.println(tf.makeSavebleString());
			  }
			  outputWriter.flush();  
			  outputWriter.close();
			  
			  return 1;
			  
		  }catch(Exception e){
			  return -1;
		  }
	}
	
	/**
	 * Reads a person's information from a file
	 * @param email determines who is the person 
	 * @return the person information
	 */
	static ArrayList<Person> loadPerson(String email){
		ArrayList<Person> persons = new ArrayList<Person>();
		
		return null;
	}
	
}
