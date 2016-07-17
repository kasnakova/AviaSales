import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
		flights.add(new Flight2("Казань", "Москва", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		flights.add(new Flight2("Казань", "Набережные Челны", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		flights.add(new Flight2("Казань", "Краснодар", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		flights.add(new Flight2("Краснодар", "Москва", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		flights.add(new Flight2("Набережные Челны", "Москва", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		flights.add(new Flight2("Кисловодск", "Ростов", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		flights.add(new Flight2("Кисловодск", "Москва", asDate("11.01.2016 14:12:13"),
				asDate("11.01.2016 15:12:13"),20));
		return flights;
	}

	private LocalDate asLocalDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}

	private Date asDate(String stringDate) {

		String stringDateFormat = "dd.MM.yyyy HH:mm:ss";
		DateFormat format = new SimpleDateFormat(stringDateFormat, Locale.ENGLISH);
		try {
			Date date = (Date) format.parse(stringDate);
			return date;
		} catch (Exception e) {
			return null;
			// handle exception;
		}
	}

	public ArrayList<Route> searchFlights(SearchParams sp, ArrayList<Flight2> flights) {
		
		@SuppressWarnings("unused")
		List<Flight2> suitableFlights = (List) flights.stream()
				.filter(u -> u.aeroport1 == sp.fromAirport 
				&& u.numberOfFreeSeats >= sp.personCount  
						//&& s.toDate<u.date1
						)
				.collect(Collectors.toList());
		

		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
		cal.getTime(); // returns new date object, one hour in the future

		return null;
	}

}
