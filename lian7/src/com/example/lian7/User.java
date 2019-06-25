package com.example.lian7;

import java.io.Serializable;

public class User implements Serializable{
	
	private int image;
	private String name;
	private String context;
	
	public User() {
	}

	public User(int image, String name, String context) {
		super();
		this.image = image;
		this.name = name;
		this.context = context;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "User [image=" + image + ", name=" + name + ", context=" + context + "]";
	}
	
}
