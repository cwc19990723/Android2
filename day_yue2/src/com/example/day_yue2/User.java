package com.example.day_yue2;

public class User {
	
	private int id;
	private String imgurl;
	private String name;
	private String department;
	private String title;
	private String level;
	private String hosptail;
	
	public User() {
	}

	public User(int id, String imgurl, String name, String department, String title, String level, String hosptail) {
		super();
		this.id = id;
		this.imgurl = imgurl;
		this.name = name;
		this.department = department;
		this.title = title;
		this.level = level;
		this.hosptail = hosptail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getHosptail() {
		return hosptail;
	}

	public void setHosptail(String hosptail) {
		this.hosptail = hosptail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", imgurl=" + imgurl + ", name=" + name + ", department=" + department + ", title="
				+ title + ", level=" + level + ", hosptail=" + hosptail + "]";
	}

}
