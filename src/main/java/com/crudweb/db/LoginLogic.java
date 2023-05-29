package com.crudweb.db;
import com.crudweb.beans.*;
import com.crudweb.db.*;
import java.sql.*;

public class LoginLogic {
	public static UserModel getUser(String username,String password) {
		UserModel currentUser = null;
		
		try {
			Connection con =  ConnectionEstablish.getConnection();
			
			String query = "select * from user where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet set = pst.executeQuery();
			
			if(set.next()) {
				currentUser = new UserModel();
				currentUser.setUsername(username);
				currentUser.setUserId(set.getInt("userid"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return currentUser;
		
		
	}
}
