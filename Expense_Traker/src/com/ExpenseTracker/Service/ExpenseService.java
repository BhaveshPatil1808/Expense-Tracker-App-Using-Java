package com.ExpenseTracker.Service;

import java.util.List;
import java.util.Map;

import com.ExpenseTracker.Entity.Expense;

public interface ExpenseService {

	boolean addExpense(Expense exp);

    List<Expense> getUserExpenses(int userId);

    boolean deleteExpense(int id);

    Map<String, Double> getCategoryReport(int userId);

    double getTotalExpense(int userId);

    List<Expense> getMonthlyExpenses(int userId, int month, int year);
}
