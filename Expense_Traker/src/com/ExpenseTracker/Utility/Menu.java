package com.ExpenseTracker.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.ExpenseTracker.Entity.Expense;
import com.ExpenseTracker.Entity.Users;
import com.ExpenseTracker.Service.*;

public class Menu {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static UserService userService = new UserServiceImpl();
    static ExpenseService expenseService = new ExpenseServiceImpl();

    public  void menu() {

        while (true) {
            try {
                System.out.println("\n===== EXPENSE TRACKER =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                    	System.out.print("Exiting");
            			for(int i = 0 ; i < 3 ; i++) {
            				Thread.sleep(1000);
            				System.out.print(".");
            			}
            			String thanksQuote = "\nThanks for using Your Expense Tracker App...";
            			for(char ch : thanksQuote.toCharArray()) {
            				Thread.sleep(100);
            				System.out.print(ch);
            			}
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 🔐 REGISTER
    static void register() throws Exception {
        System.out.print("Username: ");
        String username = br.readLine();

        System.out.print("Password: ");
        String password = br.readLine();

        Users user = new Users(0, username, password);

        if (userService.register(user)) {
            System.out.println("✅ Registered Successfully!");
        } else {
            System.out.println("❌ Registration Failed!");
        }
    }

    // 🔐 LOGIN
    static void login() throws Exception {
        System.out.print("Username: ");
        String username = br.readLine();

        System.out.print("Password: ");
        String password = br.readLine();

        Users user = userService.login(username, password);

        if (user == null) {
            System.out.println("❌ Invalid Credentials!");
            return;
        }

        System.out.println("✅ Welcome " + user.getUsername());

        userMenu(user.getId());
    }

    // 👤 USER MENU
    static void userMenu(int userId) throws Exception {

        while (true) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Category Report");
            System.out.println("5. Total Expense");
            System.out.println("6. Monthly Report");
            System.out.println("7. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {

                // ➕ ADD EXPENSE
                case 1:
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(br.readLine());

                    System.out.print("Category: ");
                    String category = br.readLine();

                    System.out.print("Description: ");
                    String desc = br.readLine();

                    System.out.print("Date (yyyy-mm-dd): ");
                    Date date = Date.valueOf(br.readLine());

                    Expense exp = new Expense(0, userId, amount, category, desc, date);

                    expenseService.addExpense(exp);
                    break;

                // 📋 VIEW ALL
                case 2:
                    List<Expense> list = expenseService.getUserExpenses(userId);
                    System.out.println("\n--- ALL EXPENSES ---");
                    for (Expense e : list) {
                        e.display();
                    }
                    break;

                // ❌ DELETE
                case 3:
                    System.out.print("Enter Expense ID: ");
                    int id = Integer.parseInt(br.readLine());

                    expenseService.deleteExpense(id);
                    break;

                // 📊 CATEGORY REPORT
                case 4:
                    Map<String, Double> map = expenseService.getCategoryReport(userId);

                    System.out.println("\n--- CATEGORY REPORT ---");
                    for (String cat : map.keySet()) {
                        System.out.println(cat + " : " + map.get(cat));
                    }
                    break;

                // 💸 TOTAL
                case 5:
                    double total = expenseService.getTotalExpense(userId);
                    System.out.println("Total Expense: " + total);
                    break;

                // 📅 MONTHLY REPORT
                case 6:
                    System.out.print("Enter Month (1-12): ");
                    int month = Integer.parseInt(br.readLine());

                    System.out.print("Enter Year: ");
                    int year = Integer.parseInt(br.readLine());

                    List<Expense> monthly = expenseService.getMonthlyExpenses(userId, month, year);

                    System.out.println("\n--- MONTHLY EXPENSES ---");
                    for (Expense e : monthly) {
                        e.display();
                    }
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

