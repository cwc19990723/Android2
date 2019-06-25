package com.example.lian9;

import java.io.Serializable;

public class forecast implements Serializable{
	
	private String url;
	private String date;
	private String fengli;
	private String fengxiang;
	private String high;
	private String low;
	private String type;
	
	public forecast() {
	}

	public forecast(String url, String date, String fengli, String fengxiang, String high, String low, String type) {
		super();
		this.url = url;
		this.date = date;
		this.fengli = fengli;
		this.fengxiang = fengxiang;
		this.high = high;
		this.low = low;
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public String getDate() {
		return date;
	}

	public String getFengli() {
		return fengli;
	}

	public String getFengxiang() {
		return fengxiang;
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

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
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

	@Override
	public String toString() {
		return "forecast [url=" + url + ", date=" + date + ", fengli=" + fengli + ", fengxiang=" + fengxiang + ", high="
				+ high + ", low=" + low + ", type=" + type + "]";
	}

}
