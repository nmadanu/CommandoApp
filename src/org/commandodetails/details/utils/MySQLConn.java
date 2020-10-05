package org.commandodetails.details.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConn {
	
	public static Connection establishConn() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/LinuxTest?serverTimezone=Europe/Berlin";
		String username = "root";
		String password = "password";
		System.out.println("MySQL connection establishing...");
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(Exception e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection MySQL Object::"+conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("MySQL connection established.");
		
		return conn;
	}

}
