package bean;

public class data {
	
	private String thumbnail_pic_s;
	private String author_name;
	private String categroy;
	private String title;
	
	public data() {
	}

	public data(String thumbnail_pic_s, String author_name, String categroy, String title) {
		super();
		this.thumbnail_pic_s = thumbnail_pic_s;
		this.author_name = author_name;
		this.categroy = categroy;
		this.title = title;
	}

	public String getThumbnail_pic_s() {
		return thumbnail_pic_s;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public String getCategroy() {
		return categroy;
	}

	public String getTitle() {
		return title;
	}

	public void setThumbnail_pic_s(String thumbnail_pic_s) {
		this.thumbnail_pic_s = thumbnail_pic_s;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public void setCategroy(String categroy) {
		this.categroy = categroy;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "data [thumbnail_pic_s=" + thumbnail_pic_s + ", author_name=" + author_name + ", categroy=" + categroy
				+ ", title=" + title + "]";
	}
	
}
