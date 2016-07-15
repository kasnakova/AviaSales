import java.time.LocalDate;
/**
 * Search information for finding suitable routes
 * @author ildarworld
 *
 */
public class SearchParams {
	String fromAirport;
	String toAirport;
	LocalDate toDate;
	LocalDate returnDate;
	boolean returnFlight;
	int personCount;
	
}
