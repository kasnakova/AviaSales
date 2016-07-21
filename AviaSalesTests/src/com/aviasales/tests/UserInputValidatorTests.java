package com.aviasales.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import com.aviasales.utilities.UserInputValidator;
import com.aviasales.utilities.Utils;

public class UserInputValidatorTests {
	@Test
	public void validateNullInput() {
		String input = null;
		boolean expected = true;
		boolean actual = UserInputValidator.isNullOrEmpty(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateEmptyInput() {
		String input = "";
		boolean expected = true;
		boolean actual = UserInputValidator.isNullOrEmpty(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateCorrectInput() {
		String input = "test";
		boolean expected = false;
		boolean actual = UserInputValidator.isNullOrEmpty(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateNegativePersonCount() {
		String input = "-56";
		boolean expected = false;
		boolean actual = UserInputValidator.isPersonCountValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateZeroPersonCount() {
		String input = "0";
		boolean expected = false;
		boolean actual = UserInputValidator.isPersonCountValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateBeyondMaximumPersonCount() {
		String input = "1000";
		boolean expected = false;
		boolean actual = UserInputValidator.isPersonCountValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateNonNumberPersonCount() {
		String input = "bla";
		boolean expected = false;
		boolean actual = UserInputValidator.isPersonCountValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateCorrectPersonCount() {
		String input = "5";
		boolean expected = true;
		boolean actual = UserInputValidator.isPersonCountValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateInIncorrectFormat() {
		String input = "20-07-2016";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateWithIncorrectDay() {
		String input = "57/07/2016";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateWithIncorrectMonth() {
		String input = "20/30/2016";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateWithIncorrectYear() {
		String input = "20/07/-2016";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateEmptyDate() {
		String input = "";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateAlreadyPassedDate() {
		String input = "20/07/2011";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateCorrectDate() {
		String input = Utils.parseToString(LocalDate.now());
		boolean expected = true;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateNegativeCost() {
		String input = "-56.45";
		boolean expected = false;
		boolean actual = UserInputValidator.isCostValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateZeroCost() {
		String input = "0";
		boolean expected = false;
		boolean actual = UserInputValidator.isCostValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateNonNumberCost() {
		String input = "bla";
		boolean expected = false;
		boolean actual = UserInputValidator.isCostValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateCorrectCost() {
		String input = "56.7";
		boolean expected = true;
		boolean actual = UserInputValidator.isCostValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateTimeInIncorrectFormat() {
		String input = "20/07/2016 12-45";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateTimeValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateTimeWithIncorrectHour() {
		String input = "07/07/2016 45:45";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateTimeValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateDateTimeWithIncorrectMinutes() {
		String input = "07/07/2016 11:89";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateTimeValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateEmptyDateTime() {
		String input = "";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateTimeValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateAlreadyPassedDateTime() {
		String input = "20/07/2011";
		boolean expected = false;
		boolean actual = UserInputValidator.isDateTimeValid(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void validateCorrectDateTime() {
		String input = "20/12/2320 20:30";
		boolean expected = true;
		boolean actual = UserInputValidator.isDateTimeValid(input);
		assertEquals(expected, actual);
	}
}
