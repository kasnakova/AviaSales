
import java.time.LocalDateTime;


public class Flight2 {
	String aeroport1;
	String aeroport2;
	LocalDateTime date1;
	LocalDateTime date2;
	int number;
	double cost;
	int numberOfFreeSeats;

	public Flight2(String aeroport1, String aeroport2, LocalDateTime date1, LocalDateTime date2, int seats) {
		this.aeroport1 = aeroport1;
		this.aeroport2 = aeroport2;
		this.date1 = date1;
		this.date2 = date2;
		this.numberOfFreeSeats = seats;
	}
	public boolean isConnectingFlight(Flight2 flight){
		LocalDateTime minDate = date2.plusHours(1);
		LocalDateTime maxDate = date2.plusHours(9);
		if((aeroport2==flight.aeroport1)
				&&(flight.date1.isAfter(minDate))
				&&(flight.date1.isBefore(maxDate)));
				
		return true;
	}
	public boolean isEndFlight(SearchParams sp){
		if (aeroport2==sp.toAirport)
			return true;
		else
			return false;
	}
	

}
