package bean;

import java.util.List;

public class datas {
	
	private String apkLink;
	private String author;
	private String chapterId;
	private int courseId;
	private String desc;
	private String envelopePic;
	private int id;
	private String likn;
	private String niceDate;
	private String projectLink;
	private int publishTime;
	private int superChapterId;
	private int superChapterName;
	private List<tags> tags;
	private String title;
	
	public datas() {
	}

	public datas(String apkLink, String author, String chapterId, int courseId, String desc, String envelopePic, int id,
			String likn, String niceDate, String projectLink, int publishTime, int superChapterId, int superChapterName,
			List<bean.tags> tags, String title) {
		super();
		this.apkLink = apkLink;
		this.author = author;
		this.chapterId = chapterId;
		this.courseId = courseId;
		this.desc = desc;
		this.envelopePic = envelopePic;
		this.id = id;
		this.likn = likn;
		this.niceDate = niceDate;
		this.projectLink = projectLink;
		this.publishTime = publishTime;
		this.superChapterId = superChapterId;
		this.superChapterName = superChapterName;
		this.tags = tags;
		this.title = title;
	}

	public String getApkLink() {
		return apkLink;
	}

	public String getAuthor() {
		return author;
	}

	public String getChapterId() {
		return chapterId;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getDesc() {
		return desc;
	}

	public String getEnvelopePic() {
		return envelopePic;
	}

	public int getId() {
		return id;
	}

	public String getLikn() {
		return likn;
	}

	public String getNiceDate() {
		return niceDate;
	}

	public String getProjectLink() {
		return projectLink;
	}

	public int getPublishTime() {
		return publishTime;
	}

	public int getSuperChapterId() {
		return superChapterId;
	}

	public int getSuperChapterName() {
		return superChapterName;
	}

	public List<tags> getTags() {
		return tags;
	}

	public String getTitle() {
		return title;
	}

	public void setApkLink(String apkLink) {
		this.apkLink = apkLink;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setEnvelopePic(String envelopePic) {
		this.envelopePic = envelopePic;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLikn(String likn) {
		this.likn = likn;
	}

	public void setNiceDate(String niceDate) {
		this.niceDate = niceDate;
	}

	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}

	public void setPublishTime(int publishTime) {
		this.publishTime = publishTime;
	}

	public void setSuperChapterId(int superChapterId) {
		this.superChapterId = superChapterId;
	}

	public void setSuperChapterName(int superChapterName) {
		this.superChapterName = superChapterName;
	}

	public void setTags(List<tags> tags) {
		this.tags = tags;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "datas [apkLink=" + apkLink + ", author=" + author + ", chapterId=" + chapterId + ", courseId="
				+ courseId + ", desc=" + desc + ", envelopePic=" + envelopePic + ", id=" + id + ", likn=" + likn
				+ ", niceDate=" + niceDate + ", projectLink=" + projectLink + ", publishTime=" + publishTime
				+ ", superChapterId=" + superChapterId + ", superChapterName=" + superChapterName + ", title=" + title
				+ "]";
	}
	
}
