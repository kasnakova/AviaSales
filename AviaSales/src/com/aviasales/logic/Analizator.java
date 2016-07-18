package com.aviasales.logic;

import com.aviasales.models.Flight;
import com.aviasales.models.Route;
import com.aviasales.models.SearchParams;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

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
	@Test
	public void TestData() throws IOException {
		ArrayList<Flight> flights = getTestFlightData();
		assert (9 == flights.size());

	}

	@Test
	public void TestNumberFindedRoutes() throws IOException {

		SearchParams sp = getTestSearchParams();
		ArrayList<Route> Routes = searchFlights(sp);
		assert (Routes.size() == 2);
	}

	private static ArrayList<Route> result = new ArrayList<Route>();

	private static SearchParams getTestSearchParams() {
		SearchParams sp = new SearchParams("KAZAN", "KISLOVODSK", LocalDate.of(2016, Month.AUGUST, 14), 2);

		return sp;
	}

	private static ArrayList<Flight> getTestFlightData() throws IOException {

		ArrayList<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("2353", "KAZAN", "KISLOVODSK", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2345", "KAZAN", "MOSCOW", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2352", "MOSCOW", "KISLOVODSK", LocalDateTime.of(2016, Month.AUGUST, 14, 15, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 16, 0), 1000.0, 20));
		flights.add(new Flight("2346", "KAZAN", "NABEREZHNIE CHELNY", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2347", "KAZAN", "KRASNODAR", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2348", "KRASNODAR", "MOSCOW", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2349", "NABEREZHNIE CHELNY", "MOSCOW", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2350", "KISLOVODSK", "ROSTOV", LocalDateTime.of(2016, Month.AUGUST, 14, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2351", "KISLOVODSK", "KAZAN", LocalDateTime.of(2016, Month.AUGUST, 15, 12, 0),
				LocalDateTime.of(2016, Month.AUGUST, 15, 13, 0), 1000.0, 20));
		// ArrayList<Flight> flights2 = StorageAdapter.loadFlights();
		return flights;
	}

	public static ArrayList<Route> searchFlights(SearchParams sp) throws IOException {
		ArrayList<Flight> flights = getTestFlightData();
		
		String	dep=sp.getDep();
		String	arr=sp.getArr();
		LocalDate	depDate=sp.getDepDate();

		for (Flight f : flights) {
			if ((f.getDep() == dep) && (f.getDepTime().toLocalDate().isEqual(depDate)
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
		ArrayList<Flight> flights = getTestFlightData();

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
	    if((f1.getArr()==f2.getDep()) &&(f2.getDepTime().isAfter(minDate)) &&(f2.getDepTime().isBefore(maxDate))){
	    	return true;
	    }else{
	    	return false;
	    }
	  }
	
	  public static boolean isEndFlight(Flight f,String arr){
	    if (f.getArr()==arr)
	      return true;
	    else
	      return false;
	  }

}
