
import java.time.LocalDateTime;

/**
 * Information about a flight
 * @author ildarworld
 *
 */
public class Flight {
	private String number;
	private double cost;
	private int numberOfFreePlaces;
	private String dep;
	private String arr;
	private LocalDateTime depTime;
	private LocalDateTime arrTime;
	
	public Flight(String number, String dep, String arr, LocalDateTime depTime, 
			LocalDateTime arrTime, double cost, int numberOfFreePlaces){
        this.number = number;
        this.dep = dep;
        this.arr = arr;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.cost = cost;
        this.numberOfFreePlaces = numberOfFreePlaces;
	}
	
	public String getNumber(){
		return number;
	}
	public double getCost(){
		return cost;
	}
	public int getNumberOfFreePlaces(){
		return numberOfFreePlaces;
	}
	public String getDep(){
		return dep;
	}
	public String getArr(){
		return arr;
	}
	public LocalDateTime getDepTime(){
		return depTime;
	}
	
	public LocalDateTime getArrTime(){
		return arrTime;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public void setNumberOfFreePlaces(int numberOfFreePlaces){
		this.numberOfFreePlaces = numberOfFreePlaces;
	}
	
	public void setDep(String dep){
		this.dep = dep;
	}
	
	public void setArr(String arr){
		this.arr = arr;
	}
	
	public void setDepTime(LocalDateTime depTime){
		this.depTime = depTime;
	}
	
	public void setArrTime(LocalDateTime arrTime){
		this.arrTime = arrTime;
	}

	public String toString(){
		StringBuilder tmpConnector = new StringBuilder("");
		tmpConnector.append("Flight number: " + this.number);
		tmpConnector.append(" Deparure airport: " + this.dep);
		tmpConnector.append(" Arrive airport: " + this.arr);
		tmpConnector.append(" Deparure time: " + this.depTime.toString());
		tmpConnector.append(" Arrive time: " + this.arrTime.toString());
		tmpConnector.append(" Cost: " + this.cost);
		tmpConnector.append(" Number of free places: " + this.numberOfFreePlaces);
		return tmpConnector.toString();
	}
	
	public boolean isConnectingFlight(Flight flight){
	    LocalDateTime minDate = this.arrTime.plusHours(1);
	    LocalDateTime maxDate = this.arrTime.plusHours(9);
	    if((this.getArr()==flight.getDep()) &&(flight.depTime.isAfter(minDate)) &&(flight.depTime.isBefore(maxDate))){
	    	return true;
	    }else{
	    	return false;
	    }
	  }
	
	  public boolean isEndFlight(SearchParams sp){
	    if (arr==sp.getArr())
	      return true;
	    else
	      return false;
	  }
	
	public String toStringWithSeparator(){
		//
		return "";
	}
}
