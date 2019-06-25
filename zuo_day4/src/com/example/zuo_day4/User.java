package com.example.zuo_day4;

public class User {
	
	private String name;
	private String age;
	private String classname;
	private String schoolname;
	
	public User() {
	}

	public User(String name, String age, String classname, String schoolname) {
		super();
		this.name = name;
		this.age = age;
		this.classname = classname;
		this.schoolname = schoolname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", classname=" + classname + ", schoolname=" + schoolname + "]";
	}
	
}
