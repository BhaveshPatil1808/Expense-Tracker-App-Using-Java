package com.ExpenseTracker.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.ExpenseTracker.DBConnection.DBConnection;
import com.ExpenseTracker.Entity.Users;

public class UserDao {
	/*
	  public boolean register(Users user)
	  public Users login(String username, String password)
	  public List<Users> getAllUsers()
	 */

	public boolean register(Users user) {
		try(Connection con = DBConnection.getConnection()){
			String query = "INSERT INTO users VALUES (?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			return (ps.executeUpdate()>0);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Users login(String username, String password) {
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users WHERE username = ? AND password = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next() ? mapUser(rs) : null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Users> getAllUsers(){
		List<Users> list = new ArrayList<>();
		try(Connection con = DBConnection.getConnection()){
			String query = "SELECT * FROM users;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(mapUser(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private Users mapUser(ResultSet rs) throws SQLException {
		return new Users(rs.getInt("id"),
				rs.getString("username"),
				rs.getString("password"));
	}
}
