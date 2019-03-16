package model;
import java.util.ArrayList;

public class Veterinary{
	
	//Relations
	private MiniRoom[] rooms;
	private ArrayList<ClinicHistory> record;
	private ArrayList<HumanClient> customer;
	
	//Constructor
	public Veterinary(MiniRoom[] rooms, ArrayList<ClinicHistory> record, ArrayList<HumanClient> customer){
		this.rooms = rooms;
		this.record = record;
		this.customer = customer;
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
	
}