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

	//to add a pet
	public void addPet(Animal pet1){
	  pet.add(pet1);
	}

	//to return the name of the pets that the client has
	public String namePets(){
		String msg = "";
		int position = 0;
		if(pet.isEmpty()){
			msg = "\nThe client don't has pet";
		}
		else{
		for(int i = 0; i < pet.size(); i++){
			position++;
			msg += "\n"+position+". "+pet.get(i).getName();
		}
		}
		return msg;
	}
	
	//to return the contact details
	public String contactDetails(){
		String msg = "";
		msg += "\nThe name of the owner is "+getName();
		msg += "\nThe identifier of the owner is "+getIdentifier();
		msg += "\nThe adress of the owner is "+getAdress();
		msg += "\nThe phone number of the owner is "+getPhoneNumber();
		return msg;
	}
	
	//to eliminate a pet
	public String eliminatePet(String petName){
		String msg = "";
		for(int i = 0; i < pet.size(); i++){
			if(pet.get(i).getName().equals(petName)){
				pet.remove(i);
				msg = "The pet was eliminate successfuly";
			}
			else{
				msg = "The pet doesn't exist";
			}
		}
		return msg;
	}
}
