package model;

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
	
	//relations
	private HumanClient owner;
	
	//constructor
	public Animal(String name, char type, int age, double weight, HumanClient owner){
		this.name = name;
		this.type = type;
		this.age = age;
		this.weight = weight;
		this.owner = owner;
	}
	
	//get's and set's
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public char getType(){
		return type;
	}
	public void setType(char Type){
		this.type = type;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public HumanClient getOwner(){
		return owner;
	}
	public void setOwner(HumanClient owner){
		this.owner = owner;
	}
	
	//to return the name of the owner
	public String nameOwner(){
		return owner.getName();
	}
	
	//to return the identifier of the owner
	public String identifierOwner(){
		return owner.getIdentifier();
	}
	
	//to return the contact details of the owner
	public String contactOwner(){
		return owner.contactDetails();
	}
	
	//to return the type of the pet
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
}