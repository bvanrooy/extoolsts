package be.abis.exg05.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

import be.abis.exg05.exception.AgeCannotBeNegativeException;

public class Instructor implements Comparable<Instructor>{

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Instructor(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public int getAge() throws AgeCannotBeNegativeException{
        int age=0;
        if(this.birthDate != null){
            age = Period.between(this.birthDate,LocalDate.now()).getYears();
            if(age <0){
                throw  new AgeCannotBeNegativeException("age cannot be negative");
            }
        }
        return age;
    }


    public void printSalaryHistory(int startAge, double startSalary, String fileName) throws  IOException, AgeCannotBeNegativeException{
        int seniority = 0;
        int age = startAge;
        double salaryAtAge = startSalary;
        String line;

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
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

        }
    }
    public void printSalaryHistory(int startAge, double startSalary) throws  IOException, AgeCannotBeNegativeException {
        printSalaryHistory(startAge,startSalary,"salaryhistory.txt");
    }

    @Override
    public String toString() {
        return  this.firstName + " "  + this.lastName;
    }

    @Override
    public int compareTo(Instructor instructorToCompare) {
        return this.getFirstName().compareTo(instructorToCompare.getFirstName());
    }
}