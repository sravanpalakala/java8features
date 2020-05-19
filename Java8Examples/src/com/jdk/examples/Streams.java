package com.jdk.examples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	
	public void basicStreamFilter() {
	ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(0);
		list.add(40);
		list.add(20);
		list.add(5);
		list.add(14);
		
	ArrayList<Integer> evenLst=	(ArrayList<Integer>) list.stream().filter(i-> i % 2 == 0).collect(Collectors.toList());
	evenLst.stream().forEach(System.out::println);
	
	// filter less than 35
	long failedlst =	 list.stream().filter(i-> i < 35).count();
	  
	  System.out.println("failed nos:"+failedlst);
	  
	  ArrayList<Integer> failLst =	(ArrayList<Integer>)   list.stream().filter(i-> i < 35).collect(Collectors.toList());
			  System.out.println("failLst:"+failLst);	
	}
	
	// filter specific string from list
	public void streamFilter2() {
		 List<String> lines = Arrays.asList("spring", "node", "mkyong");

	        List<String> result = lines.stream()                // convert list to stream
	                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
	                .collect(Collectors.toList());              // collect the output and convert streams to a List

	        result.forEach(System.out::println);                //output : spring, node
	}
	// filter with findAny
	public void streamFindAny() {
		List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println(result1);

        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);
	}
	//1. A List of Strings to Uppercase
	public void streamMap() {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }

        System.out.println(alpha); //[a, b, c, d]
        System.out.println(alphaUpper); //[A, B, C, D]

        // Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.stream().forEach(System.out::println); //[A, B, C, D]

        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        collect1.stream().forEach(System.out::println); //[2, 4, 6, 8, 10]

	}
	// Get all the name values from a list of the staff objects.
	public void listStrings() {
		List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); //[mkyong, jack, lawrence]

        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[mkyong, jack, lawrence]
	}
	
	public void streamFilterMapEg() {
		 List<Person> persons = Arrays.asList(
	                new Person("mkyong", 30),
	                new Person("jack", 20),
	                new Person("lawrence", 40)
	        );

	        String name = persons.stream()
	                .filter(x -> "jack".equals(x.getName()))
	                .map(Person::getName)                        //convert stream to String
	                .findAny()
	                .orElse("");

	        System.out.println("name : " + name);

	        List<String> collect = persons.stream()
	                .map(Person::getName)
	                .collect(Collectors.toList());

	        collect.forEach(System.out::println);

	}
	
	/*
	 *  
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Streams s = new Streams();
		s.basicStreamFilter();
				
		//s.listStrings();

	}

}
