package bean;

public class data {
	
	private String content;
	private String hashId;
	private int unixtime;
	private String updatetime;
	
	public data() {
	}

	public data(String content, String hashId, int unixtime, String updatetime) {
		super();
		this.content = content;
		this.hashId = hashId;
		this.unixtime = unixtime;
		this.updatetime = updatetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public int getUnixtime() {
		return unixtime;
	}

	public void setUnixtime(int unixtime) {
		this.unixtime = unixtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "data [content=" + content + ", hashId=" + hashId + ", unixtime=" + unixtime + ", updatetime="
				+ updatetime + "]";
	}
	
}
