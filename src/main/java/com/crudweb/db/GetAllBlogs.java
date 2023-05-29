package com.crudweb.db;
import java.sql.*;
import java.util.*;

import com.crudweb.beans.*;

public class GetAllBlogs {
	
	public static List<BlogModel> getBlogList(){
		
		List<BlogModel> blogs = new ArrayList<>();
		
		try {
			Connection con = ConnectionEstablish.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from blog");
			ResultSet set = pst.executeQuery();
			while(set.next()) {
				int userId = set.getInt("userid");
				String content = set.getString("content");
				
				BlogModel model = new BlogModel(content,userId);
				blogs.add(model);
				
			}
		}catch(Exception e) {
			
		}
		return blogs;
		
	}
}
