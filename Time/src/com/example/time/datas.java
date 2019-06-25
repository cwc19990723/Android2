package com.example.time;

public class datas {
	
	private String envelopePic;
	private String superChapterName;
	private String title;
	
	public datas() {
	}

	public datas(String envelopePic, String superChapterName, String title) {
		super();
		this.envelopePic = envelopePic;
		this.superChapterName = superChapterName;
		this.title = title;
	}

	public String getEnvelopePic() {
		return envelopePic;
	}

	public String getSuperChapterName() {
		return superChapterName;
	}

	public String getTitle() {
		return title;
	}

	public void setEnvelopePic(String envelopePic) {
		this.envelopePic = envelopePic;
	}

	public void setSuperChapterName(String superChapterName) {
		this.superChapterName = superChapterName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "datas [envelopePic=" + envelopePic + ", superChapterName=" + superChapterName + ", title=" + title
				+ "]";
	}
	
}
