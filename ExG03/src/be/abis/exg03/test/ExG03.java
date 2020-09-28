package be.abis.exg03.test;

import javax.swing.text.Style;

import be.abis.exg03.exception.AgeCannotBeNegativeException;
import be.abis.exg03.model.Course;
import be.abis.exg03.model.Instructor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.LocalDate.*;

public class ExG03{

    public static void main(String[] args){

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Instructor>instructors=new ArrayList<>();

        instructors.add(new Instructor("Sandy","Schillebeeckx"));
        instructors.add(new Instructor("Luigi","Instructore"));
        instructors.add(new Instructor("Bart","Van Rooy"));
        instructors.add(new Instructor("John","Doe"));
        instructors.add(new Instructor("Jane","Doe"));

        courses.add(new Course("Java fundamentals",5,333,false));
        courses.add(new Course("Java advanced",5,253,true));
        courses.add(new Course("Spring fundamentals",3,211,true));

        courses.get(0).addInstructor(instructors.get(0));
        courses.get(0).addInstructor(instructors.get(1));

        courses.get(1).addInstructor(instructors.get(0));
        courses.get(1).addInstructor(instructors.get(1));
        courses.get(1).addInstructor(instructors.get(2));

        courses.get(2).addInstructor(instructors.get(2));


        for(Course course:courses) {
            course.printInfo();

            try {
                course.writeInfoToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Instructor instructor = instructors.get(0);
            instructor.setBirthDate(LocalDate.of(1978,1,3));
            instructor.printSalaryHistory(20,2000,"salary_" + instructor.getFirstName() + ".txt");

            instructor = instructors.get(1);
            instructor.setBirthDate(LocalDate.of(1950,1,3));
            instructor.printSalaryHistory(23,3000,"salary_" + instructor.getFirstName() + ".txt");

            instructor = instructors.get(2);
            instructor.setBirthDate(LocalDate.of(1965,8,7));
            instructor.printSalaryHistory(21,2000,"salary_" + instructor.getFirstName() + ".txt");
        }
        catch (IOException | AgeCannotBeNegativeException ex){
            ex.printStackTrace();
        }

        // negative age
        Instructor instructorNegativeAge = instructors.get(3);
        instructorNegativeAge.setBirthDate(LocalDate.of(2050,1,1));
        try {
            System.out.println("\n\n" + instructorNegativeAge.toString() + " age : " + instructorNegativeAge.getAge());
        } catch (AgeCannotBeNegativeException e) {
            e.printStackTrace();
        }

        // no birth date
        Instructor instructorNoBirthDate = instructors.get(4);
        try {
            System.out.println("\n\n" + instructorNoBirthDate .toString() + " age : " + instructorNoBirthDate.getAge());
        } catch (AgeCannotBeNegativeException e) {
            e.printStackTrace();
        }
    }
}
