package com.crudweb.control;
import com.crudweb.db.*;
import com.crudweb.beans.*;
import java.sql.*;
import java.util.List;
import java.io.IOException;

import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.print(username);
		
		UserModel currentUser = LoginLogic.getUser(username, password);

		
		if(currentUser!=null) {
			System.out.println("got user");
			HttpSession session = req.getSession();
			session.setAttribute("user_object", currentUser);

			res.sendRedirect("Home.jsp");
		}else {
			System.out.println("no user");
			res.sendRedirect("WelcomePage.jsp");
		}
		
		
		
	}

}
