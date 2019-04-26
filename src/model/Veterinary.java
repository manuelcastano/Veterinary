package model;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
*This is the main class in the model, contains all information for the veterinary
*@author Manuel David Castaño Saldarriaga
*Icesi University<br>
*APO I<br>
*/
public class Veterinary{

	//Relations
	private MiniRoom[] rooms;
	private ArrayList<ClinicHistory> record;
	private ArrayList<HumanClient> customer;
	private ArrayList<Service> theServices;

	/**
	*Veterinary constructor
	*/
	public Veterinary(){
		rooms = new MiniRoom[8];
		record = new ArrayList<ClinicHistory>();
		customer = new ArrayList<HumanClient>();
		theServices = new ArrayList<Service>();
	}

	/**
	*Gets the rooms
	*@return the rooms
	*/
	public MiniRoom[] getRooms(){
		return rooms;
	}
	/**
	*Sets the rooms
	*@param rooms the rooms
	*/
	public void setRooms(MiniRoom[] rooms){
		this.rooms = rooms;
	}
	
	/**
	*Gets the record of clinic histories
	*@return the record of clinic histories
	*/
	public ArrayList<ClinicHistory> getRecord(){
		return record;
	}
	/**
	*Sets the record of clinic histories
	*@param record the record of clinic histories
	*/
	public void setRecord(ArrayList<ClinicHistory> record){
		this.record = record;
	}
	
	/**
	*Gets the human clients
	*@return the customers
	*/
	public ArrayList<HumanClient> getCustomer(){
		return customer;
	}
	/**
	*Sets the customers
	*@param customer the human clients
	*/
	public void setCustomer(ArrayList<HumanClient> customer){
		this.customer = customer;
	}
	
	/**
	*Gets the services
	*@return the services
	*/
	public ArrayList<Service> getTheServices(){
		return theServices;
	}
	/**
	*Sets the services
	*@param theServices the services
	*/
	public void setTheServices(ArrayList<Service> theServices){
		this.theServices = theServices;
	}
	
	/**
	*To add new clients
	*@param client1 the new client
	*/
	public void addClients(HumanClient client1){
		customer.add(client1);
	}
	
	/**
	*To add new clinic histories to the record
	*@param history1 the new clinic history to add
	*/
	public void addHistorys(ClinicHistory history1){
		record.add(history1);
	}
	
	/**
	*To add new services
	*@param newService the service to add
	*/
	public void addTheServices(Service newService){
		theServices.add(newService);
	}

	/**
	*To check if a client is already registered
	*@param identifier the identifier of the client
	*@return a boolean indicates if the client is already registered or not
	*/
	public boolean findClient(String identifier){
		boolean clientFinded = false;
		for(int i = 0; !clientFinded && i < customer.size(); i++){
			if(identifier.equals(customer.get(i).getIdentifier())){
				clientFinded = true;
				}
		}
		return clientFinded;
	}

	/**
	*to return the client
	*@param identifier the identifier of the customer
	*@return the client that is wanted
	*/
	public HumanClient returnClient(String identifier){
		HumanClient client1 = null;
		boolean clientFinded = false;
		if(findClient(identifier)){
			for(int i = 0; !clientFinded && i < customer.size(); i++){
				if(identifier.equals(customer.get(i).getIdentifier())){
					client1 = customer.get(i);
					clientFinded = true;
				}
			}
		}
		return client1;
	}

	/**
	*To return is there is a room available
	*@return a boolean indicates if there is a room available or not
	*/
	public boolean availableRoom(){
		boolean isAvailable = false;
		for(int i = 0; !isAvailable && i < rooms.length; i++){
			if(rooms[i].getAvailability() == true){
				isAvailable = true;
			}
		}
		return isAvailable;
	}

	/**
	*to hospitalize a pet
	*@param history1 the clinic history of the pet to hospitalize
	*/
	public void hospitalizeAPet(ClinicHistory history1){
		boolean roomAvailable = false;
		for(int i = 0; !roomAvailable && i < rooms.length; i++){
			if(rooms[i].getAvailability() == true){
				rooms[i].setAvailability(false);
				rooms[i].setHistory(history1);
				roomAvailable = true;
			}
		}
	}
	
