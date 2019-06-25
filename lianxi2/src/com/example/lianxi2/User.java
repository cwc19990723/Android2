package com.example.lianxi2;

import java.io.Serializable;

public class User implements Serializable{
	
	private String image;
	private String name;
	
	public User() {
	}

	public User(String image, String name) {
		super();
		this.image = image;
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [image=" + image + ", name=" + name + "]";
	}
	
}
