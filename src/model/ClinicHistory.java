package model;
import java.util.ArrayList;

public class ClinicHistory {
	
	//attributes
	private boolean status;
	private String symptoms;
	private String diagnostic;
	
	//relations
	private Animal data;
	private ArrayList<Medicine> drug;
	private Date joinDate;
	private Date exitDate;
	
	//constructor
	public ClinicHistory(boolean status, String symptoms, String diagnostic, Animal data, ArrayList<Medicine> drug, Date joinDate, Date exitDate){
		this.status = status;
		this.symptoms = symptoms;
		this.diagnostic = diagnostic;
		this.data = data;
		this.drug = drug;
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
	public void setDate(Animal data){
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
}