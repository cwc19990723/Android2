package com.example.day_xiangmu;

public class Travel {
	private int image;
	private String name;
	
	public Travel() {
	}

	public Travel(int image, String name) {
		super();
		this.image = image;
		this.name = name;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Travel [image=" + image + ", name=" + name + "]";
	}
	
}
