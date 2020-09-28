package be.abis.courseadministration.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

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
  
    
    public void printSalaryHistory() {
        int seniority = 0;
        int age = this.startAge;
        double salaryAtAge = this.startSalary;
        String line;

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("salaryhistory.txt"))) {
            line = "\n\nInstructor " + this.getFirstName() + " " + this.getLastName() 
            	+ " has " + this.calculateAge() 
            	+ " years and started at Abis at age " + startAge
            	+ " at a salary of " + startSalary + "\n";
            System.out.println(line);
            bw.write(line);

            while (age <  calculateAge()) {
                line = "Salary of " + getFirstName() + " " + getLastName() + " at " + age + " is " + salaryAtAge;
                System.out.println(line);
                bw.write(line + "\n");
                age += 5;
                seniority += 5;
                if (seniority <= 35) {
                    salaryAtAge *= 1.03;
                } else {
                    line = "Maximum salary reached";
                    System.out.println(line);
                    bw.write(line + "\n");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}