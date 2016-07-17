
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	private final static String DB_FILES_PATH = "AviaSales/src/";

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
	 * Writes flights to files
	 * @param flights the flights to be written to files
	 * @throws IOException 
	 */
	static void saveFlights(ArrayList<Flight> flights) throws IOException{
		  BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter(DB_FILES_PATH + "Flights.db"));
		  String tmp = "";
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		  for (Flight tf:flights) {
			  tmp = tf.getNumber() + ";" + tf.getDep() + ";" + tf.getArr()
					  + ";" + tf.getDepTime().format(formatter) + ";" + tf.getArrTime().format(formatter)
					  + ";" + tf.getCost() + ";" +tf.getNumberOfFreePlaces();
		    outputWriter.write(tmp);
		    outputWriter.newLine();
		    System.out.println(tmp);
		  }
		  outputWriter.flush();  
		  outputWriter.close();
		  
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
	
	/**
	 * Write a person's information to a file
	 * @param person the person's information to be saved to a file
	 */
	static void savePerson(Person person){
		
	}
	
}
