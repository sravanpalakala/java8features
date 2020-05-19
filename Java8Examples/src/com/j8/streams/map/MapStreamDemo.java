package com.j8.streams.map;

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
		age30.forEach(Person::print);
		
		List<Person> sortPersons = persons.stream().sorted(Comparable::compareTo).collect(Collectors.toList());
		sortPersons.forEach(Person::print);
	}
}