	/**
	*to get the report of the hopitalized pets
	*@return the report of the clinic histories of the hospitalized pets
	*/
	public String report(){
		String msg = "";
		if(!availableRoom()){
			msg = "There is not pets hospitalized";
		}
		else{
		for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getAvailability() == false){
				msg += "--------------------------";
				msg += rooms[i].report();
			}
		}
		}
		return msg;
	}
	
	/**
	*to return if the room is occupied
	*@param number the number of the room
	*@return a boolean indicates if the room is occupied or not
	*/
	public boolean roomOccupied(int number){
		boolean available = false;
		if(rooms[number].getAvailability() == false){
			available = true;
		}
		return available;
	}
	
	/**
	*to return the rooms that are occupied in this moment
	*@return the rooms occupied
	*/
	public String occupiedRooms(){
		String msg = "";
        for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getAvailability() == false){
				msg += "\n"+rooms[i].getNumber()+". "+"If the pet is in the room "+rooms[i].getNumber();
			}
		}
		return msg;		
	}
	
	/**
	*to get the contact details of the owner
	*@param number the number of the room
	*@return the contact details of the pet's owner 
	*/
	public String contactOwner(int number){
		return rooms[number-1].contactOwner();
	}
	
	/**
	*to get the report of a specific room
	*@param position the number of the room
	*@return the report of the clinic history
	*/
	public String roomReport(int position){
		String msg = "";
		msg = rooms[position-1].report();
		return msg;
	}
	
	/**
	*to set the status of the clinic history
	*@param position the number of the room
	*@param status the new status of the clinic history
	*/
	public void statusHistory(int position, boolean status){
		rooms[position-1].statusHistory(status);
	}
	
	/**
	*to set the exit date
	*@param position the number of the room
	*@param exitDate the exit date of the pet
	*/
	public void exitDate(int position, Date exitDate){
		rooms[position-1].exitDate(exitDate);
	}
	
	/**
	*to set the availability of a room
	*@param position the number of the room
	*@param available the availability of the room
	*/
	public void availabilityRoom(int position, boolean available){
		rooms[position-1].setAvailability(available);
	}
	
	/**
	*to see the reports from record of clinic histories
	*@return the roports of the clinic histories in the record
	*/
	public String reportsRecord(){
		String msg = "";
		if(record.isEmpty()){
			msg += "There is not clinic histories";
		}
		else{
			for(int i = 0; i < record.size(); i++){
			msg += record.get(i).report();
		}
		}
		return msg;
	}
	
	/**
	*to get the earnings from hospitalization service
	*@return the earnings from the hospitalization service
	*/
	public double hospitalizationEarnings(){
		double earns = 0.0;
		for(int i = 0; i < record.size(); i++){
			earns += record.get(i).hospitalizationCost();
		}
		for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getAvailability() == false){
				earns += rooms[i].hospitalizationCosts();
			}
		}
		return earns;
	}
	
	/**
	*to get the number of room that is occupied by a pet
	*@param identifier the identifier of the owner
	*@param name the pet's name
	*@return the number of the room occupied by the pet
	*/
	public int numberRoom(String identifier, String name){
		int number = 0;
		boolean finded = false;
		for(int i = 0; !finded && i < rooms.length; i++){
			if(rooms[i].getHistory() != null && rooms[i].samePet(identifier, name) == true){
				number = rooms[i].getNumber();
				finded = true;
			}
		}
		return number;
	}
	
	/**
	*to eliminate a pet
	*@param identifier the identifier of the owner
	*@param theName the name of the pet
	*@return a text indicates if the pet was eliminated successfuly or not
	*/
	public String eliminatePet(String identifier, String theName){
		String msg = "";
		for(int i = 0; i < customer.size(); i++){
			if(customer.get(i).getIdentifier().equals(identifier)){
				msg = customer.get(i).eliminatePet(theName);
			}
		}
		return msg;
	}
	
	/**
	*eliminate a client
	*@param identifier the identifier of the owner
	*@return a text indicates if the client was eliminated successfuly or not
	*/
	public String eliminateClient(String identifier){
		String msg = "";
		for(int i = 0; i < customer.size(); i++){
			if(customer.get(i).getIdentifier().equals(identifier)){
				customer.remove(i);
				msg = "The client was eliminate successfuly";
			}
		}
		return msg;
	}
	
	/**
	*to return the clinic historys of a pet
	*@param name the name of the pet
	*@param identifier the identifier of the owner
	*@return the clinic history of the pet
	*/
	public String historyPet(String name, String identifier){
		String msg = "";
		for(int i = 0; i < record.size(); i++){
			if(record.get(i).namePet().equals(name) && record.get(i).identifierOwner().equals(identifier)){
				msg += record.get(i).report();
			}
		}
		for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getHistory() != null && rooms[i].getHistory().namePet().equals(name) && rooms[i].getHistory().identifierOwner().equals(identifier)){
				msg += rooms[i].getHistory().report();
			}
		}
		return msg;
	}
	/**
	*to show the info of the pet
	*@param name the name of the pet
	*@param identifier the identifier of the pet
	*@return a message with the pet's information
	*/
	public String infoPet(String identifier, String name){
		String msg = "";
		boolean clientFinded = false;
		for(int i = 0; !clientFinded && i < customer.size(); i++){
			if(customer.get(i).getIdentifier().equals(identifier)){
				msg = customer.get(i).infoPet(name);
				clientFinded = true;
			}
		}
		return msg;
	}
	
	/**
	*to update the information of the client
	*@param identifier the identifier of the customer
	*@param address the new address of the client
	*@param phoneNumber the new phone number of the client
	*/
	public void updateData(String identifier, String address, String phoneNumber){
		boolean clientFinded = false;
		for(int i = 0; !clientFinded && i < customer.size(); i++){
			if(customer.get(i).getIdentifier().equals(identifier)){
				customer.get(i).updateData(address, phoneNumber);
				clientFinded = true;
			}
		}
	}
	
	/**
	*to add new medicines to the clinic history
	@param number the number of the room that are the pet
	*@param name The medicine name. This param must be not null.
	*@param dose The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
	*@param costDose The medicine cost by each dose. This param could be empty.
	*@param frequency The frequency of medicine application. This param could be empty.
	*@return A message that indiques if medicine was added to the patient clinic story
	*/
	public String addMedicines(int number, String name, double dose, double costDose, double frequency){
		String msg = "";
		boolean roomFinded = false;
		for(int i = 0; !roomFinded && i < rooms.length; i++){
			if(rooms[i].getNumber() == number){
				msg = rooms[i].addMedicines(name, dose, costDose, frequency);
				roomFinded = true;
			}
		}
		return msg;
	}
	
	/**
	*to add new notes to the possible diagnostic of a hospitalized pet
	@param diagnostic the new notes to the diagnostic
	@param number the number of the room that are the pet
	*/
	public void addNotes(String diagnostic, int number){
		boolean roomFinded = false;
		for(int i = 0; !roomFinded && i < rooms.length; i++){
			if(rooms[i].getNumber() == number){
				rooms[i].addNotes(diagnostic);
				roomFinded = true;
			}
		}
	}
	
	/**
	*to add new symptom to the clinic history of a hospitalized pet
	@param symptom the new symptom to add
	@param number the number of the room that are the pet
	*/
	public void addSymptom(String symptom, int number){
		boolean roomFinded = false;
		for(int i = 0; !roomFinded && i < rooms.length; i++){
			if(rooms[i].getNumber() == number){
				rooms[i].addSymptom(symptom);
				roomFinded = true;
			}
		}
	}
	
	/**
	*to calculate the earnings froms the services
	@return the earnings from the services
	*/
	public double servicesEarnings(){
		double earnings = 0.0;
		for(int i = 0; i < theServices.size(); i++){
			earnings += theServices.get(i).getCost();
		}
		return earnings;
	}
	
	/**
	*to calculate the total earnings of the veterinary
	*@return the total earnings with the service earnings end hospitalization earnings
	*/
	public double totalEarnings(){
		return hospitalizationEarnings() + servicesEarnings();
	}
	
	/**
	*to calculate the average earnings from the services
	*@return the average earnings from the services
	*/
	public double averageServices(){
		return servicesEarnings()/theServices.size();
	}
	
	/**
	*to calculate the average earnings in a week
	*@param firstDayofTheWeek the begin of the week
	@return the average earnings in a week
	*/
	public double averageEarningsWeek(Date firstDayofTheWeek){
		int servicesInThatWeek = 0;
		int days = 0;
		GregorianCalendar date = new GregorianCalendar(firstDayofTheWeek.getYear(), firstDayofTheWeek.getMonth() - 1, firstDayofTheWeek.getDay());
		GregorianCalendar firstDate = new GregorianCalendar(0, 0, 1);//First day in the history of our calendar
		while (true) {
			if ((date.get(Calendar.DAY_OF_MONTH) == firstDate.get(Calendar.DAY_OF_MONTH))
				&& (date.get(Calendar.MONTH) == firstDate.get(Calendar.MONTH))
			    && (date.get(Calendar.YEAR) == firstDate.get(Calendar.YEAR))){
				break;
			}
			firstDate.add(Calendar.DAY_OF_MONTH, 1);
			days++;
		}
		int finalWeek = days+7;//the end of the week
		double averageEarnings = 0.0;
		for(int i = 0; i < theServices.size(); i++){
			if(theServices.get(i).realizationDate() >= days && theServices.get(i).realizationDate() <= finalWeek){
				servicesInThatWeek++;
				averageEarnings += theServices.get(i).getCost();
			}
		}
		return averageEarnings/servicesInThatWeek;
	}
	
	/**
	*to get the reports of the services realized between two dates
	*@param beginDate the first date
	*@param finalDate the finish date
	*@return a message with the reports of the services realized between that days
	*/
	public String reportServices(Date beginDate, Date finalDate){
		String msg = "";
		int daysBegin = 0;
		GregorianCalendar dateBegin = new GregorianCalendar(beginDate.getYear(), beginDate.getMonth() - 1, beginDate.getDay());
		GregorianCalendar firstDate = new GregorianCalendar(0, 0, 1);//First day in the history of our calendar
		while (true) {
			if ((dateBegin.get(Calendar.DAY_OF_MONTH) == firstDate.get(Calendar.DAY_OF_MONTH))
				&& (dateBegin.get(Calendar.MONTH) == firstDate.get(Calendar.MONTH))
			    && (dateBegin.get(Calendar.YEAR) == firstDate.get(Calendar.YEAR))){
				break;
			}
			firstDate.add(Calendar.DAY_OF_MONTH, 1);
			daysBegin++;
		}
		int finalDays = 0;
		GregorianCalendar dateFinal = new GregorianCalendar(finalDate.getYear(), finalDate.getMonth() - 1, finalDate.getDay());
		GregorianCalendar firstDay = new GregorianCalendar(0, 0, 1);//First day in the history of our calendar
		while (true) {
			if ((dateFinal.get(Calendar.DAY_OF_MONTH) == firstDay.get(Calendar.DAY_OF_MONTH))
				&& (dateFinal.get(Calendar.MONTH) == firstDay.get(Calendar.MONTH))
			    && (dateFinal.get(Calendar.YEAR) == firstDay.get(Calendar.YEAR))){
				break;
			}
			firstDay.add(Calendar.DAY_OF_MONTH, 1);
			finalDays++;
		}
		for(int i = 0; i < theServices.size(); i++){
			if(theServices.get(i).realizationDate() >= daysBegin && theServices.get(i).realizationDate() <= finalDays){
				msg += theServices.get(i).toString();
			}
		}
		return msg;
	}
}
