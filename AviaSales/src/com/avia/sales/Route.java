package com.avia.sales;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

/**
 * Information about all flights in a certain route
 * 
 * @author Stepanov Vyacheslav
 *
 */

public class Route {
	
	ArrayList<Flight> flights=new ArrayList<Flight>();
	ArrayList<Flight> returnFlights=new ArrayList<Flight>();

	private double cost;

	public Route(ArrayList<Flight> flights) {
		for(Flight f:flights){
			this.flights.add(f);
		}
		
		calculateTotalCost();
	}
	public Route(Flight flight) {
		this.flights.add(flight);
		calculateTotalCost();
	}

	public double getPrice() {

		return cost;

	}

	public void setPrice(double cost) {

		this.cost = cost;

	}

	/**
	 * Calculates the total cost of all flights in the route
	 */
	private void calculateTotalCost() {
		//TO DO

	}
	@Override
	public String toString() {
		return "Route [flights=" + flights + ", cost=" + cost + "]";
	}

}
