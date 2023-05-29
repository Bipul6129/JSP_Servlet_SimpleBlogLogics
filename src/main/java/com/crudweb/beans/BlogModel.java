package com.crudweb.beans;

public class BlogModel {
	private String content;
	private int blogUserId;
	
	public BlogModel(String content, int blogUserId) {
		super();
		this.content = content;
		this.blogUserId = blogUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBlogUserId() {
		return blogUserId;
	}

	public void setBlogUserId(int blogUserId) {
		this.blogUserId = blogUserId;
	}
	
	
}
