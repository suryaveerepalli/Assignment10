package com.asssignment10.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	static Connection cn=null;

	static String url="jdbc:mysql://localhost/contactdb";
	static String driverClass="com.mysql.jdbc.Driver";
	static String username="system";
	static String password="Suryateja@10";
	
	public static Connection getConnection() {
		if(cn==null)
		{
			//optional step
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					cn=DriverManager.getConnection(url,username,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cn;
	}

	public void closeConnection()
	{
		try {
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}