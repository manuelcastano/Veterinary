package model;

/**
*This class contains the animal's information
*/
public class Animal {
	
	//attributes
	private final static char CAT = 'c';
	private final static char DOG = 'd';
	private final static char BIRD = 'b';
	private final static char OTHERS = 'o';
	private String name;
	private char type;
	private int age;
	private double weight;
	private double height;
	
	//relations
	private HumanClient owner;
	
	/**
	*Animal constructor
	*@param name the animal's name
	*@param type the animal's type
	*@param age the animal's age
	*@param weight the animal's weight
	*@param height the animal's height
	*@param owner the owner of the animal. This param must be not null
	*/
	public Animal(String name, char type, int age, double weight, double height, HumanClient owner){
		this.name = name;
		this.type = type;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.owner = owner;
	}
	
	/**
	*Gets the name
	*@return the animal's name
	*/
	public String getName(){
		return name;
	}
	/**
	*Sets the name
	*@param name the animal's name
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	*Gets the type
	*@return the animal's type
	*/
	public char getType(){
		return type;
	}
	/**
	*Sets the animal's type
	*@param type the animal's type
	*/
	public void setType(char type){
		this.type = type;
	}
	
	/**
	*Gets the animal's age
	*@return the animal's name
	*/
	public int getAge(){
		return age;
	}
	/**
	*Sets the animal's age
	*@param age the animal's age
	*/
	public void setAge(int age){
		this.age = age;
	}
	
	/**
	*Gets the weight
	*@return the animal's weight
	*/
	public double getWeight(){
		return weight;
	}
	/**
	*Sets the weight
	*@param weight the animal's weight
	*/
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	/**
	*Gets the height
	*@return the animal's height
	*/
	public double getHeight(){
		return height;
	}
	/**
	*Sets the height
	*@param height the animal's height
	*/
	public void setHeight(double height){
		this.height = height;
	}
	
	/**
	*Gets the animal's owner
	*@return the owner
	*/
	public HumanClient getOwner(){
		return owner;
	}
	/**
	*Sets the owner
	*@param owner the animal's owner
	*/
	public void setOwner(HumanClient owner){
		this.owner = owner;
	}
	
	/**
	*to return the name of the owner<br>
	*pre: The animal was created before and the owner must be not null<br>
	*post: the owner's name is delivered<br>
	*@return the name of the owner
	*/
	public String nameOwner(){
		return owner.getName();
	}
	
	/**
	*to return the identifier of the owner<br>
	*pre: The animal was created before and the owner must be not null<br>
	*post: the owner's identifier is delivered<br>
	*@return the identifier of the owner
	*/
	public String identifierOwner(){
		return owner.getIdentifier();
	}
	
	/**
	*to return the contact details of the owner<br>
	*pre: The animal was created before and the owner must be not null<br>
	*post: the owner's contact details is delivered<br>
	*@return the contact details of the owner
	*/
	public String contactOwner(){
		return owner.contactDetails();
	}
	
	/**
	*to return the type of the pet<br>
	*pre: The animal was created before and the type must be not null<br>
	*post: the type of the animal is delivered<br>
	*@return the animal's type
	*/
	public String petType(){
		String msg = "";
		if(type == 'c'){
			msg = "The pet is a cat";
		}
		else if(type == 'd'){
			msg = "The pet is a dog";
		}
		else if(type == 'b'){
			msg = "The pet is a bird";
		}
		else if(type == 'o'){
			msg = "We don't know the type of the pet";
		}
		return msg;
	}
	
	/**
	*Description This method allows to calculate the body mass index for a pet.<br>
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.<br>
	*post: The BMI is calculated.<br>
	*@return The pet body mass index.
	*@throws  ArithmeticException If the height is zero, so an exception is thrown due to the division on zero does not exist.
	*/
	public double bodyMassIndex(){
		return weight/(height * height);
	}

}