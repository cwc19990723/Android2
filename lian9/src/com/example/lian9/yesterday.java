package com.example.lian9;

public class yesterday {
	
	private String date;
	private String fl;
	private String fx;
	private String high;
	private String low;
	private String type;
	private String url;
	
	public yesterday() {
	}

	public yesterday(String date, String fl, String fx, String high, String low, String type, String url) {
		super();
		this.date = date;
		this.fl = fl;
		this.fx = fx;
		this.high = high;
		this.low = low;
		this.type = type;
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public String getFl() {
		return fl;
	}

	public String getFx() {
		return fx;
	}

	public String getHigh() {
		return high;
	}

	public String getLow() {
		return low;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "yesterday [date=" + date + ", fl=" + fl + ", fx=" + fx + ", high=" + high + ", low=" + low + ", type="
				+ type + ", url=" + url + "]";
	}
	
}
