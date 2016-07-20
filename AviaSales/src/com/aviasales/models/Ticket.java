package com.aviasales.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.aviasales.interfaces.Savable;

public class Ticket implements Savable {
	private String ticketNumber;
	private LocalDateTime ticketDate;
	private Flight flight;
	private String bookingCode;
	private Person person;

	public String getTicketNumber() {
		return ticketNumber;
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

	public Ticket(LocalDateTime ticketDate, Flight flight, Person person) {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

		// super();
		this.ticketNumber = randomUUIDString;
		this.ticketDate = ticketDate;
		this.flight = flight;
		this.person = person;
	}

	@Override
	public String makeSavebleString() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");
		String result = getTicketNumber() + ";" + getTicketDate().format(formatter) + ";" + getFlight().getNumber()
				+ ";" + getPerson().getPassportNumber();

		return result;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return "Ticket";
	}
}
