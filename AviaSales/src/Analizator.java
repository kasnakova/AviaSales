import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
		ArrayList<Flight2> flights = getTestFlightData();
		assert (7 == flights.size());

	}

	@Test
	public void Test() {
		ArrayList<Flight2> flights = getTestFlightData();
		SearchParams sp = getTestSearchParams();
		ArrayList<Route> Routes = searchFlights(sp, flights);
		System.out.println(Routes.size());
		assert (Routes.size() ==0);

	}
	
	private ArrayList<Route> result = new ArrayList<Route>();
	private ArrayList<Flight2> currentRouteList= new ArrayList<Flight2>();

	private SearchParams getTestSearchParams() {
		SearchParams sp = new SearchParams();
		sp.fromAirport = "Казань";
		sp.toAirport = "Кисловодск";
		sp.personCount = 2;
		sp.toDate = asLocalDate("11.01.2016");
		return sp;
	}

	private ArrayList<Flight2> getTestFlightData() {

		ArrayList<Flight2> flights = new ArrayList<Flight2>();
		flights.add(new Flight2("Казань", "Москва", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Казань", "Набережные Челны", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Казань", "Краснодар", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Краснодар", "Москва", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Набережные Челны", "Москва", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Кисловодск", "Ростов", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Кисловодск", "Москва", LocalDateTime.of(2016,Month.JANUARY, 14,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 15,12,0),20));
		flights.add(new Flight2("Москва","Кисловодск", LocalDateTime.of(2016,Month.JANUARY, 16,12,0),
				LocalDateTime.of(2016,Month.JANUARY, 18,12,0),20));
		return flights;
	}

	private LocalDate asLocalDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}

	
	public ArrayList<Route> searchFlights(SearchParams sp, ArrayList<Flight2> flights) {
		ArrayList<Flight2> suitableFlights= new ArrayList<Flight2>();
		
		for(Flight2 f:flights){
			if ((f.aeroport1==sp.fromAirport)&& (f.date1.toLocalDate().isEqual(sp.toDate))){
				if (f.isEndFlight(sp)) {
					
					Route route=new Route(new ArrayList<Flight>());//ToDO
					//Route route=new Route(currentRouteList);
					// route.flights;
					result.add(route);
				}
				suitableFlights.add(f);
				
			}
			
		}
		
		
		return result;
	}

}
