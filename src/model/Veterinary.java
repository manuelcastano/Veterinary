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
}