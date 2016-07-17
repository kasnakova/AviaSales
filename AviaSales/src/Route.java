import java.util.ArrayList;
/**
 * Information about all flights in a certain route
 * @author ildarworld
 *
 */
public class Route {
	ArrayList<Flight> flight;
	public double cost;
	
	public  Route(ArrayList<Flight> flights){
		calculateTotalCost();
	}
	
	
	/**
	 * Calculates the total cost of all flights in the route
	 */
	private void calculateTotalCost(){
		
	}
	
}
