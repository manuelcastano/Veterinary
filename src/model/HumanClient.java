package model;
import java.util.ArrayList;

public class HumanClient{
	
	//attributes
	private String name;
	private int identifier;
	private String adress;
	private int phoneNumber;
	
	//relations
	private ArrayList<Animal> pet;
	
	//constructor
	public HumanClient(String name, int identifier, String adress, int phoneNumber){
		this.name = name;
		this.identifier = identifier;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		pet = new ArrayList<Animal>();
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getIdentifier(){
		return identifier;
	}
	public void setIdentifier(int identifier){
		this.identifier = identifier;
	}
	
	public String getAdress(){
		return adress;
	}
	public void setAdress(String adress){
		this.adress = adress;
	}
	
	public int getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber (int phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public ArrayList<Animal> getPet(){
		return pet;
	}
	public void setPet(ArrayList<Animal> pet){
		this.pet = pet;
	}
}