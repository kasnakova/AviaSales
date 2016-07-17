
import java.util.Date;

public class Flight2 {
	String aeroport1;
	String aeroport2;
	Date date1;
	Date date2;
	int number;
	double cost;
	int numberOfFreeSeats;

	public Flight2(String aeroport1, String aeroport2, Date date1, Date date2, int seats) {
		this.aeroport1 = aeroport1;
		this.aeroport2 = aeroport2;
		this.date1 = date1;
		this.date2 = date2;
		this.numberOfFreeSeats = seats;
	}

}
