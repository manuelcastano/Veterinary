package model;

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
	
	//constructor
	public Service(String type, Date realization, Animal thePet){
		this.type = type;
		this.realization = realization;
		this.thePet = thePet;
		cost = calculateCost();
		identifierOwner = thePet.identifierOwner();
		namePet = thePet.getName();
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	public double getCost(){
		return cost;
	}
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public String getIdentifierOwner(){
		return identifierOwner;
	}
	public void setIdentifierOwner(String identifierOwner){
		this.identifierOwner = identifierOwner;
	}
	
	public String getNamePet(){
		return namePet;
	}
	public void setNamePet(String namePet){
		this.namePet = namePet;
	}
	
	public Date getRealization(){
		return realization;
	}
	public void setRealization(Date realization){
		this.realization = realization;
	}
	
	public Animal getThePet(){
		return thePet;
	}
	public void setThePet(Animal thePet){
		this.thePet = thePet;
	}
	
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