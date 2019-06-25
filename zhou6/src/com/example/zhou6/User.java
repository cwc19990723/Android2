package com.example.zhou6;

public class User {
	
	private String image;
	private String name;
	private String context;
	
	public User() {
	}

	public User(String image, String name, String context) {
		super();
		this.image = image;
		this.name = name;
		this.context = context;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getContext() {
		return context;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "User [image=" + image + ", name=" + name + ", context=" + context + "]";
	}
	
}
