# 💰 Expense Tracker

[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)](https://www.oracle.com/java/)
[![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-green)](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
[![Database](https://img.shields.io/badge/Database-MySQL-lightblue?logo=mysql)](https://www.mysql.com/)

A **console-based Expense Tracker** built with **Java, JDBC, and MySQL**.  
It allows users to **register/login, add expenses, view reports, and track spending by category or month**.  
Expenses are stored in the database with dates for persistent tracking.

---

## 🛠 Tech Stack
- ☕ **Java 21**
- 🔗 **JDBC** (Database connectivity)
- 🗄 **MySQL Database**
- 🖥 **Console-based UI**

---

## 📦 Features
- 👤 **User Registration & Login**  
- ➕ **Add Expense** (amount, category, description, date)  
- 📋 **View All Expenses** (per user)  
- ❌ **Delete Expense**  
- 📊 **Category-wise Report** (total spending by category)  
- 📅 **Monthly Report** (expenses filtered by month/year)  
- 💰 **Total Expense Calculation**  

---

## ⚙️ Prerequisites
- Java 21+  
- MySQL running locally  
- JDBC driver (MySQL Connector/J)  

---

## 🚀 Getting Started

1️⃣ **Clone the repository**
```
git clone [https://github.com/BhaveshPatil1808/Expense-Tracker.git](https://github.com/BhaveshPatil1808/Expense-Tracker-App-Using-Java/)
cd Expense-Tracker
```
## 2️⃣ Configure Database  
**Update DBConnection.java with your DB credentials:**
```
String username = "root";
String password = "yourpassword";
String url = "jdbc:mysql://localhost:3306/expense_tracker";
```

---
## 3️⃣ Create Database Schema

```
CREATE DATABASE expense_tracker;

USE expense_tracker;

CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

CREATE TABLE expenses (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  amount DOUBLE,
  category VARCHAR(50),
  description TEXT,
  date DATE,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
```

---

## 4️⃣ Compile the project
javac -d bin src/com/ExpenseTracker/**/*.java

---

## 5️⃣ Run the application
java -cp bin com.ExpenseTracker.Main.MainApp

---

## 💬 Usage (CLI Flow)

**🔐 Login/Register**

Register with username & password

Login to access expense features

**👤 User Menu**

Add Expense

View All Expenses

Delete Expense

Category-wise Report

Total Expense

Monthly Report

Logout

---

## 📂 Project Structure

```
Expense-Tracker/
 ├── com.ExpenseTracker.Dao/          # DAO layer (ExpenseDao, UserDao)
 ├── com.ExpenseTracker.DBConnection/ # DBConnection utility
 ├── com.ExpenseTracker.Entity/       # Entities (Users, Expense)
 ├── com.ExpenseTracker.Service/      # Services (ExpenseServiceImpl, UserServiceImpl)
 ├── com.ExpenseTracker.Utility/      # Menu (CLI menus)
 └── com.ExpenseTracker.Main/         # MainApp entry point
```

---
## 🚀 Future Improvements

🌐 Add web-based UI (Spring Boot + Thymeleaf)

🔐 Encrypt passwords for security

📊 Add charts/graphs for expense visualization

🐳 Dockerize for deployment

---

## 👨‍💻 Author
**Bhavesh Patil**
📱 Mobile app integration
