package com.nagarro.PraHRApplication.entity;

public class Employee {
	private int code;
	private String name;
	private String location;
	private String email;
	private String dob;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", location=" + location + ", email=" + email + ", dob="
				+ dob + "]";
	}

}
