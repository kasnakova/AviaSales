
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
		SearchParams sp = new SearchParams("Казань", "Кисловодск", LocalDate.of(2016, Month.JANUARY, 14), null, false,
				2);

		return sp;
	}

	private static ArrayList<Flight> getTestFlightData() throws IOException {

		ArrayList<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("2353", "Казань", "Кисловодск", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2345", "Казань", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2352", "Москва", "Кисловодск", LocalDateTime.of(2016, Month.JANUARY, 14, 15, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 16, 0), 1000.0, 20));

		flights.add(new Flight("2346", "Казань", "Набережные Челны", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2347", "Казань", "Краснодар", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2348", "Краснодар", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2349", "Набережные Челны", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2350", "Кисловодск", "Ростов", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 14, 13, 0), 1000.0, 20));
		flights.add(new Flight("2351", "Кисловодск", "Казань", LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 13, 0), 1000.0, 20));
		//ArrayList<Flight> flights2 = StorageAdapter.loadFlights();
		return flights;
	}

	public static ArrayList<Route> searchFlights(SearchParams sp) throws IOException {
		ArrayList<Flight> flights = getTestFlightData();
		
		for (Flight f : flights) {
			if ((f.getDep() == sp.getDep()) && (f.getDepTime().toLocalDate().isEqual(sp.getDepDate()))) {
				
				if (f.isEndFlight(sp)) {
					
					//Route route = new Route(f);
					Analizator.result.add(new Route(f));
					//System.out.println("finded route without stops");
				} else {
					
					SearchConnectedFlights(f, sp);
					//System.out.println("searching connecting flight for " + f.toString());
				}

			} else {
				//System.out.println(f.toString() + " don't suit");
			}

		}
		//System.out.println("finded " + Analizator.result.size() + " routes");
		return result;

	}

	private static void SearchConnectedFlights(Flight flight, SearchParams sp) throws IOException {
		ArrayList<Flight> flights = getTestFlightData();
		
		for (Flight f : flights) {
			if ((flight.isConnectingFlight(f)) && (f.getNumberOfFreePlaces() >= sp.getPersonCount())) {
				if (f.isEndFlight(sp)) {

					Route route = new Route(flight);
					route.flights.add(f);
					
					Analizator.result.add(route);
				} else {
					//nothing to do
					//SearchConnectedFlights(f, sp);  - searching routes with more then 1 connections 
					//                                  will be implemented in the nearest future
					
				}
			}
		}
	}

}
