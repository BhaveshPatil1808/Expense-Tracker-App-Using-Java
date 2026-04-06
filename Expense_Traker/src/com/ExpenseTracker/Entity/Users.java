package com.ExpenseTracker.Entity;

public class Users {

	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public void display() {
	    System.out.println("=========== USER DETAILS ===========");
	    System.out.println("ID        : " + id);
	    System.out.println("Username  : " + username);
	    System.out.println("Password  : " + password);
	    System.out.println("====================================");
	}
	
}
