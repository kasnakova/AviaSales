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
		String input = Utils.parseDateToString(LocalDate.now());
		boolean expected = true;
		boolean actual = UserInputValidator.isDateValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateInTheFutureBirthday() {
		String input = "20/07/2563";
		boolean expected = false;
		boolean actual = UserInputValidator.isBirthdayValid(input);
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

	@Test
	public void validateNoUsernameEmailAddress() {
		String input = "@abv.bg";
		boolean expected = false;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNoAtEmailAddress() {
		String input = "mariaabv.bg";
		boolean expected = false;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNoEndEmailAddress() {
		String input = "username@abv";
		boolean expected = false;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNoDomainEmailAddress() {
		String input = "suername@.bg";
		boolean expected = false;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateEmptyEmailAddress() {
		String input = "";
		boolean expected = false;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNullEmailAddress() {
		String input = null;
		boolean expected = false;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateContainingHyphenEmailAddress() {
		String input = "username@tu-sofia.bg";
		boolean expected = true;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateWithDotEmailAddress() {
		String input = "maria.angelova@gmail.com";
		boolean expected = true;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateTypicalValidEmailAddress() {
		String input = "username@gmail.com";
		boolean expected = true;
		boolean actual = UserInputValidator.isEmailValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateTooShortPhoneNumber() {
		String input = "56478";
		boolean expected = false;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateTooLongPhoneNumber() {
		String input = "546584351526476878965444786513154";
		boolean expected = false;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNonDigitPhoneNumber() {
		String input = "855476a68982";
		boolean expected = false;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateEmptyPhoneNumber() {
		String input = "";
		boolean expected = false;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNullPhoneNumber() {
		String input = null;
		boolean expected = false;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateInternationalValidPhoneNumber() {
		String input = "+359886523857";
		boolean expected = true;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}

	@Test
	public void validateNormalValidPhoneNumber() {
		String input = "89845678541";
		boolean expected = true;
		boolean actual = UserInputValidator.isPhoneNumberValid(input);
		assertEquals(expected, actual);
	}
}
