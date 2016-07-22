package com.aviasales.logic;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.aviasales.data.StorageAdapter;
import com.aviasales.models.Flight;
import com.aviasales.models.Person;
import com.aviasales.models.Route;
import com.aviasales.models.Ticket;
import com.aviasales.utilities.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;

public class Booking {

	public boolean generateTickets(List<Person> person, Route route, String filePath) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (Flight flight : route.flights) {
			flight.setNumberOfFreePlaces(flight.getNumberOfFreePlaces() - person.size());
			for (Person p : person) {
				Ticket ticket = new Ticket(LocalDateTime.now(), flight, p);
				tickets.add(ticket);
				boolean success = generateTicket(ticket, filePath);
				if (!success) {
					return false;
				}
			}
		}

		boolean successSavingFlights = StorageAdapter.saveFlights();
		boolean successSavingTickets = StorageAdapter.saveObject(tickets);
		return successSavingFlights && successSavingTickets;
	}

	private boolean generateTicket(Ticket ticket, String path) {
		int distanceBetweenLines = 40;
		int size = 600;
		String key = "*********YOUR TICKET*************";
		BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, size, size);
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, size, distanceBetweenLines * 3);
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("Arial Black", Font.BOLD, 15));
		int yPosition = 20;
		graphics.drawString(key, 10, yPosition);

		// Ticket info
		String line = "Ticket number: " + ticket.getTicketNumber();
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = "Ticket date: " + Utils.parseDateTimeToString(ticket.getTicketDate());
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);

		// Flight info
		Flight flight = ticket.getFlight();
		line = "Flight number: " + flight.getNumber();
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = String.format("Cost: %.2f", flight.getCost());
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = "Departure airport: " + flight.getDep();
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = "Departure time: " + Utils.parseDateTimeToString(flight.getDepTime());
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = "Arrival airport: " + flight.getArr();
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = "Arrival time: " + Utils.parseDateTimeToString(flight.getArrTime());
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);

		// Personal info
		Person person = ticket.getPerson();
		graphics.drawLine(0, yPosition + 5, size, yPosition + 5);
		line = "Full name: " + person.getFirstName() + " " + person.getSerName();
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);
		line = "Passport number: " + person.getPassportNumber();
		yPosition += distanceBetweenLines;
		graphics.drawString(line, 10, yPosition);

		return saveTicket(bufferedImage, ticket, path);
	}

	private boolean saveTicket(BufferedImage bufferedImage, Ticket ticket, String path) {
		try {
			String username = ticket.getPerson().getEmail().substring(0, ticket.getPerson().getEmail().indexOf("@"));
			File file = new File(String.format("%s_%s_%s_%s.jpg", path, username,
					ticket.getFlight().getDep().toUpperCase(), ticket.getFlight().getArr().toUpperCase()));
			int i = 1;
			while (file.exists()) {
				file = new File(String.format("%s_%s_%s_%s_%d.jpg", path, username,
						ticket.getFlight().getDep().toUpperCase(), ticket.getFlight().getArr().toUpperCase(), (i + 1)));
			}

			ImageIO.write(bufferedImage, "jpg", file);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
