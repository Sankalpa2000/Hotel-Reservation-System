package com.oop.model;

public class Admin {
	private int cid;
	private String name;
	private String email;
	private String phone;
	private String username;
	private String password;
	public Admin(int cid, String name, String email, String phone, String username, String password) {
		
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public int getCid() {
		return cid;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
