package model;
import java.util.ArrayList;

public class Veterinary{

	//Relations
	private MiniRoom[] rooms;
	private ArrayList<ClinicHistory> record;
	private ArrayList<HumanClient> customer;

	//Constructor
	public Veterinary(){
		rooms = new MiniRoom[8];
		record = new ArrayList<ClinicHistory>();
		customer = new ArrayList<HumanClient>();
	}

	//get's and set's
	public MiniRoom[] getRooms(){
		return rooms;
	}
	public void setRooms(MiniRoom[] rooms){
		this.rooms = rooms;
	}

	public ArrayList<ClinicHistory> getRecord(){
		return record;
	}
	public void setRecord(ArrayList<ClinicHistory> record){
		this.record = record;
	}

	public ArrayList<HumanClient> getCustomer(){
		return customer;
	}
	public void setCustomer(ArrayList<HumanClient> customer){
		this.customer = customer;
	}

	public void addClients(HumanClient client1){
		customer.add(client1);
	}

	public void addHistorys(ClinicHistory history1){
		record.add(history1);
	}

	//to find a client
	public boolean findClient(String identifier){
		boolean clientFinded = false;
		for(int i = 0; !clientFinded && i < customer.size(); i++){
			if(identifier.equals(customer.get(i).getIdentifier())){
				clientFinded = true;
				}
		}
		return clientFinded;
	}

	//to return the client
	public HumanClient returnClient(String identifier){
		HumanClient client1 = null;
		boolean clientFinded = false;
		if(findClient(identifier) == true){
			for(int i = 0; !clientFinded && i < customer.size(); i++){
				if(identifier.equals(customer.get(i).getIdentifier())){
					client1 = customer.get(i);
					clientFinded = true;
				}
			}
		}
		return client1;
	}

	//to find the position in the ArrayList of the customer
	public int positionCustomer(String identifier){
		int position = 0;
		boolean clientFinded = false;
		if(findClient(identifier) == true){
			for(int i = 0; !clientFinded && i < customer.size(); i++){
				if(identifier.equals(customer.get(i).getIdentifier())){
					position = i;
					clientFinded = true;
				}
			}
		}
		return position;
	}

	//to return if a room is available
	public boolean availableRoom(){
		boolean isAvailable = false;
		for(int i = 0; !isAvailable && i < rooms.length; i++){
			if(rooms[i].getAvailability() == true){
				isAvailable = true;
			}
		}
		return isAvailable;
	}

	//to hospitalize a pet
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
	
	//to get the report of the hopitalized pets
	public String report(){
		String msg = "";
		if(numberRoomsAvailable() == 8){
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
	
	//to return if the room is occupied
	public boolean roomOccupied(int number){
		boolean available = false;
		if(rooms[number].getAvailability() == false){
			available = true;
		}
		return available;
	}
	
	//to return the rooms that are occupied in this moment
	public String occupiedRooms(){
		String msg = "";
        for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getAvailability() == false){
				msg += "\n"+rooms[i].getNumber()+". "+"If the pet is in the room "+rooms[i].getNumber();
			}
		}
		return msg;		
	}
	
	//to get the contact details of the owner
	public String contactOwner(int number){
		return rooms[number-1].contactOwner();
	}
	
	//to get the report of one room
	public String roomReport(int position){
		String msg = "";
		msg = rooms[position-1].report();
		return msg;
	}
	
	//to set the status of the clinic history
	public void statusHistory(int position, boolean status){
		rooms[position-1].statusHistory(status);
	}
	
	//to set the exit date
	public void exitDate(int position, Date exitDate){
		rooms[position-1].exitDate(exitDate);
	}
	
	//to get the number of rooms that are occupied
	public int numberRoomsAvailable(){
		int total = 0;
		for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getAvailability() == true){
				total++;
			}
		}
		return total;
	}
	
	//to set the availability of a room
	public void availabilityRoom(int position, boolean available){
		rooms[position-1].setAvailability(available);
	}
	
	//to see the reports from record of clinic histories
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
	
	//to get the earnings from hospitalization
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
	
	//to get the number of room that is occupied by a pet
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
	
	//to eliminate a pet
	public String eliminatePet(String identifier, String theName){
		String msg = "";
		for(int i = 0; i < customer.size(); i++){
			if(customer.get(i).getIdentifier().equals(identifier)){
				msg = customer.get(i).eliminatePet(theName);
			}
		}
		return msg;
	}
	
	//eliminate a client
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
	
	//to return the clinic historys of a pet
	public String historyPet(String name, String identifier){
		String msg = "";
		for(int i = 0; i < record.size(); i++){
			if(record.get(i).namePet().equals(name) && record.get(i).ownerIdentifier().equals(identifier)){
				msg += record.get(i).report();
			}
		}
		for(int i = 0; i < rooms.length; i++){
			if(rooms[i].getHistory() != null && rooms[i].getHistory().namePet().equals(name) && rooms[i].getHistory().ownerIdentifier().equals(identifier)){
				msg += rooms[i].getHistory().report();
			}
		}
		return msg;
	}
}
