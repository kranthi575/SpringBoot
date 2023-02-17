package com.kp.dto;

public class Student {
	
	private String name;
	private Integer age;
	private String email;
	private String country;
	
	
	public Student(String name, String age, String email, String country) {
		
		this.name = name;
		this.age =Integer.parseInt(age);
		this.email = email;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", email=" + email + ", country=" + country + "]";
	}
	
	

}
