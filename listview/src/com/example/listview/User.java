package com.example.listview;

import java.io.Serializable;

public class User implements Serializable{
	
	private String img;
	private String name;
	private String info;
	
	public User() {
	}

	public User(String img, String name, String info) {
		super();
		this.img = img;
		this.name = name;
		this.info = info;
	}

	public String getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "User [img=" + img + ", name=" + name + ", info=" + info + "]";
	}

}
