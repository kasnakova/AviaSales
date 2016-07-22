package com.aviasales.models;

import java.time.LocalDate;

/**
 * Search information for finding suitable routes
 * 
 * @author Stepanov Vyacheslav
 *****
 */

public class SearchParams {
	private String dep;
	private String arr;
	private LocalDate depDate;
	private int personCount;

	public SearchParams(String dep, String arr, LocalDate depDate, int personCount) {
		this.arr = arr;
		this.dep = dep;
		this.depDate = depDate;
		this.personCount = personCount;
	}

	public String getDep() {
		return dep;

	}

	public String getArr() {
		return arr;

	}

	public LocalDate getDepDate() {
		return depDate;

	}

	@Override
	public String toString() {
		return "SearchParams [dep=" + dep + ", arr=" + arr + ", depDate=" + depDate + ",  personCount=" + personCount
				+ "]";
	}

	public int getPersonCount() {
		return personCount;

	}

}
