package com.aviasales.models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.aviasales.data.StorageAdapter;

public class Booking {

	
	public ArrayList<Ticket> buyTickets(ArrayList<Person> person,Route route) throws IOException{
		
		reduceNumberOfFreeSeats(person,route);
		
		return null;
	}
	
	private ArrayList<Ticket> reduceNumberOfFreeSeats(ArrayList<Person> person,Route route) throws IOException{
		ArrayList<Flight> flights = StorageAdapter.loadFlights();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (Flight f : route.flights){
			
			Flight currFlight=	getFlightByNumber(flights,f.getNumber());
			currFlight.setNumberOfFreePlaces(currFlight.getNumberOfFreePlaces()-person.size());
			for (Person p:person) {
				Ticket ticket= new Ticket(LocalDateTime.now(),f, p); 
			}
		}
		
			StorageAdapter.saveObject(flights);
			StorageAdapter.saveObject(tickets);
		return tickets;
	}
	private Flight getFlightByNumber(ArrayList<Flight> flights,String flightNumber){
		for(Flight f : flights){
			if (f.getNumber()==flightNumber){
				return f; 
			}
		}
		return null;
	}
	
}
