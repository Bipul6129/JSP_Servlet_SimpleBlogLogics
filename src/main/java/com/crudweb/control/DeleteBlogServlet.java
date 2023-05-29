package com.crudweb.control;
import com.crudweb.db.*;
import javax.servlet.http.*;

public class DeleteBlogServlet extends HttpServlet{
	
	public void doDelete(HttpServletRequest req,HttpServletResponse res) {
		String blogContent = req.getHeader("blogcontent");
		System.out.println("the deleteservlet got "+blogContent);
		boolean deletestatus = DeleteBlogLogic.deleteBlog(blogContent);
		
		if(deletestatus) {
			res.setStatus(HttpServletResponse.SC_OK);
		}
		
	}
	

}
