package com.j8.streams.map;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.jdk.examples.Person;

public class MapStreamDemo {

	public static void main(String[] args) {
		List<Person> persons = Person.getPersons();

		List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println(names.toString());

		List<Integer> personAges = persons.stream().map(Person::getAge).collect(Collectors.toList());
		System.out.println(personAges.toString());

		List<Person> age30 = persons.stream().filter(p -> p.getAge() < 30).collect(Collectors.toList());
		
		persons.sort((Person p1, Person p2)-> p1.getAge().compareTo(p2.getAge()));
		persons.stream().forEach(System.out::println);
        
    	//persons.stream().sorted((p1,p2)->p1.age.compareTo(p2.age)).forEach(System.out::println);
		
	}
}
