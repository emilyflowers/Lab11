import java.io.Serializable;

/**
* File: Person.java
* Class: CSCI 1302
* Author: Emily Flowers, Sam Lewis
* Created on: Nov 14, 2025
* Last Modified: Nov 14, 2025
* Description: 
*/

public class Person implements Comparable<Person>, Serializable {
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;
	
	public Person() {
		
	}
	
	public Person(int age, String name, String address, int zipCode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
	}
	
	public String toString() {
		return String.format("%d %s %s %d $%,.2f", getAge(), getName(), getAddress(), getZipCode(), getSalary());
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Person o) {
		if (getSalary() > o.getSalary())
			return -1;
		else if (getSalary() < o.getSalary())
			return 1;
		else
			return 0;
	}
	

}
