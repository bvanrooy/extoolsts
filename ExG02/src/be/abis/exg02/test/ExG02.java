package be.abis.exg02.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.abis.exg02.model.Course;
import be.abis.exg02.model.Instructor;

public class ExG02{

    public static void main(String[] args){

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Instructor>instructors=new ArrayList<>();

        instructors.add(new Instructor("Sandy","Schillebeeckx"));
        instructors.add(new Instructor("Luigi","Instructore"));
        instructors.add(new Instructor("Bart","Van Rooy"));

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
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
