package com.example.zuo_day1;

import java.util.List;

public class data {
	
	private String cityname;
	private loction loction;
	private List<movie> movie;
	
	public data() {
	}

	public data(String cityname, com.example.zuo_day1.loction loction, List<com.example.zuo_day1.movie> movie) {
		super();
		this.cityname = cityname;
		this.loction = loction;
		this.movie = movie;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public loction getLoction() {
		return loction;
	}

	public void setLoction(loction loction) {
		this.loction = loction;
	}

	public List<movie> getMovie() {
		return movie;
	}

	public void setMovie(List<movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "data [cityname=" + cityname + ", loction=" + loction + "]";
	}
	
}
