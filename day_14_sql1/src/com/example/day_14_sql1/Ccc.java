package com.example.day_14_sql1;

public class Ccc {
	
	private int id;
	private String name;
	private int age;
	private String sex;
	
	public Ccc() {
		// TODO Auto-generated constructor stub
	}

	public Ccc(int id, String name, int age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Ccc [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
