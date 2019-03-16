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
}