<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.util.*"%>
<%@ include file="re-usable/ifnotLoggedin.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			
			$("#allBlogs").on('click','.delBlog',function(){
				blogcontent = $(this).data("blog-content");

				$.ajax({
					url:'deleteblog',
					type:'DELETE',
					headers:{"blogcontent":blogcontent},
					success:function(response){
						alert('deleted success');
						getAllBlogs();
						
					},
					error:function(xhr,status,error){
						alert('delete failed');
					}
				})
			})
			
			function getAllBlogs(){
				$.ajax({
					url:"getblogs",
					type:"GET",
					dataType:"json",
					success:function(response){
	
						$("#allBlogs").empty();
						for(i=0;i<response.length;i++){
							console.log(response[i].content);
							$("#allBlogs").append(response[i].content+"<button type='button' class='delBlog' data-blog-content='"+response[i].content+"'>Delete</button><br>");
						}
					},
					error:function(xhr,status,error){
						alert("error loading data");
					}
				})
			}
	
			getAllBlogs();
			

			$("#postblogform").submit(function(event){
				event.preventDefault();
				var formData = $(this).serialize();
				$.ajax({
					url:"postblog",
					type:"POST",
					cache:false,
					data:formData,
					success:function(response){
						i=1;
						alert("success");
						getAllBlogs();
					},
					error:function(xhr,status,error){
						alert("failed");
					}
				})
			})
			
			
		});
		
		
		
		
	</script>
</head>
<body>
	<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
	<h1>Welcome to Home Page <%if(currentUser!=null) out.print(currentUser.getUsername()+" id:"+currentUser.getUserId()); %></h1>
	
	
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
	
	<h3>Post a Blog</h3>
	<form id="postblogform">
		Enter blogContent:<input type="text" name="blogContent"/>
		<input type="hidden" value="<% if(currentUser!=null) out.print(currentUser.getUserId()); %>" name="userId"/>
		<input type="submit"/>
	</form>
	
	<h3>Blogs</h3>
	<div id="allBlogs">

	</div>
	
	

	
</body>
</html>