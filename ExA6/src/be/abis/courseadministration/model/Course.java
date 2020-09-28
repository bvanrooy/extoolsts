package be.abis.courseadministration.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Course{

    static final double VATPERCENTAGE = 21;

    private String title;
    private int numberOfDays;
    private double pricePerDay;
    private boolean priorKnowledgeNeeded;
    private ArrayList<Instructor> instructors;

    public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeNeeded) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
        this.priorKnowledgeNeeded = priorKnowledgeNeeded;
        this.instructors=new ArrayList<>();
    }

    public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeNeeded, ArrayList<Instructor> instructors) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
        this.priorKnowledgeNeeded = priorKnowledgeNeeded;
        this.instructors = instructors;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isPriorKnowledgeNeeded() {
        return priorKnowledgeNeeded;
    }

    public void setPriorKnowledgeNeeded(boolean priorKnowledgeNeeded) {
        this.priorKnowledgeNeeded = priorKnowledgeNeeded;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void addInstructor(Instructor instructor){
        this.instructors.add(instructor);
    }

    public void removeInstructor(Instructor instructor){
        this.instructors.remove(instructor);
    }


    private String getPriceCategory(double price){
        if(price< 500){
            return "CHEAP";
        }
        else if(price > 499 && price < 1500){
            return "OK";
        }else{
            return "EXPENSIVE";
        }
    }

    private double calculateTotalPriceVATIncl(){
        double total = 0;
        total = this.pricePerDay * this.numberOfDays;
        if(!(this.numberOfDays > 3 && this.priorKnowledgeNeeded) ){
            total += ( total * VATPERCENTAGE / 100);
        }
        return total;
    }


    private ArrayList<String>getCourseInfo(){
        ArrayList<String> lines = new ArrayList<>();
        double total = calculateTotalPriceVATIncl();

        lines.add("Course\n-----------------------------------------------------");
        lines.add("Title                   : " + this.title);
        lines.add("Number of days          : " + this.numberOfDays);
        lines.add("Price / day             : " + this.pricePerDay);
        lines.add("Total Price VAT Incl    : " +  total + " (" + getPriceCategory(total) + ")");
        lines.add("Prior knowledge needed  : " +  this.priorKnowledgeNeeded);
        lines.add("Number of instructors   : " + instructors.size());
        for (Instructor instructorForCourse : instructors) {
            lines.add("\t\tInstructor : " + instructorForCourse.getFirstName() + " " + instructorForCourse.getLastName());
        }
        lines.add("\n-----------------------------------------------------------");

        return lines;
    }


    public void printInfo(){
        for (String line :  getCourseInfo()) {
            System.out.println(line);
        }
    }

    public void  writeInfoToFile() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("courseinfo.txt"), StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            for(String line:getCourseInfo()){
                bw.write(line + "\n");
            }
        }
    }

}