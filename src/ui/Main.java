package ui;
import model.*;
import java.util.Scanner;

/**
*This is the main class, is for the interaction between the user and the program
*@author Manuel David Castaño Saldarriaga
*Icesi University<br>
*APO I<br>
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
	*To show the options that can do the user<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void showMenu(){
		int option = 0;
		while(option != 24){
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
			System.out.println("13. To show the information of a pet");
			System.out.println("14. Update the information of a client");
			System.out.println("15. Add medicine to a clinic history of a hospitalized patient");
			System.out.println("16. Add notes to the diagnostic of a clinic history of a hospitalized patient");
			System.out.println("17. Add new symptom to clinic history of a hospitalized patient");
			System.out.println("18. Show the earnings from the services");
			System.out.println("19. Show the total earnings of the veterinary");
			System.out.println("20. Add a sell service");
			System.out.println("21. Show the average earnings from the services");
			System.out.println("22. Calculate the average earnings in a week");
			System.out.println("23. Show the reports of the services realized between two days");
			System.out.println("24. Exit");
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
				infoPet();
				break;
				case(14):
				updateInfo();
				break;
				case(15):
				addMedicines();
				break;
				case(16):
				addNotes();
				break;
				case(17):
				addSymptom();
				break;
				case(18):
				System.out.println("The earnings from the services are "+myLittlePet.servicesEarnings());
				break;
				case(19):
				System.out.println("The total earnings of the veterinary are "+myLittlePet.totalEarnings());
				break;
				case(20):
				sellService();
				break;
				case(21):
				System.out.println("The average earnings from the services are "+myLittlePet.averageServices());
				break;
				case(22):
				averageEarnings();
				break;
				case(23):
				reportServices();
				break;
				case(24):
				break;
				default:
				System.out.println("Enter a valid number");
				break;
			}
		}
	}
	
	/**
	*To initialize default objects to check the funcionality of the program<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void init(){
		myLittlePet = new Veterinary();
		Date joinDate1 = new Date(21, 3, 2019);
		Date exitDate1 = new Date(25, 3, 2019);
		Date joinDate2 = new Date(25, 6, 2018);
		Date dateService1 = new Date(23, 7, 2014);
		Date dateService2 = new Date(15, 8, 2017);
		Date dateService3 = new Date(11, 9, 2018);
		Medicine drug1 = new Medicine("acetaminophen", 1.5, 2.35, 8.5);
		Medicine drug2 = new Medicine("complex b", 4.5, 5, 10);
		Medicine drug3 = new Medicine("dolex", 1, 1, 7.5);
		Medicine drug4 = new Medicine("fencafen", 4.5, 10.6, 11.4);
		HumanClient client1 = new HumanClient("Tomas", "4646464646", "cra 40b #45-60", "315181616");
		HumanClient client2 = new HumanClient("Fernanda", "125465631", "cra 45a #85-99", "315464661");
		Animal animal1 = new Animal("Firulais", 'd', 6, 25.8, 1.2, client1);
		Animal animal2 = new Animal("Dante", 'd', 2, 1.6, 0.7, client2);
		Animal animal3 = new Animal("Manchas", 'c', 10, 20.5, 1.5, client1);
		Animal animal4 = new Animal("Piter", 'o', 5, 50.2, 1, client2);
		client1.addPet(animal1);
		client1.addPet(animal3);
		client2.addPet(animal2);
		client2.addPet(animal4);
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
		myLittlePet.setRooms(temporalRooms);
		myLittlePet.addHistorys(history1);
		myLittlePet.addClients(client1);
		myLittlePet.addClients(client2);
		Service service1 = new Service(Service.PET_SHOWER_V, dateService1, animal4);
		Service service2 = new Service(Service.PET_SHOWER_D, dateService2, animal2);
		Service service3 = new Service(Service.NAIL_CUT, dateService3, animal1);
		myLittlePet.addTheServices(service1);
		myLittlePet.addTheServices(service2);
		myLittlePet.addTheServices(service3);
	}

	/**
	*To add new customers and their pets<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to hospitalize a pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to consult the contact details of the owner<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to discharge a pet that is hopitalized<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to know the number of room that is occupied by a pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to eliminate a pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to eliminate a client<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to show the clinic history of a pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	*to add only a pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
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
	
	/**
	*to show the information of a pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void infoPet(){
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
				System.out.println(myLittlePet.infoPet(theIdentifier, theName));
			}
		}
	}
	
	/**
	*to update the information(address and phone number) of the client<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void updateInfo(){
		System.out.println("¿What is the identifier of the client?");
		String theIdentifier = reader.nextLine();
		if(!myLittlePet.findClient(theIdentifier)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println("¿What is the new address of the client?");
			String address = reader.nextLine();
			System.out.println("¿What is the new phone number of the client?");
			String phoneNumber = reader.nextLine();
			myLittlePet.updateData(theIdentifier, address, phoneNumber);
		}
	}
	
	/**
	*to add new medicines to a clinic history of a hospitalized pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void addMedicines(){
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
				System.out.println("¿How many medicines do you want to add?");
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
					myLittlePet.addMedicines(option, theName, theDoses, costByDose, theFrequency);
				}
				error = 1;
			}
		}
	}
	
	/**
	*to add new notes to the possible diagnostic of a hospitalized pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void addNotes(){
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
				System.out.println("¿What is the new diagnostic?");
				String notes = reader.nextLine();
				myLittlePet.addNotes(notes, option);
				error = 1;
			}
		}
	}
	
	/**
	*to add new symptom to the clinic history of a hospitalized pet<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void addSymptom(){
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
				System.out.println("¿What is the new symptom?");
				String symptom = reader.nextLine();
				myLittlePet.addSymptom(symptom, option);
				error = 1;
			}
		}
	}
	
	/**
	*to add a new sell service<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void sellService(){
		int errorType = 0;
		String serviceType = "";
		while(errorType == 0){
			System.out.println("Service type\n1. Pet bath in the veterinary\n2. Pet bath at home\n3. Nail cutting\n4. Dental prophylaxis\n5. Vaccine aplication");
			int type = reader.nextInt();
			reader.nextLine();
			if(type == 1){
				serviceType = Service.PET_SHOWER_V;
			}
			else if(type == 2){
				serviceType = Service.PET_SHOWER_D;
			}
			else if(type == 3){
				serviceType = Service.NAIL_CUT;
			}
			else if(type == 4){
				serviceType = Service.DENTAL;
			}
			else if(type == 5){
				serviceType = Service.VACCINATIONS;
			}
			if(serviceType.equals(Service.PET_SHOWER_V) ||serviceType.equals(Service.PET_SHOWER_D) || serviceType.equals(Service.NAIL_CUT) || serviceType.equals(Service.DENTAL) || serviceType.equals(Service.VACCINATIONS)){
				errorType = 1;
			}
		}
		System.out.println("realization day: ");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("realization month: ");
		int month = reader.nextInt();
		reader.nextLine();
		System.out.println("realization year: ");
		int year = reader.nextInt();
		reader.nextLine();
		Date realization = new Date(day, month, year);
		System.out.println("¿What is the identifier of the owner?");
		String theIdentifier = reader.nextLine();
		Animal patient = null;
		if(!myLittlePet.findClient(theIdentifier)){
			System.out.println("The client doesn't exist");
		}
		else{
			System.out.println("¿Who was the patient?");
			System.out.println(myLittlePet.returnClient(theIdentifier).namePets());
			int option = reader.nextInt();
			reader.nextLine();
			patient = myLittlePet.returnClient(theIdentifier).getPet().get(--option);
		}
		Service toAdd = new Service(serviceType, realization, patient);
		myLittlePet.addTheServices(toAdd);
		System.out.println("The service were added successfully");
	}
	
	/**
	*to calculate the average earnings in a week<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void averageEarnings(){
		System.out.println("first day in the week: ");
		int day = reader.nextInt();
		reader.nextLine();
		System.out.println("month: ");
		int month = reader.nextInt();
		reader.nextLine();
		System.out.println("year: ");
		int year = reader.nextInt();
		reader.nextLine();
		Date week = new Date(day, month, year);
		System.out.println("The average earnings in that week are "+myLittlePet.averageEarningsWeek(week));
	}
	
	/**
	*To show the reports of the services realized between two dates<br>
	*pre: the Scanner and the veterinary must be initialized<br>
	*/
	public void reportServices(){
		System.out.println("Begin date:");
		System.out.println("Day:");
		int beginDay = reader.nextInt();
		reader.nextLine();
		System.out.println("Month:");
		int beginMonth = reader.nextInt();
		reader.nextLine();
		System.out.println("Year:");
		int beginYear = reader.nextInt();
		reader.nextLine();
		System.out.println("Final date:");
		System.out.println("Day:");
		int finalDay = reader.nextInt();
		reader.nextLine();
		System.out.println("Month:");
		int finalMonth = reader.nextInt();
		reader.nextLine();
		System.out.println("Year:");
		int finalYear = reader.nextInt();
		reader.nextLine();
		Date begin = new Date(beginDay, beginMonth, beginYear);
		Date finish = new Date(finalDay, finalMonth, finalYear);
		System.out.println(myLittlePet.reportServices(begin, finish));
	}
}