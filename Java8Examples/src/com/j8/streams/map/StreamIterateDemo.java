package com.j8.streams.map;

import java.util.stream.Stream;

public class StreamIterateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Stream.iterate(1, count->count+1)  
	        .filter(number->number%3==0)  
	        .limit(6)  
	        .forEach(System.out::println);  
	}

}
