import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/*
 * It is the main logic for AviaSales project
 */
public class AviaSales {
	public AviaSales() {
		/*
		 * loadFlightss
		 */
	}

	/**
	 * The main menu for the user
	 * @throws IOException 
	 */
	public void run() throws IOException {
		/*
		 * menu searchParam(); menu printFlights() menu buyTicket() menu
		 */
		
		SearchParams sp = getSearchParams();
		ArrayList<Route> routes = Analizator.searchFlights(sp);
		for (Route r : routes) {
			System.out.println(r.toString());
		}
	}

	/**
	 * Get search parameters from the user
	 * 
	 * @return parameters needed for finding the correct flights
	 */
	private SearchParams getSearchParams() {
		SearchParams sp = new SearchParams("KAZAN", "KISLOVODSK", LocalDate.of(2016, Month.JANUARY, 14),
				2);

		return sp;
	}

	/**
	 * Print the available flights to the user according to his search input
	 */
	private void printFlights() {

	}

	/**
	 * Allows the user to buy a ticket
	 * 
	 * @param route
	 *            information about the route that the user chooses
	 * @param personCount
	 *            the number of passengers
	 */
	private void buyTickets(Route route, int personCount) {

	}

	/**
	 * Allows the administrator to add new flights
	 */
	private void addFlights() {

	}

	/**
	 * Finds information about the given person and automatically fills his
	 * information
	 * 
	 * @param email
	 *            email of the person
	 */
	private void autofill(String email) {

	}
}
