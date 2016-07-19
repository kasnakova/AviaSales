package com.aviasales.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
}
