package model;

/**
*This class contains the mini room's information
*@author Manuel David Castaño Saldarriaga
*Icesi University<br>
*APO I<br>
*/
public class MiniRoom {

	//attributes
	private boolean availability;
	private int number;

	//Relations
	private ClinicHistory history;

	/**
	*MiniRoom constructor
	*@param availability the occupied status of the mini room
	*@param number the number of the mini room
	*@param history the clinic history of the pet hospitalized
	*/
	public MiniRoom(boolean availability, int number, ClinicHistory history){
		this.availability = availability;
		this.number = number;
		this.history = history;
	}

	/**
	*Gets the availability
	*@return the availability status of the room
	*/
	public boolean getAvailability(){
		return availability;
	}
	/**
	*Sets the availability
	*@param availability the availability status of the mini room
	*/
	public void setAvailability(boolean availability){
		this.availability = availability;
	}
	
	/**
	*Gets the number of the mini room
	*@return the number of the mini room
	*/
	public int getNumber(){
		return number;
	}
	/**
	*Sets the number
	*@param number the number of the mini room
	*/
	public void setNumber(int number){
		this.number = number;
	}
	
	/**
	*Gets the clinic history
	*@return the clinic history of the pet hospitalized
	*/
	public ClinicHistory getHistory(){
		return history;
	}
	/**
	*Sets the clinic history
	*@param history the clinic history of the pet hospitalized
	*/
	public void setHistory(ClinicHistory history){
		this.history = history;
	}
	
	/**
	*To return the report of the clinic history<br>
	*pre: the availability is false and the history must be not null<br>
	*post: the report is generated<br>
	*@return the report of the clinic history of the pet hospitalized
	*/
	public String report(){
		String msg = "";
		msg += "\nIn the room "+getNumber()+":";
		msg += history.report();
		return msg;
	}
	
	/**
	*To return the contact details of the pet's owner<br>
	*pre: the availability is false and the history must be not null<br>
	*The contact details of the owner is delivered<br>
	*@return the contact details of the owner
	*/
	public String contactOwner(){
		return history.contactOwner();
	}
	
	/**
	*to set the exit date of the clinic history<br>
	*pre: the availability is false and the history must be not null<br>
	*post: the exit date is set<br>
	*@param exit the exit date
	*/
	public void exitDate(Date exit){
		history.setExitDate(exit);
	}
	
	/**
	*to set the status of the clinic history<br>
	*pre: the availability is false and the history must be not null<br>
	*post: the status of the clinic history is set<br>
	*@param status the status of the clinic history
	*/
	public void statusHistory(boolean status){
		getHistory().setStatus(status);
	}
	
	/**
	*to get the cost of the hospitalization<br>
	*pre: the availability is false and the history must be not null<br>
	*post: the cost of the hospitalization is calculated<br>
	*@return the cost of the hospitalization
	*/
	public double hospitalizationCosts(){
		return history.hospitalizationCost();
	}
	
	/**
	*to know if the pet is equals to the pet in the clinic history<br>
	*pre: the availability is false and the history must be not null<br>
	*post: the pet is verified<br>
	*@param identifier the identifier of the owner
	*@param name the name of the pet
	*@return a boolean indicates if the pet is the same of the pet hospitalized in the room
	*/
	public boolean samePet(String identifier, String name){
		boolean same = false;
		if(identifier.equals(history.identifierOwner()) && name.equals(history.namePet())){
			same = true;
		}
		return same;
	}
	
	/**
	*to add new medicines to the clinic history
	*@param name The medicine name. This param must be not null.
	*@param dose The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
	*@param costDose The medicine cost by each dose. This param could be empty.
	*@param frequency The frequency of medicine application. This param could be empty.
	*@return A message that indiques if medicine was added to the patient clinic story
	*/
	public String addMedicines(String name, double dose, double costDose, double frequency){
		String msg = history.addMedicines(name, dose, costDose, frequency);
		return msg;
	}
	
	/**
	*to add new notes to the possible diagnostic of a hospitalized pet
	@param diagnostic the new notes to the diagnostic
	*/
	public void addNotes(String diagnostic){
		history.addNotes(diagnostic);
	}
	
	/**
	*to add new symptom to the clinic histoy of a hospitalized pet
	@param symptom the new symptom to add
	*/
	public void addSymptom(String symptom){
		history.addSymptom(symptom);
	}
}
