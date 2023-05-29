package com.crudweb.db;
import java.sql.*;
public class ConnectionEstablish {

		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testweb","root","root");
				return con;
			}catch(Exception e) {
				return null;
			}
		}
}
