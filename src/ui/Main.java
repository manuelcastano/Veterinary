//Manuel David Castaño Saldarriaga
//Universidad Icesi
//Code: A00358994
//Laboratorio 3. Apo I

package ui;
import model.*;
import java.util.Scanner;

/**
*This is the main class, is for the interaction between the user and the program
*/
public class Main {

	//relations
	private Veterinary myLittlePet;
	private Scanner reader;
	
	/**
	*Main constructor
	*/
	public Main(){
		init();
		reader = new Scanner(System.in);
	}
	
	/**
	*The main method, is the started point of the program
	*@param args is an array of String, taken from the command list
	*/
	public static void main(String[] args){
		Main m = new Main();
		m.welcome();
		m.showMenu();
	}

	/**
	*A text to give the welcome to the user
	*/
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|                             Welcome to My Little Pet                                        |");
		System.out.println("----------------------------------------------------------------------------------------------");
	}

	/**
	*To show the options that can do the user
	*/
	public void showMenu(){
		int option = 0;
		while(option != 13){
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1. Register human clients and their pets");
			System.out.println("2. Hospitalize a pet");
			System.out.println("3. Make a report of the hospitalized pets");
			System.out.println("4. Consult the contact details of the owner of a hospitalized pet");
			System.out.println("5. Discharge an animal that has been hospitalized");
			System.out.println("6. Know the earnings from the hospitalization service");
			System.out.println("7. Know the mini room's number occupied by a pet");
			System.out.println("8. Show the reports from the record of clinic histories");
			System.out.println("9. Eliminate a pet");
			System.out.println("10. Eliminate a client");
			System.out.println("11. Show the clinic history of a pet");
			System.out.println("12. Register only a pet");
			System.out.println("13. Exit");
			System.out.println("----------------------------------------------------------------------");
			option = reader.nextInt();
			reader.nextLine();
			switch(option){
				case(1):
				addCustomers();
				break;
				case(2):
				hospitalizePet();
				break;
				case(3):
				System.out.println(myLittlePet.report());
				break;
				case(4):
				contactOwner();
				break;
				case(5):
				dischargePet();
				break;
				case(6):
				System.out.println("The earnings from the hospitalization service is "+myLittlePet.hospitalizationEarnings());
				break;
				case(7):
				roomPet();
				break;
				case(8):
				System.out.println(myLittlePet.reportsRecord());
				break;
				case(9):
				eliminatePet();
				break;
				case(10):
				eliminateClient();
				break;
				case(11):
				historyPet();
				break;
				case(12):
				addPet();
				break;
				case(13):
				break;
				default:
				System.out.println("Enter a valid number");
				break;
			}
		}
	}
	
	/**
	*To iniatialize default objects to check the funcionality of the program
	*/
	public void init(){
		Date joinDate1 = new Date(21, 3, 2019);
		Date exitDate1 = new Date(25, 3, 2019);
		Date joinDate2 = new Date(25, 6, 2018);
		Medicine drug1 = new Medicine("acetaminophen", 1.5, 2.35, 8.5);
		Medicine drug2 = new Medicine("complex b", 4.5, 5, 10);
		Medicine drug3 = new Medicine("dolex", 1, 1, 7.5);
		Medicine drug4 = new Medicine("fencafen", 4.5, 10.6, 11.4);
		HumanClient client1 = new HumanClient("Tomas", "4646464646", "cra 40b #45-60", "315181616");
		HumanClient client2 = new HumanClient("Fernanda", "125465631", "cra 45a #85-99", "315464661");
		Animal animal1 = new Animal("Firulais", 'd', 6, 25.8, 1.2, client1);
		Animal animal2 = new Animal("Dante", 'd', 2, 1.6, 0.7, client2);
		client1.addPet(animal1);
		animal1.setOwner(client1);
		client2.addPet(animal2);
		animal2.setOwner(client2);
		ClinicHistory history1 = new ClinicHistory(true, "The patient presents pain when walking", "He has broken the heel of Achilles", animal1, joinDate1, exitDate1);
		ClinicHistory history2 = new ClinicHistory(true, "The patient presents a lot of vomit", "The patient has a stomach flu", animal2, joinDate2, null);
		history1.addDrugs(drug1);
		history1.addDrugs(drug2);
		history2.addDrugs(drug3);
		history2.addDrugs(drug4);
		MiniRoom room1 = new MiniRoom(true, 1, null);
		MiniRoom room2 = new MiniRoom(true, 2, null);
		MiniRoom room3 = new MiniRoom(true, 3, null);
		MiniRoom room4 = new MiniRoom(true, 4, null);
		MiniRoom room5 = new MiniRoom(true, 5, null);
		MiniRoom room6 = new MiniRoom(true, 6, null);
		MiniRoom room7 = new MiniRoom(false, 7, history2);
		MiniRoom room8 = new MiniRoom(true, 8, null);
		MiniRoom[] temporalRooms = {room1,room2, room3, room4, room5, room6, room7, room8};
		myLittlePet = new Veterinary();
		myLittlePet.setRooms(temporalRooms);
		myLittlePet.addHistorys(history1);
		myLittlePet.addClients(client1);
		myLittlePet.addClients(client2);
	}

	/**
	*To add new customers and their pets
	*/
	public void addCustomers(){
		System.out.println("Customer's name:");
		String theName = reader.nextLine();
		System.out.println("Customer's identifier:");
		String theIdentifier = reader.nextLine();
		if(myLittlePet.findClient(theIdentifier)){
			System.out.println("The client is already registered");
		}
		else{
		System.out.println("Customer's adress:");
		String theAdress = reader.nextLine();
		System.out.println("Customer's phone number:");
		String thePhoneNumber = reader.nextLine();
		HumanClient temporalClient = new HumanClient(theName, theIdentifier, theAdress, thePhoneNumber);
		System.out.println("¿How many pets has the customer?:");
		int quantityPets = reader.nextInt();
		reader.nextLine();
		for(int i = 0; i < quantityPets; i++){
			System.out.println("---------------------------------------------------------------");
			System.out.println("pet "+(i+1)+":");
			System.out.println("pet's name:");
			String petName = reader.nextLine();
			int errorType = 0;
			char petType = ' ';
			while(errorType == 0){
				System.out.println("pet's type(c for cat, d for dog, b for bird, o for others):");
				petType = reader.next().charAt(0);
				if(petType == 'c' || petType == 'd' ||petType == 'b' ||petType == 'o'){
					errorType = 1;
				}
			}
			System.out.println("pet's age:");
			int petAge = reader.nextInt();
			reader.nextLine();
			System.out.println("pet's weight:");
			double petWeight = reader.nextDouble();
			reader.nextLine();
			System.out.println("pet's height:");
			double petHeight = reader.nextDouble();
			reader.nextLine();
			Animal temporalPet = new Animal(petName, petType, petAge, petWeight, petHeight, temporalClient);
			temporalClient.addPet(temporalPet);
		}
		myLittlePet.addClients(temporalClient);
		System.out.println("The client was added successfully");
		}
	}

	/**
	*to hospitalize a pet
	*/
	public void hospitalizePet(){
		if(myLittlePet.availableRoom() == true){
			int error = 0;
			while (error == 0){
			System.out.println("owner's identifier:");
			String theIdentifier = reader.nextLine();
			if(myLittlePet.findClient(theIdentifier) == true){
				System.out.println("¿What pet do you want to hospitalize?");
				System.out.println(myLittlePet.returnClient(theIdentifier).namePets());
				int option = reader.nextInt();
				reader.nextLine();
				System.out.println("¿What are the symptoms?");
				String sysmptoms = reader.nextLine();
				System.out.println("¿What is the diagnostic?");
				String diagnostic = reader.nextLine();
				Animal mascot = myLittlePet.returnClient(theIdentifier).getPet().get(option-1);
				System.out.println("Day of join:");
				int todayDay = reader.nextInt();
				reader.nextLine();
				System.out.println("Month of join:");
				int todayMonth = reader.nextInt();
				reader.nextLine();
				System.out.println("Year of join:");
				int todayYear = reader.nextInt();
				reader.nextLine();
				Date today = new Date(todayDay, todayMonth, todayYear);
				ClinicHistory history1 = new ClinicHistory(true, sysmptoms, diagnostic, mascot, today, null);
				System.out.println("¿How many medicines has the pet?");
				int quantityMedicines = reader.nextInt();
				reader.nextLine();
				for(int i = 0; i < quantityMedicines; i++){
					System.out.println("--------------------------------");
					System.out.println("¿What is the name of the medicine?");
					String theName = reader.nextLine();
					System.out.println("¿How many doses of the medicine?");
					double theDoses = reader.nextDouble();
					reader.nextLine();
					System.out.println("¿What is the cost by dose?");
					double costByDose = reader.nextDouble();
					reader.nextLine();
					System.out.println("¿What is the frequency to take the medicine?");
					double theFrequency = reader.nextDouble();
					reader.nextLine();
					Medicine temporalDrug = new Medicine(theName, theDoses, costByDose,theFrequency);
					history1.addDrugs(temporalDrug);
				}
				myLittlePet.hospitalizeAPet(history1);
				System.out.println("The pet was hospitalized successfully");
				error = 1;
			}
			else{
				System.out.println("The client wasn't finded, please enter the identifier again");
			}
			}
			}
		else{
			System.out.println("In this moment, all rooms are occupied, please try later");
		}
	}
	
	/**
	*to consult the contact details of the owner
	*/
	public void contactOwner(){
		int error = 0;
		while (error == 0){
			System.out.println("¿In what room is the pet?");
			System.out.println(myLittlePet.occupiedRooms());
			int option = reader.nextInt();
			reader.nextLine();
			if(myLittlePet.getRooms().length < option || myLittlePet.roomOccupied(option-1) == false){
				System.out.println("This room are not available");
			}
			else{
				System.out.println(myLittlePet.contactOwner(option));
				error = 1;
			}
		}
	}
	
	/**
	*to discharge a pet that is hopitalized
	*/
	public void dischargePet(){
		if(!myLittlePet.availableRoom()){
			System.out.println("There is not pets hospitalized");
		}
		else{
		int error = 0;
		while (error == 0){
			System.out.println("¿In what room is the pet?");
			System.out.println(myLittlePet.occupiedRooms());
			int option = reader.nextInt();
			reader.nextLine();
			if(myLittlePet.roomOccupied(option-1) == false){
				System.out.println("There is no pet in this room");
			}
			else{
				System.out.println("Day of exit:");
				int todayDay = reader.nextInt();
				reader.nextLine();
				System.out.println("Month of exit:");
				int todayMonth = reader.nextInt();
				reader.nextLine();
				System.out.println("Year of exit:");
				int todayYear = reader.nextInt();
				reader.nextLine();
				Date today = new Date(todayDay, todayMonth, todayYear);
				myLittlePet.exitDate(option, today);
				System.out.println(myLittlePet.roomReport(option));
				myLittlePet.statusHistory(option, false);
				myLittlePet.addHistorys(myLittlePet.getRooms()[option-1].getHistory());
				myLittlePet.availabilityRoom(option, true);
				myLittlePet.getRooms()[option-1].setHistory(null);
				System.out.println("The pet was discharge successfully");
				error = 1;
			}
		}
		}
	}
	
	/**
	*to know the number of room that is occupied by a pet
	*/
	public void roomPet(){
		System.out.println("¿What is the name of the pet?");
		String theName = reader.nextLine();
		System.out.println("¿What is the identifier of the owner?");
		String theIdentifier = reader.nextLine();
		if(myLittlePet.numberRoom(theIdentifier, theName) != 0){
			System.out.println("The pet is in the room #"+myLittlePet.numberRoom(theIdentifier, theName));
		}
		else{
			System.out.println("The pet wasn't founded");
		}
	}
	
	/**
	*to eliminate a pet
	*/
	public void eliminatePet(){
		System.out.println("¿What is the identifier of the owner?");
		String theIdentifier = reader.nextLine();
		if(!myLittlePet.findClient(theIdentifier)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println("¿What pet do you want to hospitalize?");
			System.out.println(myLittlePet.returnClient(theIdentifier).namePets());
			if(!(myLittlePet.returnClient(theIdentifier).namePets().equals("\nThe client don't has pets"))){
			int option = reader.nextInt();
			reader.nextLine();
			String theName = myLittlePet.returnClient(theIdentifier).getPet().get(option-1).getName();
			System.out.println(myLittlePet.eliminatePet(theIdentifier, theName));
			}
		}
	}
	
	/**
	*to eliminate a client
	*/
	public void eliminateClient(){
		System.out.println("¿What is the identifier of the client?");
		String theIdentifier = reader.nextLine();
		if(!myLittlePet.findClient(theIdentifier)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println(myLittlePet.eliminateClient(theIdentifier));
		}
	}
	
	/**
	*to show the clinic history of a pet
	*/
	public void historyPet(){
		System.out.println("¿What is the identifier of the owner?");
		String theIdentifier = reader.nextLine();
		if(!myLittlePet.findClient(theIdentifier)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println("¿From what pet do you want to see the clinic history?");
			System.out.println(myLittlePet.returnClient(theIdentifier).namePets());
			if(!(myLittlePet.returnClient(theIdentifier).namePets().equals("\nThe client don't has pets"))){
			int option = reader.nextInt();
			reader.nextLine();
			String theName = myLittlePet.returnClient(theIdentifier).getPet().get(option-1).getName();
			if(myLittlePet.historyPet(theName, theIdentifier) != null){
			System.out.println(myLittlePet.historyPet(theName, theIdentifier));
			}
			else{
				System.out.println("The pet has not been hospitalized yet");
			}
			}
		}
	}
	
	/**
	*to add only a pet
	*/
	public void addPet(){
		System.out.println("¿What is the identifier of the owner?");
		String theIdentifier = reader.nextLine();
		if(!myLittlePet.findClient(theIdentifier)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println("pet's name:");
			String petName = reader.nextLine();
			int errorType = 0;
			char petType = ' ';
			while(errorType == 0){
				System.out.println("pet's type(c for cat, d for dog, b for bird, o for others):");
				petType = reader.next().charAt(0);
				if(petType == 'c' || petType == 'd' ||petType == 'b' ||petType == 'o'){
					errorType = 1;
				}
			}
			System.out.println("pet's age:");
			int petAge = reader.nextInt();
			reader.nextLine();
			System.out.println("pet's weight:");
			double petWeight = reader.nextDouble();
			reader.nextLine();
			System.out.println("pet's height:");
			double petHeight = reader.nextDouble();
			reader.nextLine();
			Animal temporalPet = new Animal(petName, petType, petAge, petWeight, petHeight, myLittlePet.returnClient(theIdentifier));
			myLittlePet.returnClient(theIdentifier).addPet(temporalPet);
			System.out.println("The pet was added successfully");
		}
	}
}