package com.example.demo;

public class ResultDTO {
	
	private String title;
	private String description;
	
	public ResultDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
