package com.nagarro.web.model;

public class User {
	private String aid;
	private String password;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [aid=" + aid + ", password=" + password + "]";
	}
}
