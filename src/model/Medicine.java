package model;

/**
*This class contains the information for each medicine
*@author Manuel David Castaño Saldarriaga
*Icesi University<br>
*APO I<br>
*/
public class Medicine {
	
	//attributes
	private String name;
	private double dose;
	private double costDose;
	private double frequency;//Hours
	
	/**
	*Medicine constructor
	*@param name the name of the medicine. This param must be not null.
	*@param dose the dose of the medicine for the patient. This param must be not null.
	*@param costDose the cost of each dose
	*@param frequency the frequency of the medicine
	*/
	public Medicine(String name, double dose, double costDose, double frequency){
		this.name = name;
		this.dose = dose;
		this.costDose = costDose;
		this.frequency = frequency;
	}
	
	/**
	*Gets the name
	*@return the name of the medicine
	*/
	public String getName(){
		return name;
	}
	/**
	*Sets the name
	*@param name the name. This param must be not null.
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	*Gets the dose
	*@return the dose of the medicine
	*/
	public double getDose(){
		return dose;
	}
	/**
	*Sets the dose
	*@param dose the dose of the medicine. This param must be not null.
	*/
	public void setDose(double dose){
		this.dose = dose;
	}
	
	/**
	*Gets the cost of each dose
	*@return the cost of each dose
	*/
	public double getCostDose(){
		return costDose;
	}
	/**
	*Sets the cost of each dose
	*@param costDose the cost of each dose
	*/
	public void setCostDose(double costDose){
		this.costDose = costDose;
	}
	
	/**
	*Gets the frequency
	*@return the frequency
	*/
	public double getFrequency(){
		return frequency;
	}
	/**
	*Sets the frequency
	*@param frequency the frequency
	*/
	public void setFrequency(double frequency){
		this.frequency = frequency;
	}
	
	/**
	*This method calculates the cost of the medicine<br>
	*pre: The medicine was created before and its attributes dose and costDose must be not null.<br>
	*post: The cost is calculated.<br>
	*@return the cost of the medicine
	*/
	public double costMedicine(){
		return dose*costDose;
	}
}