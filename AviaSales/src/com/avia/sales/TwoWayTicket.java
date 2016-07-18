package com.avia.sales;

import java.time.LocalDateTime;



/**
 * Information about a two-way flight ticket
 * @author ildarworld
 *
 */
public class TwoWayTicket extends Ticket{
	private Flight returnFlight;

	public TwoWayTicket(int ticketNumber, LocalDateTime ticketDate, Flight flight, String bookingCode, Person person, Flight returnFlight) {
		super(ticketNumber, ticketDate, flight, bookingCode, person);
		setReturnFlight(returnFlight);
		// TODO Auto-generated constructor stub
	}

	public Flight getReturnFlight() {
		return returnFlight;
	}

	@Override
	public String toString() {
		String resultString = super.toString();
		resultString = resultString.substring(0, resultString.length()-2);
		return resultString + ", returnFlight=" + returnFlight + "]";
	}

	public void setReturnFlight(Flight returnFlight) {
		this.returnFlight = returnFlight;
	}
}
