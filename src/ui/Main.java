package ui;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	//relations
	private Veterinary myLittlePet;
	private Scanner reader;
	
	public Main(){
		init();
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args){
		Main m = new Main();
		m.welcome();
		m.showMenu();
	}
	
	//welcome
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|                             Welcome to My Little Pet                                        |");
		System.out.println("----------------------------------------------------------------------------------------------");
	}
	
	//Options
	public void showMenu(){
		int option = 0;
		while(option != 9){
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1. Register human clients and their pets");
			System.out.println("2. Hospitalize a pet");
			System.out.println("3. Make a report of the medical records of hospitalized patients");
			System.out.println("4. Consult the contact details of the owner of a hospitalized pet");
			System.out.println("5. Calculate the cost of an hospitalization");
			System.out.println("6. Discharge an animal that has been hospitalized");
			System.out.println("7. Know the earnings from the hospitalization service");
			System.out.println("8. Know the mini room's number occupied by a pet");
			System.out.println("9. Exit");
			System.out.println("----------------------------------------------------------------------");
			option = reader.nextInt();
			reader.nextLine();
			switch(option){
				case(1):
				addCustomers();
				break;
				case(2):
				break;
				case(3):
				break;
				case(4):
				break;
				case(5):
				break;
				case(6):
				break;
				case(7):
				break;
				case(8):
				break;
				case(9):
				break;
				default:
				System.out.println("Enter a valid number");
				break;
			}
		}
	}
	
	public void init(){
		Date joinDate1 = new Date(21, 3, 2019);
		Date exitDate1 = new Date(25, 3, 2019);
		Date joinDate2 = new Date(25, 6, 2018);
		Medicine drug1 = new Medicine("acetaminophen", 1.5, 2.35, 8.5);
		Medicine drug2 = new Medicine("complex b", 4.5, 5, 10);
		Medicine drug3 = new Medicine("dolex", 1, 1, 7.5);
		Medicine drug4 = new Medicine("fencafen", 4.5, 10.6, 11.4);
		HumanClient client1 = new HumanClient("Tomas", "144921651", "cra 40b #45-60", "315181616");
		HumanClient client2 = new HumanClient("Fernanda", "125465631", "cra 45a #85-99", "315464661");
		Animal animal1 = new Animal("Firulais", 'D', 6, 25.8, client1);
		Animal animal2 = new Animal("Dante", 'B', 2, 0.2, client2);
		client1.getPet().add(animal1);
		animal1.setOwner(client1);
		client2.getPet().add(animal2);
		animal2.setOwner(client2);
		ClinicHistory history1 = new ClinicHistory(true, "The patient presents pain when walking", "He has broken the heel of Achilles", animal1, joinDate1, exitDate1);
		ClinicHistory history2 = new ClinicHistory(true, "The patient presents a lot of vomit", "The patient has a stomach flu", animal2, joinDate2, null);
		history1.getDrug().add(drug1);
		history1.getDrug().add(drug2);
		history2.getDrug().add(drug3);
		history2.getDrug().add(drug4);
		MiniRoom room1 = new MiniRoom(true, 1, null);
		MiniRoom room2 = new MiniRoom(true, 2, null);
		MiniRoom room3 = new MiniRoom(true, 3, null);
		MiniRoom room4 = new MiniRoom(false, 4, history1);
		MiniRoom room5 = new MiniRoom(true, 5, null);
		MiniRoom room6 = new MiniRoom(true, 6, null);
		MiniRoom room7 = new MiniRoom(false, 7, history2);
		MiniRoom room8 = new MiniRoom(true, 8, null);
		MiniRoom[] temporalRooms = {room1,room2, room3, room4, room5, room6, room7, room8};
		Veterinary myLittlePet = new Veterinary();
		myLittlePet.setRooms(temporalRooms);
		myLittlePet.getRecord().add(history1);
		myLittlePet.getRecord().add(history2);
		myLittlePet.getCustomer().add(client1);
		myLittlePet.getCustomer().add(client1);
	}		
	
	//Add human clients and their pets
	public void addCustomers(){
		System.out.println("Customer's name:");
		String theName = reader.nextLine();
		System.out.println("Customer's identifier:");
		String theIdentifier = reader.nextLine();
		System.out.println("Customer's adress:");
		String theAdress = reader.nextLine();
		System.out.println("Customer's phone number:");
		String thePhoneNumber = reader.nextLine();
		HumanClient temporalClient = new HumanClient(theName, theIdentifier, theAdress, thePhoneNumber);
		System.out.println("¿How many pets has the customer?:");
		int quantityPets = reader.nextInt();
		reader.nextLine();
		ArrayList<Animal> temporalAnimals = new ArrayList<Animal>();
		for(int i = 0; i < quantityPets; i++){
			System.out.println("---------------------------------------------------------------");
			System.out.println("pet "+(i+1)+":");
			System.out.println("pet's name:");
			String petName = reader.nextLine();
			System.out.println("pet's type(c for cat, d for dog, b for bird, o for others):");
			char petType = reader.next().charAt(0);
			System.out.println("pet's age:");
			int petAge = reader.nextInt();
			reader.nextLine();
			System.out.println("pet's weight:");
			double petWeight = reader.nextDouble();
			reader.nextLine();
			Animal temporalPet = new Animal(petName, petType, petAge, petWeight, temporalClient);
			temporalAnimals.add(temporalPet);
		}
		temporalClient.setPet(temporalAnimals);
		myLittlePet.addClients(temporalClient);
		System.out.println("The client was added successfully");
	}
}



