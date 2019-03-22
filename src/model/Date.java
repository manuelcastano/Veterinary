package model;

public class Date{
	
	//attributes
	private int day;
	private int month;
	private int year;
	
	//constructos
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//get's and set's
	public int getDay(){
		return day;
	}
	public void setDay(int day){
		this.day = day;
	}
	
	public int getMonth(){
		return month;
	}
	public void setMonth(int month){
		this.month = month;
	}
	
	public int getYear(){
		return year;
	}
	public void setYear(int year){
		this.year = year;
	}
}