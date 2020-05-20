package com.j8.streams.map;

import java.util.List;
import java.util.function.Predicate;
import com.jdk.examples.Student;

public class StreamsPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Predicate<Student> p1 = s -> s.stuName.startsWith("A"); 
	      Predicate<Student> p2 = s -> s.stuAge < 40; 
	      Predicate<Student> p3 = s -> s.stuAge < 40 && s.stuName.startsWith("P");
	      List<Student> list = Student.getStudents();

	      /* allMatch() method returns true if all the elements of stream satisfy the 
	       * given predicate, else it returns false 
	       */ 

	      /* This will return false because all student names do not start with "A"  
	       */ 
	      boolean b1 = list.stream().allMatch(p1); 
	      System.out.println("list.stream().allMatch(p1): "+b1); 

	      /* This will return true because all students have age less than 40  
	       */ 
	      boolean b2 = list.stream().allMatch(p2); 
	      System.out.println("list.stream().allMatch(p2): "+b2); 

	      /* This will return false because all the students do not satisfy the predicate: 
	       * Age must be less than 40 and name starts with letter "P" 
	       */ 
	      boolean b3 = list.stream().allMatch(p3); 
	      System.out.println("list.stream().allMatch(p3): "+b3);

	}

}
