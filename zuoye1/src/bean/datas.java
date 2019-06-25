package bean;

public class datas {
	
	private String chapterName;
	private String envelopePic;
	private String publishTime;
	
	public datas() {
	}

	public datas(String chapterName, String envelopePic, String publishTime) {
		super();
		this.chapterName = chapterName;
		this.envelopePic = envelopePic;
		this.publishTime = publishTime;
	}

	public String getChapterName() {
		return chapterName;
	}

	public String getEnvelopePic() {
		return envelopePic;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public void setEnvelopePic(String envelopePic) {
		this.envelopePic = envelopePic;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public String toString() {
		return "datas [chapterName=" + chapterName + ", envelopePic=" + envelopePic + ", publishTime=" + publishTime
				+ "]";
	}

}
