package bean;

import java.io.Serializable;

public class lol implements Serializable{
	
	private String name;
	private String location;
	private String job;
	
	public lol() {
	}

	public lol(String name, String location, String job) {
		super();
		this.name = name;
		this.location = location;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "lol [name=" + name + ", location=" + location + ", job=" + job + "]";
	}
	
}
