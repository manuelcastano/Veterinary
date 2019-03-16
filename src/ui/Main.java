package ui;
import model.*;
import java.util.ArrayList;

public class Main {
	
	//relations
	private Veterinary myLittlePet;
	
	public Main(){
		init();
	}
	
	public static void main(String[] args){
		Main m = new Main();
	}
	
	public void init(){
		Date joinDate1 = new Date(21, 3, 2019);
		Date exitDate1 = new Date(25, 3, 2019);
		Date joinDate2 = new Date(25, 6, 2018);
		Medicine drug1 = new Medicine("acetaminophen", 1.5, 2.35, 8.5);
		Medicine drug2 = new Medicine("complex b", 4.5, 5, 10);
		Medicine drug3 = new Medicine("dolex", 1, 1, 7.5);
		Medicine drug4 = new Medicine("fencafen", 4.5, 10.6, 11.4);
		Animal animal1 = new Animal("Firulais", 'D', 6, 25.8, client1);
		HumanClient client1 = new HumanClient("Tomas", 144921651, "cra 40b #45-60", 315181616, new ArrayList<Animal>(animal1));
		ClinicHistory history1 = new ClinicHistory(true, "The patient presents pain when walking", "He has broken the heel of Achilles", animal1, new ArrayList<Medicine>(drug1, drug2), joinDate1, exitDate1);
	}
}