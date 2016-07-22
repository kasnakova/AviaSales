package com.aviasales.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Provides some common methods needed throughout the project
 * 
 * @author Liza
 */
public class Utils {
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	public static LocalDate parseToLocalDate(String dateStr) {
		LocalDate date = LocalDate.parse(dateStr, dateFormatter);
		return date;
	}

	public static LocalDateTime parseToLocalDateTime(String dateStr) {
		LocalDateTime date = LocalDateTime.parse(dateStr, dateTimeFormatter);
		return date;
	}

	public static String parseDateToString(LocalDate date) {
		return date.format(dateFormatter);
	}

	public static String parseDateTimeToString(LocalDateTime date) {
		return date.format(dateTimeFormatter);
	}
}
