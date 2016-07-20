package com.aviasales.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import com.aviasales.interfaces.Savable;

/**
 * Information about a user
 * 
 * @author ildarworld
 *
 */
public class Person implements Savable {

	private String firstName;
	private String serName;
	private String passportNumber;
	private LocalDate birthDay;
	private String email;
	private String phoneNumber;
	private String creditCardNumber;
	private final String CLASS_NAME = "Flights";

	public Person(String firstName, String serName, String passportNumber, LocalDate birthDay, String email,
			String phoneNumber, String creditCardNumber) {

		this.firstName = firstName;
		this.serName = serName;
		this.passportNumber = passportNumber;
		this.birthDay = birthDay;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.creditCardNumber = creditCardNumber;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSerName() {
		return serName;
	}

	public void setSerName(String serName) {
		this.serName = serName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String makeSavebleString() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String result = getFirstName() + ";" + getSerName() + ";" + getPassportNumber() + ";"
				+ getBirthDay().format(formatter) + ";" + getEmail() + ";" + getPhoneNumber() + ";"
				+ getCreditCardNumber();

		return result;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", serName=" + serName + ", passportNumber=" + passportNumber
				+ ", birthDay=" + birthDay + ", email=" + email + ", phoneNumber=" + phoneNumber + ", creditCardNumber="
				+ creditCardNumber + ", CLASS_NAME=" + CLASS_NAME + "]";
	}

	public static Person getObjectFromString(String line) {

		StringTokenizer st = new StringTokenizer(line, ";");
		if (!st.hasMoreTokens())
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		String firstName, serName, passportNumber, email, phoneNumber, creditCardNumber;
		LocalDate birthDay;

		firstName = st.nextElement().toString();
		serName = st.nextElement().toString();
		passportNumber = st.nextElement().toString();
		birthDay = LocalDate.parse(st.nextElement().toString(), formatter);
		email = st.nextElement().toString();
		phoneNumber = st.nextElement().toString();
		creditCardNumber = st.nextElement().toString();

		Person p = new Person(firstName, serName, passportNumber, birthDay, email, phoneNumber, creditCardNumber);
		return p;
	}

}
