package bean;

public class tags {
	
	private String title;
	private int pyte;
	private int zan;
	
	public tags() {
	}

	public tags(String title, int pyte, int zan) {
		super();
		this.title = title;
		this.pyte = pyte;
		this.zan = zan;
	}

	public String getTitle() {
		return title;
	}

	public int getPyte() {
		return pyte;
	}

	public int getZan() {
		return zan;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPyte(int pyte) {
		this.pyte = pyte;
	}

	public void setZan(int zan) {
		this.zan = zan;
	}

	@Override
	public String toString() {
		return "tags [title=" + title + ", pyte=" + pyte + ", zan=" + zan + "]";
	}
	
}
