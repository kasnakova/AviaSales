package com.aviasales.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides methods for validating user input
 * 
 * @author Liza
 */
public class UserInputValidator {
	/**
	 * The maximum count of people that can fly on one plane The number is based
	 * on information about the biggest existing plane:
	 * http://www.english-online.at/travel/airbus-380/airbus-380-largest-plane.
	 * htm
	 */
	private static final int MAXIMUM_PASSANGERS_COUNT = 850;

	public static boolean isNullOrEmpty(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPersonCountValid(String personCountInput) {
		try {
			int personCount = Integer.parseInt(personCountInput);
			if (personCount > 0 && personCount <= MAXIMUM_PASSANGERS_COUNT) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isCostValid(String costStr) {
		try {
			double cost = Double.parseDouble(costStr);
			if (cost > 0) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDateValid(String dateStr) {
		try {
			LocalDate date = Utils.parseToLocalDate(dateStr);
			LocalDate now = LocalDate.now();
			if (date.compareTo(now) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static boolean isDateTimeValid(String dateStr) {
		try {
			LocalDateTime date = Utils.parseToLocalDateTime(dateStr);
			LocalDateTime now = LocalDateTime.now();
			if (date.compareTo(now) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static boolean isBirthdayValid(String birthday) {
		try {
			LocalDate date = Utils.parseToLocalDate(birthday);
			LocalDate now = LocalDate.now();
			if (date.compareTo(now) <= 0) {
				return true;
			} else {
				return false;
			}
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static boolean isEmailValid(String email) {
		if (isNullOrEmpty(email)) {
			return false;
		}

		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isPhoneNumberValid(String phone) {
		if (isNullOrEmpty(phone)) {
			return false;
		}

		Pattern pattern = Pattern.compile("\\+?[0-9]{10,20}");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
}
