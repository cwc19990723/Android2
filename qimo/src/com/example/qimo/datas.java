package com.example.qimo;

public class datas {
	
	private String author;
	private String niceDate;
	private String title;
	private String superChapterName;
	private String chapterName;
	
	public datas() {
		// TODO Auto-generated constructor stub
	}

	public datas(String author, String niceDate, String title, String superChapterName, String chapterName) {
		super();
		this.author = author;
		this.niceDate = niceDate;
		this.title = title;
		this.superChapterName = superChapterName;
		this.chapterName = chapterName;
	}

	public String getAuthor() {
		return author;
	}

	public String getNiceDate() {
		return niceDate;
	}

	public String getTitle() {
		return title;
	}

	public String getSuperChapterName() {
		return superChapterName;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setNiceDate(String niceDate) {
		this.niceDate = niceDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSuperChapterName(String superChapterName) {
		this.superChapterName = superChapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	@Override
	public String toString() {
		return "datas [author=" + author + ", niceDate=" + niceDate + ", title=" + title + ", superChapterName="
				+ superChapterName + ", chapterName=" + chapterName + "]";
	}
	
}
