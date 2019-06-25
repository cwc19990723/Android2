package bean;

public class forecast {
	
	private String date;
	private String fengli;
	private String fengxiang;
	private String high;
	private String low;
	private String type;
	private String url;
	
	public forecast() {
	}

	public forecast(String date, String fengli, String fengxiang, String high, String low, String type, String url) {
		super();
		this.date = date;
		this.fengli = fengli;
		this.fengxiang = fengxiang;
		this.high = high;
		this.low = low;
		this.type = type;
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getFengxiang() {
		return fengxiang;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "forecast [date=" + date + ", fengli=" + fengli + ", fengxiang=" + fengxiang + ", high=" + high
				+ ", low=" + low + ", type=" + type + ", url=" + url + "]";
	}

}
