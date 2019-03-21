package model;
import java.util.ArrayList;

public class HumanClient{
	
	//attributes
	private String name;
	private String identifier;
	private String adress;
	private String phoneNumber;
	
	//relations
	private ArrayList<Animal> pet;
	
	//constructor
	public HumanClient(String name, String identifier, String adress, String phoneNumber){
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
	
	public String getIdentifier(){
		return identifier;
	}
	public void setIdentifier(String identifier){
		this.identifier = identifier;
	}
	
	public String getAdress(){
		return adress;
	}
	public void setAdress(String adress){
		this.adress = adress;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber (String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public ArrayList<Animal> getPet(){
		return pet;
	}
	public void setPet(ArrayList<Animal> pet){
		this.pet = pet;
	}
	
	public void addPet(Animal pet1){
	  pet.add(pet1);
	}
}