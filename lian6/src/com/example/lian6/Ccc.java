package com.example.lian6;

public class Ccc {
	
	private int image;
	private String name;
	private String content;
	
	public Ccc() {
	}

	public Ccc(int image, String name, String content) {
		super();
		this.image = image;
		this.name = name;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Ccc [image=" + image + ", name=" + name + ", content=" + content + "]";
	}
	
}
