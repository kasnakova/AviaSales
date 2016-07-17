import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Information about all flights in a certain route
 * 
 * @author ildarworld
 *
 */
public class Route {
	ArrayList<Flight> flights;

	private double cost;

	public Route(ArrayList<Flight> flights) {
		calculateTotalCost();
	}
	public Route(Flight flight) {
		flights.add(flight);
		calculateTotalCost();
	}

	public double getPrice() {

		return cost;

	}

	public void setPrice(double cost) {

		this.cost = cost;

	}

	/**
	 * Calculates the total cost of all flights in the route
	 */
	private void calculateTotalCost() {
		//TO DO

	}

}
