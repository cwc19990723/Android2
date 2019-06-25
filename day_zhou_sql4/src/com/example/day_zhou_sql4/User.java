package com.example.day_zhou_sql4;

public class User {
	
	private int id;
	private String image;
	private String name;
	private String address;
	private String sex;
	private String techang;
	
	public User() {
	}

	public User(int id, String image, String name, String address, String sex, String techang) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.address = address;
		this.sex = sex;
		this.techang = techang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTechang() {
		return techang;
	}

	public void setTechang(String techang) {
		this.techang = techang;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", image=" + image + ", name=" + name + ", address=" + address + ", sex=" + sex
				+ ", techang=" + techang + "]";
	}

}
