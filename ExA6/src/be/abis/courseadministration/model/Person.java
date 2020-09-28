package be.abis.courseadministration.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private int personNumber;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Company company;
	
	
	
	
	public Person(int personNumber, String firstName, String lastName, LocalDate birthDate) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDate, Company company) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.company = company;
	}
	
	public int getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	private Company getCompany() {
		return this.company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	 public int calculateAge(){
	        if(this.birthDate != null){
	          return Period.between(this.birthDate,LocalDate.now()).getYears();
	        }
	        return 0;
	    }

	public String printInfo() {
		StringBuilder info = new StringBuilder();
		info.append("Person + (" + this.personNumber + ")");
		info.append("\n---------------------------------------\n");
		info.append(this.getFirstName() + " " + this.getLastName());
		info.append("\n");
		info.append("Age  : " + this.calculateAge());
		info.append("\n");
		info.append("Company : " + (this.getCompany() != null ? this.company.toString() : "" ));
		
		return info.toString();
	}
	
	@Override
	public String toString() {
		return "Person personNumber=" + personNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", company=" + company + "";
	}
	
	
}
