
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains the algorithm for finding suitable routes depending on search
 * parameters
 * 
 * @author ildarworld
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
	 */
	@Test
	public void TestData() {
		ArrayList<Flight> flights = getTestFlightData();
		assert (7 == flights.size());

	}

	@Test
	public void Test() {
		ArrayList<Flight> flights = getTestFlightData();
		SearchParams sp = getTestSearchParams();
		ArrayList<Route> Routes = searchFlights(sp, flights);
		System.out.println(Routes.size());
		assert (Routes.size() == 0);

	}

	private ArrayList<Route> result = new ArrayList<Route>();
	private ArrayList<Flight> currentRouteList = new ArrayList<Flight>();

	private SearchParams getTestSearchParams() {
		SearchParams sp = new SearchParams("Казань", "Кисловодск", LocalDate.of(2016, Month.JANUARY, 14), null, false,
				2);

		return sp;
	}

	private ArrayList<Flight> getTestFlightData() {

		ArrayList<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("2345", "Казань", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2346", "Казань", "Набережные Челны", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2347", "Казань", "Краснодар", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2348", "Краснодар", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2349", "Набережные Челны", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2350", "Кисловодск", "Ростов", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2351", "Кисловодск", "Москва", LocalDateTime.of(2016, Month.JANUARY, 14, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 15, 12, 0), 1000.0, 20));
		flights.add(new Flight("2352", "Москва", "Кисловодск", LocalDateTime.of(2016, Month.JANUARY, 16, 12, 0),
				LocalDateTime.of(2016, Month.JANUARY, 18, 12, 0), 1000.0, 20));
		return flights;
	}

	public ArrayList<Route> searchFlights(SearchParams sp, ArrayList<Flight> flights) {
		ArrayList<Flight> suitableFlights = new ArrayList<Flight>();

		for (Flight f : flights) {
			if ((f.getDep() == sp.getDep()) && (f.getDepTime().toLocalDate().isEqual(sp.getDepDate()))) {
				if (f.isEndFlight(sp)) {

					Route route = new Route(currentRouteList);
					route.flights.add(f);
					result.add(route);
				} else {
					suitableFlights.add(f);
				}

				// currentRouteList
			}

		}
		return result;
	}

}
