package be.abis.courseadministration.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import be.abis.courseadministration.model.Address;
import be.abis.courseadministration.model.Company;
import be.abis.courseadministration.model.Person;
import be.abis.courseadministration.util.FileUtil;

public class ExA06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"Ann","Smits",LocalDate.of(1985,1,1),
				new Company("Abis", new Address("Diestsevest","22","3000","Leuven","Belgium","BE"))));
		persons.add(new Person(2,"John","Doe",LocalDate.of(1966,1,1)));

		
	try {
		FileUtil.writeToFile((ArrayList<String>) persons.stream().collect((Collectors.mapping(Person::printInfo, Collectors.toList()))),"persons.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
