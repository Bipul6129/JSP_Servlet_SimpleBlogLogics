package com.crudweb.control;
import java.sql.*;
import javax.servlet.http.*;
import com.crudweb.db.*;

public class PostBlogServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		String blogContent = req.getParameter("blogContent");
		System.out.print(req.getParameter("userId"));
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		try {
			Connection con = ConnectionEstablish.getConnection();
			String query = "insert into blog(content,userid) values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,blogContent);
			pst.setInt(2, userId);
			int rowsAffected=pst.executeUpdate();
			
			if(rowsAffected>0) {
				
				System.out.println("data inserted ");
				
			}else {
				System.out.println("data not inserted");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		
	}

}
