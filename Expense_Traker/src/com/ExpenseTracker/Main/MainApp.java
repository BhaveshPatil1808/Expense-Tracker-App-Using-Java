package com.ExpenseTracker.Main;

import com.ExpenseTracker.Utility.Menu;

public class MainApp {
	
	
	
	
	public static void main(String[] args) {
		try {
			Menu menu = new Menu();
			menu.menu();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
