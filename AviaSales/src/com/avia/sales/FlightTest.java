package com.avia.sales;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		
		Flight f = new Flight("99A3", "LGW", "DMD", LocalDateTime.parse("12.07.2016 12:15", formatter), 
				LocalDateTime.parse("12.07.2016 14:15", formatter), 123.4, 20);
		System.out.println(f.toString());
		assert(f.toString().trim().equals("Flight number: 99A3 Departure airport: LGW Arrive airport: DMD Departure time: 12.07.2016 12:15 Arrive time: 12.07.2016 14:15 Cost: 123.4"));
	
	}

	@Test 
	public void testIsConnectingFlight(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		Flight f = new Flight("99A3", "LGW", "DMD", LocalDateTime.parse("12.07.2016 12:15", formatter), 
				LocalDateTime.parse("12.07.2016 14:15", formatter), 123.4, 20);
		Flight f1 = new Flight("99A3", "DMD", "LGW", LocalDateTime.parse("12.07.2016 12:15", formatter), 
				LocalDateTime.parse("13.07.2016 14:15", formatter), 123.4, 20);
		assert(true == f.isConnectingFlight(f1));	
	}
	
	@Test
	public void testIsEndFlight()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		LocalDateTime d = LocalDateTime.parse("25.07.2016 12:00", formatter);
		Flight f = new Flight("99A3", "LGW", "DMD", d, d, 123.4, 20);
		f.toString();
		SearchParams s = new SearchParams("LGW", "DMD", d.toLocalDate() ,d.toLocalDate(), true, 3);
		
		System.out.println(f.isEndFlight(s));
		assert(f.isEndFlight(s)==true);
	}
	
	
}
