package com.crudweb.control;

import java.io.IOException;

import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		res.sendRedirect("WelcomePage.jsp");
	}
}
