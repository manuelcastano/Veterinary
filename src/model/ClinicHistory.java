package model;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
*This class contains the information of the clinic history of a pet
*@author Manuel David Castaño Saldarriaga
*Icesi University<br>
*APO I<br>
*/
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

	/**
	*ClinicHistory constructor
	*@param status the status of the history. this param must be not null.
	*@param symptoms the symptomsof the pet. this param must be not null.
	*@param diagnostic the diagnostic of the pet. this param must be not null.
	*@param data the pet. this param must be not null.
	*@param joinDate the hospitalized day . this param must be not null.
	*@param exitDate the discharge date. this param could be null.
	*/
	public ClinicHistory(boolean status, String symptoms, String diagnostic, Animal data, Date joinDate, Date exitDate){
		this.status = status;
		this.symptoms = symptoms;
		this.diagnostic = diagnostic;
		this.data = data;
		drug = new ArrayList<Medicine>();
		this.joinDate = joinDate;
		this.exitDate = exitDate;
	}

	/**
	*Gets the status
	*@return the status of the history
	*/
	public boolean getStatus(){
		return status;
	}
	/**
	*Sets the status
	*@param status the history's status
	*/
	public void setStatus(boolean status){
		this.status = status;
	}
	
	/**
	*Gets the symptoms
	*@return the symptoms of the pet
	*/
	public String getSymptoms(){
		return symptoms;
	}
	/**
	*Sets the symptoms
	*@param symptoms the symptoms of the pet
	*/
	public void setSymptoms(String symptoms){
		this.symptoms = symptoms;
	}
	
	/**
	*Gets the diagnostic
	*@return the clinic diagnostic
	*/
	public String getDiagnostic(){
		return diagnostic;
	}
	/**
	*Sets the diagnostic
	*@param diagnostic the clinic diagnostic
	*/
	public void setDiagnostic(String diagnostic){
		this.diagnostic = diagnostic;
	}
	
	/**
	*Gets the pet
	*@return the pet
	*/
	public Animal getData(){
		return data;
	}
	/**
	*Sets the pet
	*@param data the pet
	*/
	public void setData(Animal data){
		this.data = data;
	}
	
	/**
	*Gets the medicines
	*@return the medicines
	*/
	public ArrayList<Medicine> getDrug(){
		return drug;
	}
	/**
	*Set the medicines
	*@param drug the medicines
	*/
	public void setDrug(ArrayList<Medicine> drug){
		this.drug = drug;
	}
	
	/**
	*Gets the join date
	*@return the join date
	*/
	public Date getJoinDate(){
		return joinDate;
	}
	/**
	*Sets the join date
	*@param joinDate the join date
	*/
	public void setDate(Date joinDate){
		this.joinDate = joinDate;
	}
	
	/**
	*Gets the exit date
	*@return the exit date
	*/
	public Date getExitDate(){
		return exitDate;
	}
	/**
	*Sets the exit date
	*@param exitDate the exit date
	*/
	public void setExitDate(Date exitDate){
		this.exitDate = exitDate;
	}
	
	/**
	*To add a new medicine to the clinic history
	*@param drug1 the medicine to add
	*/
	public void addDrugs(Medicine drug1){
		drug.add(drug1);
	}
	
	/**
	*To make a report of the clinic history<br>
	*pre: the clinic history was created before<br>
	*post: the report is made<br>
	*@return the report of the clinic history
	*/
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
	
	/**
	*to return the contact details of the owner<br>
	*pre: the clinic history was created before and the pet must be not null<br>
	*post: the details for contact the owner of the pet<br>
	*@return the details fot contact to the owner
	*/
	public String contactOwner(){
		return data.contactOwner();
	}
	
	/**
	*to calculate the days hospitalized<br>
	*pre: the clinic history was created before and the join date must be not null<br>
	*post: the days hospitalized is calculated<br>
	*@return the days hospitalized
	*/
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
	
	/**
	*to calculate the cost of the hospitalization service
	*@return the cost of the hospitalized service
	*/
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
	
	/**
	*to return the identifier of the owner of the pet<br>
	*pre: the clinic history was created before and the pet must be not null<br>
	*post: the identifier of the owner is delivered<br>
	*@return the identifier of the owner
	*/
	public String identifierOwner(){
		return data.identifierOwner();
	}
	
	/**
	*to return the name of the pet<br>
	*pre: The clinic history was created before end the pet must be not null<br>
	*post: the pet's name is delivered<br>
	*@return the name of the pet
	*/
	public String namePet(){
		return data.getName();
	}
	
	/**
	*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.<br>
	*pre: The patient clinic story must be not null.<br>
	*post: New medicines were added to the patient clinic story.<br>
	*@param name The medicine name. This param must be not null.
	*@param dose The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
	*@param costDose The medicine cost by each dose. This param could be empty.
	*@param frequency The frequency of medicine application. This param could be empty.
	*@return A message that indiques if medicine was added to the patient clinic story
	*/
	public String addMedicines(String name, double dose, double costDose, double frequency){
		String msg = "";
		if(name == null){
			msg += "The name must be not null";
		}
		else{
			Medicine toAdd = new Medicine(name, dose, costDose, frequency);
			addDrugs(toAdd);
			msg += "The medicine was added to the clinic history";
		}
		return msg;
	}
	
	/**
	*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.<br>
	*pre: The patient clinic story must be not null.<br>
	*post: New notes were added to the possible diagnostic in the patient clinic story.<br>
	*@param diagnostic The notes of possible diagnostic. This param must be not null.
	*/
	public void addNotes(String diagnostic){
		this.diagnostic += diagnostic;
	}
	
	/**
	*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.<br>
	*pre: The patient clinic story must be not null.<br>
	*post: A new symptom were added to the patient clinic story.<br>
	*@param symptom The new symptom presented. This param must be not null.
	*/
	public void addSymptoms(String symptom){
		symptoms += symptom;
	}
}
