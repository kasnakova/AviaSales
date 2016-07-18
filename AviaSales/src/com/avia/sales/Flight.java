package com.avia.sales;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;


/**
 * Information about a flight
 * @author ildarworld
 *
 */
public class Flight implements Savable{
	private String number;
	private double cost;
	private int numberOfFreePlaces;
	private String dep;
	private String arr;
	private LocalDateTime depTime;
	private LocalDateTime arrTime;
	private final String CLASS_NAME = "Flights";
	
	/**
	 * 
	 * @param number of Flight
	 * @param dep departure airport
	 * @param arr arrive airport
	 * @param depTime departive time
	 * @param arrTimearrive time
	 * @param cost flight cost
	 * @param numberOfFreePlaces number of free places on this board
	 */
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		StringBuilder tmpConnector = new StringBuilder();
		tmpConnector.append(" Flight number: " + this.number);
		tmpConnector.append(" Departure airport: " + this.dep);
		tmpConnector.append(" Arrive airport: " + this.arr);
		tmpConnector.append(" Departure time: " + this.depTime.format(formatter));
		tmpConnector.append(" Arrive time: " + this.arrTime.format(formatter));
		tmpConnector.append(" Cost: " + this.cost);
		//tmpConnector.append(" Number of free places: " + this.numberOfFreePlaces);
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
	    if (this.arr==sp.getArr())
	      return true;
	    else
	      return false;
	  }

	@Override
	public String makeSavebleString() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		String result = getNumber() + ";" + getDep() + ";" + getArr() + ";" + getDepTime().format(formatter) +";" + 
						getArrTime().format(formatter) + ";" + getCost() + ";" + getNumberOfFreePlaces();
		
		return result;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASS_NAME;
	}
	/**
	 * 
	 * @param count number of buying tickets
	 * @return 1 if free places on the flight enough to buying and -1 if doesn't enough
	 */
	public int buyTickets(int count){
		if (this.numberOfFreePlaces >= count)
			return -1;
		this.numberOfFreePlaces -= count; 
		return 1;
	}
	
	public boolean isFull(){
		return (this.numberOfFreePlaces > 0) ? true : false;
	}
	
	public static Savable getObjectFromString(String line) {
		
		StringTokenizer st = new StringTokenizer(line,";");
		if(!st.hasMoreTokens())
			return null;
		int  numberOfFreePlaces;
		double cost;
		String number, dep, arr;
		LocalDateTime depTime, arrTime;
		
		number = st.nextElement().toString();
		dep = st.nextElement().toString();
		arr = st.nextElement().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		depTime = LocalDateTime.parse(st.nextElement().toString(), formatter);
		if (depTime.isBefore(LocalDateTime.now()))
			return null;
		arrTime = LocalDateTime.parse(st.nextElement().toString(), formatter);
		cost = Double.valueOf(st.nextElement().toString());
		numberOfFreePlaces = Integer.parseInt(st.nextElement().toString());
		        
		Flight cf = new Flight(number, dep, arr, depTime, arrTime, cost, numberOfFreePlaces);
		return cf;
	}
	/*
	@Override
	public Savable getObjectFromString(String line) {
		
	   StringTokenizer st = new StringTokenizer(line,";");
	   while(st.hasMoreTokens()){
	        
	        this.number = st.nextElement().toString();
	        this.dep = st.nextElement().toString();
	        this.arr = st.nextElement().toString();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	        this.depTime = LocalDateTime.parse(st.nextElement().toString(), formatter);
	        this.arrTime = LocalDateTime.parse(st.nextElement().toString(), formatter);
	        this.cost = Double.valueOf(st.nextElement().toString());
	        this.numberOfFreePlaces = Integer.parseInt(st.nextElement().toString());
	   }
	        
		return this;
	}*/
}
