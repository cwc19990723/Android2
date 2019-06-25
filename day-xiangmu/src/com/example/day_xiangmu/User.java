package com.example.day_xiangmu;

public class User {
	
	private int img;
	private String name;
	private String trave;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int img, String name, String trave) {
		super();
		this.img = img;
		this.name = name;
		this.trave = trave;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrave() {
		return trave;
	}

	public void setTrave(String trave) {
		this.trave = trave;
	}

	@Override
	public String toString() {
		return "User [img=" + img + ", name=" + name + ", trave=" + trave + "]";
	}
	
}
