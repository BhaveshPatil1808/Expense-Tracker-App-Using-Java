package com.ExpenseTracker.Service;

import java.util.List;

import com.ExpenseTracker.Dao.UserDao;
import com.ExpenseTracker.Entity.Users;

public class UserServiceImpl implements UserService {
	
	private UserDao udao = new UserDao();

	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		return udao.register(user);
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return udao.login(username, password);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return udao.getAllUsers();
	}

}
