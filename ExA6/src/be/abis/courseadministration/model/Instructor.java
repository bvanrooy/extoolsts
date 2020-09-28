package be.abis.courseadministration.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Instructor extends Person{

    private int startAge;
	private double startSalary;

    public Instructor(String firstName, String lastName) {
    	super(firstName, lastName);
    }

    public Instructor(String firstName, String lastName, LocalDate birthDate) {
    	super(firstName, lastName, birthDate);
    }
    
    

    public Instructor(String firstName, String lastName, LocalDate birthDate, int startAge, double startSalary) {
    	super(firstName, lastName, birthDate);
		this.startAge = startAge;
		this.startSalary = startSalary;
	}

   

    public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}

	public double getStartSalary() {
		return startSalary;
	}

	public void setStartSalary(double startSalary) {
		this.startSalary = startSalary;
	}
  
 
    
    public ArrayList<String> getSalaryHistory(){
    	int seniority = 0;
        int age = this.startAge;
        double salaryAtAge = this.startSalary;
        String line;
        ArrayList<String> lines = new ArrayList<>();
        
        line = "\n\nInstructor " + this.getFirstName() + " " + this.getLastName() 
            	+ " has " + this.calculateAge() 
            	+ " years and started at Abis at age " + startAge
            	+ " at a salary of " + startSalary + "\n";
        
        lines.add(line);

        while (age <  calculateAge()) {
            line = "Salary of " + getFirstName() + " " + getLastName() + " at " + age + " is " + salaryAtAge;
            lines.add(line);
            age += 5;
            seniority += 5;
            if (seniority <= 35) {
                salaryAtAge *= 1.03;
            } else {
            	line = "Maximum salary reached";
            	lines.add(line);
                break;
            }
        }
        
        return lines;


    }

	@Override
	public String printInfo() {
		return "Instructor " + getFirstName() + " " + getLastName() + " started at " + this.startAge + " and earned " + this.startSalary + " when he/she started";
	}
    
    
}