package com.aviasales.tests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import com.aviasales.logic.Analizator;
import com.aviasales.models.Flight;
import com.aviasales.models.Route;
import com.aviasales.models.SearchParams;

public class AnalizatorTest {
	
	
	@Test
	public void TestData() throws IOException {
		ArrayList<Flight> flights = getTestFlightData();
		assert (9 == flights.size());

	}

	@Test
	public void TestNumberFindedRoutes() throws IOException {

		SearchParams sp = getTestSearchParams();
		ArrayList<Route> Routes = Analizator.searchFlights(sp);
		assert (Routes.size() == 2);
	}
	
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
		return flights;
	}

}
