package model;
import java.util.ArrayList;

/**
*This class constains the information for the customers
*/
public class HumanClient{

	//attributes
	private String name;
	private String identifier;
	private String address;
	private String phoneNumber;

	//relations
	private ArrayList<Animal> pet;

	/**
	*HumanClient constructor
	*@param name the name
	*@param identifier the identifier
	*@param address the address
	*@param phoneNumber the phone number
	*/
	public HumanClient(String name, String identifier, String address, String phoneNumber){
		this.name = name;
		this.identifier = identifier;
		this.address = address;
		this.phoneNumber = phoneNumber;
		pet = new ArrayList<Animal>();
	}
	
	/**
	*Gets the name
	*@return the name
	*/
	public String getName(){
		return name;
	}
	/**
	*Sets the name
	*@param name the name
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	*Gets the identifier
	*@return the identifier
	*/
	public String getIdentifier(){
		return identifier;
	}
	/**
	*Sets the identifier
	*@param identifier the identifier
	*/
	public void setIdentifier(String identifier){
		this.identifier = identifier;
	}
	
	/**
	*Gets the address
	*@return the address
	*/
	public String getAddress(){
		return address;
	}
	/**
	*Sets the address
	*@param address the address
	*/
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	*Gets the phone number
	*@return the phone number
	*/
	public String getPhoneNumber(){
		return phoneNumber;
	}
	/**
	*Sets the phone number
	*@param phoneNumber the phone number
	*/
	public void setPhoneNumber (String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	/**
	*Gets the pets
	*@return the pets
	*/
	public ArrayList<Animal> getPet(){
		return pet;
	}
	/**
	*Sets the pets
	*@param pet the pets
	*/
	public void setPet(ArrayList<Animal> pet){
		this.pet = pet;
	}

	/**
	*to add a pet<br>
	*pre: The human client was created before and the pet is initialized<br>
	*post: The new pet were added to the human client<br>
	*@param pet1 the pet to add
	*/
	public void addPet(Animal pet1){
	  pet.add(pet1);
	}

	/**
	*to return the name of the pets that the client has<br>
	*pre: The human client was created before and pet is initialized<br>
	*post: the names of the pets is delivered<br>
	*@return the name of the pets
	*/
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
	
	/**
	*to return the contact details
	*@return the contact details of the human client
	*/
	public String contactDetails(){
		String msg = "";
		msg += "\nThe name of the owner is "+getName();
		msg += "\nThe identifier of the owner is "+getIdentifier();
		msg += "\nThe address of the owner is "+getAddress();
		msg += "\nThe phone number of the owner is "+getPhoneNumber();
		return msg;
	}
	
	/**
	*to eliminate a pet<br>
	*pre: the human client was created before and pet is initialized<br>
	*post: the pet is eliminated<br>
	*@param petName the name of the pet to eliminate
	*@return a text with the result of the operation
	*/
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
	
	/**
	*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	*pre: The client was created before.
	*post: The address and /or phone number of the client is updated.
	*@param address The new address of the client. This param could be empty.
	*@param phoneNumber The new phone number of the client. This param could be empty.
	*/
	public void updatedData(String address, String phoneNumber){
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
}
