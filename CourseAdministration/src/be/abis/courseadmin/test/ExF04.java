package be.abis.courseadmin.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExF04{

    public static void main(String[] args){

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Instructor>instructors=new ArrayList<>();

        instructors.add(new Instructor("Sandy","Schillebeeckx",LocalDate.of(1978,1,3),20,2000));
        instructors.add(new Instructor("Luigi","Instructore",LocalDate.of(1950,1,3),23,1750));
        instructors.add(new Instructor("Bart","Van Rooy",LocalDate.of(1965,8,7),22,2100));

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

        instructors.get(0).printSalaryHistory();
        instructors.get(1).printSalaryHistory();
        instructors.get(2).printSalaryHistory();
        }
    }
