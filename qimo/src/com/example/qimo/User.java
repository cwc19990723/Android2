package com.example.qimo;

public class User {
	
	private data data;
	
	public User() {
	}

	public User(com.example.qimo.data data) {
		super();
		this.data = data;
	}

	public data getData() {
		return data;
	}

	public void setData(data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "User []";
	}
	
}
