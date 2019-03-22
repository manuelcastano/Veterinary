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
	
	//to get the report
	public String report(){
		String msg = "";
		msg += "\nIn the room "+getNumber()+":";
		msg += history.report();
		return msg;
	}
	
	//to get the contact details of the owner
	public String contactOwner(){
		return history.contactOwner();
	}
	
	//to set the exit date of the clinic history
	public void exitDate(Date exit){
		history.setExitDate(exit);
	}
	
	//to set the status of the clinic history
	public void statusHistory(boolean status){
		getHistory().setStatus(status);
	}
	
	//to get the cost of the hospitalization
	public double hospitalizationCosts(){
		return history.hospitalizationCost();
	}
	
	//to know if the pet is equals to the pet in the clinic history
	public boolean samePet(String identifier, String name){
		boolean same = false;
		if(identifier.equals(history.identifierOwner()) && name.equals(history.namePet())){
			same = true;
		}
		return same;
	}
}
