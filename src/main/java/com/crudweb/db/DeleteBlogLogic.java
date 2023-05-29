package com.crudweb.db;
import java.sql.*;
public class DeleteBlogLogic {
	public static boolean deleteBlog(String blogContent) {
		boolean status=false;
		try {
			Connection con = ConnectionEstablish.getConnection();
			String query = "delete from blog where content=?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1,blogContent);
			int affected = stm.executeUpdate();
			System.out.println(affected);
			if(affected>0) {
				status=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
