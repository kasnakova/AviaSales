import java.time.LocalDate;
/**
 * Search information for finding suitable routes
 * @author ildarworld
 *****
 */


public class SearchParams {
	private String dep;
	private String arr;
	private LocalDate depDate;
	private LocalDate returnDate;
	private boolean returnFlight;
	private int personCount;
	
	public SearchParams(String dep,String arr,LocalDate depDate,LocalDate returnDate,boolean returnFlight,int personCount){
		
	}
	public String getDep(){
		return dep;
		
	}
	public String getArr(){
		return arr;
		
	}
	public LocalDate getDepDate(){
		return depDate;
		
	}
	public LocalDate getReturnDate(){
		return returnDate;
		
	}
	public boolean  getReturnFlight(){
		return returnFlight;
		
	}
	public int  getPersonCount(){
		return  personCount;
		
	}
	
	
}
