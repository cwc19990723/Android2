package com.example.lian9;

import java.util.List;

public class data {
	
	private String aqi;
	private String city;
	private List<forecast> forecast;
	private String ganmao;
	private String wendu;
	private yesterday yesterday;
	
	public data() {
	}

	public data(String aqi, String city, List<com.example.lian9.forecast> forecast, String ganmao, String wendu,
			com.example.lian9.yesterday yesterday) {
		super();
		this.aqi = aqi;
		this.city = city;
		this.forecast = forecast;
		this.ganmao = ganmao;
		this.wendu = wendu;
		this.yesterday = yesterday;
	}

	public String getAqi() {
		return aqi;
	}

	public String getCity() {
		return city;
	}

	public List<forecast> getForecast() {
		return forecast;
	}

	public String getGanmao() {
		return ganmao;
	}

	public String getWendu() {
		return wendu;
	}

	public yesterday getYesterday() {
		return yesterday;
	}

	public void setAqi(String aqi) {
		this.aqi = aqi;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setForecast(List<forecast> forecast) {
		this.forecast = forecast;
	}

	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public void setYesterday(yesterday yesterday) {
		this.yesterday = yesterday;
	}

	@Override
	public String toString() {
		return "data [aqi=" + aqi + ", city=" + city + ", ganmao=" + ganmao + ", wendu=" + wendu + "]";
	}
	
}
