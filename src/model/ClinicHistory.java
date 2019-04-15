package model;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class ClinicHistory {

	//attributes
	private boolean status;//true if the pet is hospitalized
	private String symptoms;
	private String diagnostic;

	//relations
	private Animal data;
	private ArrayList<Medicine> drug;
	private Date joinDate;
	private Date exitDate;

	//constructor
	public ClinicHistory(boolean status, String symptoms, String diagnostic, Animal data, Date joinDate, Date exitDate){
		this.status = status;
		this.symptoms = symptoms;
		this.diagnostic = diagnostic;
		this.data = data;
		drug = new ArrayList<Medicine>();
		this.joinDate = joinDate;
		this.exitDate = exitDate;
	}

	//get's and set's
	public boolean getStatus(){
		return status;
	}
	public void setStatus(boolean status){
		this.status = status;
	}

	public String getSymptoms(){
		return symptoms;
	}
	public void setSymptoms(String symptoms){
		this.symptoms = symptoms;
	}

	public String getDiagnostic(){
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}

	public Animal getData(){
		return data;
	}
	public void setData(Animal data){
		this.data = data;
	}

	public ArrayList<Medicine> getDrug(){
		return drug;
	}
	public void setDrug(ArrayList<Medicine> drug){
		this.drug = drug;
	}

	public Date getJoinDate(){
		return joinDate;
	}
	public void setDate(Date joinDate){
		this.joinDate = joinDate;
	}

	public Date getExitDate(){
		return exitDate;
	}
	public void setExitDate(Date exitDate){
		this.exitDate = exitDate;
	}

	public void addDrugs(Medicine drug1){
		drug.add(drug1);
	}
	
	//to make the report
	public String report(){
		String msg = "";
		msg += "\nThe owner is "+data.nameOwner();
		msg += "\nThe pet is "+data.getName();
		msg += "\n"+data.petType();
		msg += "\nThe symptoms are "+getSymptoms();
		msg += "\nThe diagnostic is "+getDiagnostic();
		msg += "\nThe medicines are:";
		for(int i = 0; i < drug.size(); i++){
			msg += "\n"+drug.get(i).getName();
		}
		if(exitDate == null){
			msg += "\nThe cost of the hospitalization until now is "+hospitalizationCost()+"";
		}
		else{
			msg += "\nThe cost of the hospitalization is "+hospitalizationCost();
		}
		msg += "\nand the pet was admitted on "+joinDate.getDay()+"/"+joinDate.getMonth()+"/"+joinDate.getYear()+"\n";
		return msg;
	}
	
	//to return the contact details of the owner
	public String contactOwner(){
		return data.contactOwner();
	}
	
	//to get the days of hospitalization
	public int daysHospitalized(){
		int days = 0;
		if(exitDate == null){
			GregorianCalendar date = new GregorianCalendar(joinDate.getYear(), joinDate.getMonth() - 1, joinDate.getDay());
			GregorianCalendar actualDate = new GregorianCalendar();
			while (true) {
				if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
					&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
				    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
					break;
				}
				date.add(Calendar.DAY_OF_MONTH, 1);
				days++;
			}
		}
		else{
			GregorianCalendar date = new GregorianCalendar(joinDate.getYear(), joinDate.getMonth() - 1, joinDate.getDay());
			GregorianCalendar actualDate = new GregorianCalendar(exitDate.getYear(), exitDate.getMonth() - 1, exitDate.getDay());
			while (true) {
				if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
					&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
				    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
					break;
				}
				date.add(Calendar.DAY_OF_MONTH, 1);
				days++;
			}
		}
		return days;
	}
	
	//to get the cost of the hospitalization
	public double hospitalizationCost(){
		double theCost = 0.0;
		if(data.getType() == 'c'){
			if(data.getWeight() >= 1.0 && data.getWeight() <= 3.0){
				theCost = 10000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 3.1 && data.getWeight() <= 10.0){
				theCost = 12000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 10.1 && data.getWeight() <= 20.0){
				theCost = 15000.0*daysHospitalized();
			}
			else if (data.getWeight() > 20.0){
				theCost = 20000.0*daysHospitalized();
			}
		}
		else if(data.getType() == 'd'){
			if(data.getWeight() >= 1.0 && data.getWeight() <= 3.0){
				theCost = 15000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 3.1 && data.getWeight() <= 10.0){
				theCost = 17000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 10.1 && data.getWeight() <= 20.0){
				theCost = 20000.0*daysHospitalized();
			}
			else if (data.getWeight() > 20.0){
				theCost = 25000.0*daysHospitalized();
			}
		}
		else if(data.getType() == 'b'){
			if(data.getWeight() >= 1.0 && data.getWeight() <= 3.0){
				theCost = 10000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 3.1 && data.getWeight() <= 10.0){
				theCost = 12000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 10.1 && data.getWeight() <= 20.0){
				theCost = 20000.0*daysHospitalized();
			}
			else if (data.getWeight() > 20.0){
				theCost = 25000.0*daysHospitalized();
			}
		}
		else if(data.getType() == 'o'){
			if(data.getWeight() >= 1.0 && data.getWeight() <= 3.0){
				theCost = 10000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 3.1 && data.getWeight() <= 10.0){
				theCost = 17000.0*daysHospitalized();
			}
			else if (data.getWeight() >= 10.1 && data.getWeight() <= 20.0){
				theCost = 30000.0*daysHospitalized();
			}
			else if (data.getWeight() > 20.0){
				theCost = 33000.0*daysHospitalized();
			}
		
		}
		for(int i = 0; i < drug.size(); i++){
			theCost += drug.get(i).costMedicine();
		}
		return theCost;
	}
	
	//to return the identifier of the owner of the pet
	public String identifierOwner(){
		return data.identifierOwner();
	}
	
	//to return the name of the pet
	public String namePet(){
		return data.getName();
	}
	
}
