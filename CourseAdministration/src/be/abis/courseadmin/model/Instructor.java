package be.abis.courseadmin.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

public class Instructor{

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int startAge;
	private double startSalary;

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Instructor(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    
    

    public Instructor(String firstName, String lastName, LocalDate birthDate, int startAge, double startSalary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.startAge = startAge;
		this.startSalary = startSalary;
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

    public int getAge(){
        if(this.birthDate != null){
          return Period.between(this.birthDate,LocalDate.now()).getYears();
        }
        return 0;
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
            line = "\n\nInstructor " + this.firstName + " " + this.lastName + " has " + this.getAge()
                    + " years and started at Abis at age " + startAge
                    + " at a salary of " + startSalary + "\n";
            System.out.println(line);
            bw.write(line);

            while (age <  this.getAge()) {
                line = "Salary of " + firstName + " " + lastName + " at " + age + " is " + salaryAtAge;
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