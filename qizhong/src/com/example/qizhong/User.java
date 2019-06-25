package com.example.qizhong;

public class User {
	
	private int image;
	private String name;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int image, String name) {
		super();
		this.image = image;
		this.name = name;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [image=" + image + ", name=" + name + "]";
	}
	
}
