package com.kp.model;

public class Account_details {
	
	private String uname;
	private String name;
	private String phno;
	private String email;
	private String city;
	private String pwd;
	
	
	public Account_details(String uname, String name, String phno, String email, String city, String pwd) {
		this.uname = uname;
		this.name = name;
		this.phno = phno;
		this.email = email;
		this.city = city;
		this.pwd = pwd;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
