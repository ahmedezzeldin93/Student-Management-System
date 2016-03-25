package com.ahmedezzeldin.spring.web.dao;

public class Student {
	private int id;
	private String name;
	private int age;
	private String department;
	
	public Student() {
	}
	
	public Student(String name, int age, String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	public Student(int id, String name, int age, String department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Age=" + age
				+ ", department=" + department + "]";
	}
		
}