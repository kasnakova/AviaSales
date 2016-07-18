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
	private LocalDate returnDate;
	private boolean returnFlight;
	private int personCount;

	public SearchParams(String dep, String arr, LocalDate depDate, LocalDate returnDate, boolean returnFlight,
			int personCount) {
		this.arr = arr;
		this.dep = dep;
		this.depDate = depDate;
		this.returnDate = returnDate;
		this.returnFlight = returnFlight;
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

	public LocalDate getReturnDate() {
		return returnDate;

	}

	@Override
	public String toString() {
		return "SearchParams [dep=" + dep + ", arr=" + arr + ", depDate=" + depDate + ", returnDate=" + returnDate
				+ ", returnFlight=" + returnFlight + ", personCount=" + personCount + "]";
	}

	public boolean getReturnFlight() {
		return returnFlight;

	}

	public int getPersonCount() {
		return personCount;

	}

}
