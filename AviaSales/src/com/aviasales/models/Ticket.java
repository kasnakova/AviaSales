package com.aviasales.models;
import java.time.LocalDateTime;

public class Ticket implements Savable{
	private String ticketNumber;
	private LocalDateTime ticketDate;
	private Flight flight;
	private String bookingCode;
	private Person person;
	
	public int getTicketNumber() {
		return ticketNumber;
	}

	private void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public LocalDateTime getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(LocalDateTime ticketDate) {
		this.ticketDate = ticketDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", ticketDate=" + ticketDate + ", flight=" + flight.toString()
				+ ", bookingCode=" + bookingCode + ", person=" + person.toString() + "]";
	}
	
	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Ticket(int ticketNumber, LocalDateTime ticketDate, Flight flight, String bookingCode, Person person) {
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		
		super();
		this.ticketNumber = randomUUIDString;
		this.ticketDate = ticketDate;
		this.flight = flight;
		this.bookingCode = bookingCode;
		this.person = person;
	}
}
