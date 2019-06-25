package com.example.zuo_day1;

public class User {
	
	private data data;
	private String message;
	private int status;
	
	public User() {
	}

	public User(com.example.zuo_day1.data data, String message, int status) {
		super();
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public data getData() {
		return data;
	}

	public void setData(data data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [message=" + message + ", status=" + status + "]";
	}
	
}
