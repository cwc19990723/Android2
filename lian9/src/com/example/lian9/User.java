package com.example.lian9;

public class User {
	
	private data data;
	private String desc;
	private int status;
	
	public User() {
	}

	public User(com.example.lian9.data data, String desc, int status) {
		super();
		this.data = data;
		this.desc = desc;
		this.status = status;
	}

	public data getData() {
		return data;
	}

	public String getDesc() {
		return desc;
	}

	public int getStatus() {
		return status;
	}

	public void setData(data data) {
		this.data = data;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [desc=" + desc + ", status=" + status + "]";
	}
	
}
