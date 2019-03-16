package model;

public class MiniRoom {
	
	//attributes
	private boolean availability;
	private int number;
	
	//Relations
	private ClinicHistory history;
	
	//constructor
	public MiniRoom(boolean availability, int number, ClinicHistory history){
		this.availability = availability;
		this.number = number;
		this.history = history;
	}
	
	//get's and set's
	public boolean getAvailability(){
		return availability;
	}
	public void setAvailability(boolean availability){
		this.availability = availability;
	}
	
	public int getNumber(){
		return number;
	}
	public void setNumber(int number){
		this.number = number;
	}
	
	public ClinicHistory getHistory(){
		return history;
	}
	public void setHistory(ClinicHistory history){
		this.history = history;
	}
	
	
}