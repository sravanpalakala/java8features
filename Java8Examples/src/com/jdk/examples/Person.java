package com.jdk.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.J8Utils;

public class Person implements Comparable<Person>{
	private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public void print() {
		System.out.println("Person [name=" + name + ", age=" + age + "]");
	}
	
	public static List<Person>getPersons() {
		List<Person> list = IntStream.range(0, 20).mapToObj(p-> new Person("Name: "+p, J8Utils.getRandomNumber(20, 50))).collect(Collectors.toList());
		return list;
		
	}
	
	@Override
	public int compareTo(Person o) {
//		if(this.age > o.age) {
//			return -1;
//		} else if(this.age < o.age ) {
//			return 0;
//		}
		return this.age-o.getAge();
	}

}
