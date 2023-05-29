package com.crudweb.control;
import com.crudweb.beans.*;
import com.google.gson.Gson;
import com.crudweb.db.GetAllBlogs;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.*;

public class GetBlogsServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		List<BlogModel> blogs = new ArrayList<>();
		blogs = GetAllBlogs.getBlogList();
		
		Gson gson = new Gson();
		String blogList = gson.toJson(blogs);
		
		res.setContentType("application/json");
		res.getWriter().write(blogList);
		
	}

}
