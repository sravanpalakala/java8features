package com.jdk.examples;

import java.math.BigDecimal;

public class Staff {
	public Staff(String name, int age, BigDecimal sal) {
		this.name = name;
		this.age = age;
		this.salary = sal;
	}
	private String name;
    private int age;
    private BigDecimal salary;
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
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
    
    
}
