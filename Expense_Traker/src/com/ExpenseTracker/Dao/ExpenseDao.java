package com.ExpenseTracker.Dao;

import java.sql.*;
import java.util.*;

import com.ExpenseTracker.DBConnection.DBConnection;
import com.ExpenseTracker.Entity.Expense;

public class ExpenseDao {

    // ➕ ADD EXPENSE
    public boolean addExpense(Expense exp) {
        try (Connection con = DBConnection.getConnection()) {

            String query = "INSERT INTO expenses(user_id, amount, category, description, date) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, exp.getUserId());
            ps.setDouble(2, exp.getAmount());
            ps.setString(3, exp.getCategory());
            ps.setString(4, exp.getDescription());
            ps.setDate(5, exp.getDate());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 📋 VIEW ALL EXPENSES
    public List<Expense> getExpensesByUser(int userId) {
        List<Expense> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT * FROM expenses WHERE user_id=? ORDER BY date DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(mapExpense(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ❌ DELETE EXPENSE
    public boolean deleteExpense(int id) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement("DELETE FROM expenses WHERE id=?");
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 📊 CATEGORY-WISE TOTAL (🔥 IMPORTANT)
    public Map<String, Double> getCategoryWiseExpense(int userId) {

        Map<String, Double> map = new HashMap<>();

        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT category, SUM(amount) as total FROM expenses WHERE user_id=? GROUP BY category";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("category"), rs.getDouble("total"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    // 💸 TOTAL EXPENSE
    public double getTotalExpense(int userId) {

        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT SUM(amount) as total FROM expenses WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getDouble("total");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // 📅 FILTER BY MONTH (🔥 ADVANCED)
    public List<Expense> getMonthlyExpenses(int userId, int month, int year) {

        List<Expense> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT * FROM expenses WHERE user_id=? AND MONTH(date)=? AND YEAR(date)=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(mapExpense(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private Expense mapExpense(ResultSet rs) throws SQLException {
        return new Expense(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getDouble("amount"),
                rs.getString("category"),
                rs.getString("description"),
                rs.getDate("date")
        );
    }
}