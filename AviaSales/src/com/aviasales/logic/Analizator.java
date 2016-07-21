package com.aviasales.logic;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.aviasales.data.StorageAdapter;
import com.aviasales.models.Flight;
import com.aviasales.models.Route;
import com.aviasales.models.SearchParams;

/**
 * Contains the algorithm for finding suitable routes depending on search
 * parameters
 * 
 * @author Stepanov Vyacheslav
 *
 */

public class Analizator {
	/**
	 * Searches the available flights and finds the ones that fulfill the search
	 * criteria
	 * 
	 * @param sp
	 *            the search parameters
	 * @param flights
	 *            the available flights
	 * @return
	 * @return
	 * @throws IOException
	 */
	

	private static ArrayList<Route> result = new ArrayList<Route>();



	
	public static ArrayList<Route> searchFlights(SearchParams sp) throws IOException {
		ArrayList<Flight> flights = StorageAdapter.loadFlights();
		String	dep=sp.getDep();
		String	arr=sp.getArr();
		LocalDate	depDate=sp.getDepDate();

		for (Flight f : flights) {
			if ((f.getDep().toLowerCase().equals(dep.toLowerCase())) && (f.getDepTime().toLocalDate().isEqual(depDate)
					&&(f.getNumberOfFreePlaces() >= sp.getPersonCount()))) {

				if (isEndFlight(f,arr)) {
					Analizator.result.add(new Route(f));

				} else {
					SearchConnectedFlights(f, arr,sp.getPersonCount());
				}
			}
		}
		
		return result;
	}

	private static void SearchConnectedFlights(Flight flight,String arr,int personCount) throws IOException {
		ArrayList<Flight> flights = StorageAdapter.loadFlights();
		
		for (Flight f : flights) {
			if ((isConnectingFlight(flight,f)) && (f.getNumberOfFreePlaces() >= personCount)) {
				if (isEndFlight(f,arr)) {
					Route route = new Route(flight);
					route.flights.add(f);
					Analizator.result.add(route);
				}
			}
		}
	}
	public static boolean isConnectingFlight(Flight f1,Flight f2){
	    LocalDateTime minDate = f1.getArrTime().plusHours(1);
	    LocalDateTime maxDate = f1.getArrTime().plusHours(9);
	    if((f1.getArr().toLowerCase().equals(f2.getDep().toLowerCase())) &&(f2.getDepTime().isAfter(minDate)) &&(f2.getDepTime().isBefore(maxDate))){
	    	return true;
	    }else{
	    	return false;
	    }
	  }
	
	  public static boolean isEndFlight(Flight f,String arr){
	    if (f.getArr().toLowerCase().equals(arr.toLowerCase()))
	      return true;
	    else
	      return false;
	  }

}
