package model;

/**
*This class contains the service's information
*@author Manuel David Castaño Saldarriaga
*Icesi University<br>
*APO I<br>
*/
public class Service{
	
	//constants
	public final static String PET_SHOWER_V = "Pet bath in the veterinary";
	public final static String PET_SHOWER_D = "Pet bath at home";
	public final static String NAIL_CUT = "Nail cutting";
	public final static String DENTAL = "Dental prophylaxis";
	public final static String VACCINATIONS = "Vaccine aplication";
	
	//attributes
	private String type;
	private double cost;
	private String identifierOwner;
	private String namePet;
	
	//relations
	private Date realization;
	private Animal thePet;
	
	/**
	*Service constructor
	*@param type the type of the service
	*@param realization the realization date of the service
	*@param thePet the pet to whom the service was performed
	*/
	public Service(String type, Date realization, Animal thePet){
		this.type = type;
		this.realization = realization;
		this.thePet = thePet;
		cost = calculateCost();
		identifierOwner = thePet.identifierOwner();
		namePet = thePet.getName();
	}
	
	/**
	*Gets the type
	*@return the type of the service
	*/
	public String getType(){
		return type;
	}
	/**
	*Sets the type
	*@param type the type of the service
	*/
	public void setType(String type){
		this.type = type;
	}
	
	/**
	*Gets the cost
	*@return the cost of the service
	*/
	public double getCost(){
		return cost;
	}
	/**
	*Sets the cost
	*@param cost the cost of the service
	*/
	public void setCost(double cost){
		this.cost = cost;
	}
	
	/**
	*Gets the identifier of the owner
	*@return the identifier of the pet's owner
	*/
	public String getIdentifierOwner(){
		return identifierOwner;
	}
	/**
	*Sets the identifier of the owner
	*@param identifierOwner the identifier of the pet's owner
	*/
	public void setIdentifierOwner(String identifierOwner){
		this.identifierOwner = identifierOwner;
	}
	
	/**
	*Gets the name of the pet
	*@return the pet's name
	*/
	public String getNamePet(){
		return namePet;
	}
	/**
	*Sets the name of the pet
	*@param namePet the pet's name
	*/
	public void setNamePet(String namePet){
		this.namePet = namePet;
	}
	
	/**
	*Gets the realization date
	*@return the realization date
	*/
	public Date getRealization(){
		return realization;
	}
	/**
	*Sets the realization date
	*@param realization the realization date
	*/
	public void setRealization(Date realization){
		this.realization = realization;
	}
	
	/**
	*Gets the pet
	*@return the pet
	*/
	public Animal getThePet(){
		return thePet;
	}
	/**
	*Sets the pet
	*@param thePet the pet
	*/
	public void setThePet(Animal thePet){
		this.thePet = thePet;
	}
	
	/**
	*Calculates the cost of the service<br>
	*pre: the service was created before and the type must be not null<br>
	*post: the cost is calculated<br>
	*@return the cost of the service
	*/
	public double calculateCost(){
		double theCost = 0.0;
		if(type.equals(PET_SHOWER_V)){
			theCost = 20000.0;
		}
		else if(type.equals(PET_SHOWER_D)){
			theCost = 30000.0;
		}
		else if(type.equals(NAIL_CUT)){
			theCost = 8000.0;
		}
		else if(type.equals(DENTAL)){
			theCost = 12000.0;
		}
		else if(type.equals(VACCINATIONS)){
			theCost = 45000.0;
		}
		return theCost;
	}
}