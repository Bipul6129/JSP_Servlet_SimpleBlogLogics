<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.crudweb.beans.*"%>
<%
	UserModel currentUser = (UserModel)session.getAttribute("user_object");
	if(currentUser!=null){
		response.sendRedirect("Home.jsp");
	}else{
		
	}
	
%>