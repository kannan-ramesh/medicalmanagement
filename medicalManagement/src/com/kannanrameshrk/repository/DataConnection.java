package com.kannanrameshrk.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
	private static final String url="jdbc:mysql://localhost:3306/medicalShop";
	private static final String name = "root";
	private static final String password="15410198";
	
	static Connection con= null;
	
	public static Connection getConnection() {
		if(con==null) {
			try {
				con=DriverManager.getConnection(url,name,password);
			} catch (SQLException e) {
				 System.out.println("Error establishing the database connection: " + e.getMessage());
			}
		}
		return con;
		
	}
}
