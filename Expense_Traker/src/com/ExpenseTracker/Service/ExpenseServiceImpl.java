package com.ExpenseTracker.Service;

import java.util.List;
import java.util.Map;

import com.ExpenseTracker.Dao.ExpenseDao;
import com.ExpenseTracker.Entity.Expense;

public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseDao edao = new ExpenseDao();
	@Override
	public boolean addExpense(Expense exp) {
		// TODO Auto-generated method stub
		return edao.addExpense(exp);
	}

	@Override
	public List<Expense> getUserExpenses(int userId) {
		// TODO Auto-generated method stub
		return edao.getExpensesByUser(userId);
	}

	@Override
	public boolean deleteExpense(int id) {
		// TODO Auto-generated method stub
		return edao.deleteExpense(id);
	}

	@Override
	public Map<String, Double> getCategoryReport(int userId) {
		// TODO Auto-generated method stub
		return edao.getCategoryWiseExpense(userId);
	}

	@Override
	public double getTotalExpense(int userId) {
		// TODO Auto-generated method stub
		return edao.getTotalExpense(userId);
	}

	@Override
	public List<Expense> getMonthlyExpenses(int userId, int month, int year) {
		// TODO Auto-generated method stub
		return edao.getMonthlyExpenses(userId, month, year);
	}

}
