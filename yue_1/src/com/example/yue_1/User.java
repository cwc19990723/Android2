package com.example.yue_1;

import java.io.Serializable;

public class User implements Serializable{
	
	private int id;
	private int img;
	private String name;
	private String info;
	
	public User() {
	}

	public User(int id, int img, String name, String info) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", img=" + img + ", name=" + name + ", info=" + info + "]";
	}
	
}
