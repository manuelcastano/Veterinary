package model;

public class Medicine {
	
	//attributes
	private String name;
	private double dose;
	private double costDose;
	private double frequency;//Hours
	
	//constructor
	public Medicine(String name, double dose, double costDose, double frequency){
		this.name = name;
		this.dose = dose;
		this.costDose = costDose;
		this.frequency = frequency;
	}
	
	//get's and set's
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public double getDose(){
		return dose;
	}
	public void setDose(double dose){
		this.dose = dose;
	}
	
	public double getCostDose(){
		return costDose;
	}
	public void setCostDose(double costDose){
		this.costDose = costDose;
	}
	
	public double getFrequency(){
		return frequency;
	}
	public void setFrequency(double frequency){
		this.frequency = frequency;
	}
	
	//to get the cost of the medicine
	public double costMedicine(){
		return dose*costDose;
	}
}