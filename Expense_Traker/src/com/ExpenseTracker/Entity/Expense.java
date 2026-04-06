package com.ExpenseTracker.Entity;

import java.sql.Date;

public class Expense {

	private int id;
    private int userId;
    private double amount;
    private String category;
    private String description;
    private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expense(int id, int userId, double amount, String category, String description, Date date) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.date = date;
	}
	public void display() {
	    System.out.println("=========== EXPENSE DETAILS ===========");
	    System.out.println("Expense ID   : " + id);
	    System.out.println("User ID      : " + userId);
	    System.out.println("Amount       : ₹" + amount);
	    System.out.println("Category     : " + category);
	    System.out.println("Description  : " + description);
	    System.out.println("Date         : " + date);
	    System.out.println("======================================");
	}
    
}
