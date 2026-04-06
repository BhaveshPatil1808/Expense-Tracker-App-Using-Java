package com.ExpenseTracker.Service;

import java.util.List;

import com.ExpenseTracker.Entity.Users;

public interface UserService {

	public boolean register(Users user);

	public Users login(String username, String password);

	public List<Users> getAllUsers();
}
