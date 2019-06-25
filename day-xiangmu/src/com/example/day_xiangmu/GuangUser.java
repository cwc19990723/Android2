package com.example.day_xiangmu;

import java.io.Serializable;

public class GuangUser implements Serializable{
	
	private String goodImage;
	private String goodInfo;
	private String goodName;
	private double goodNowPrice;
	private int goodPingJIa;
	private double goodPrice;
	private int id ;
	
	public GuangUser() {
	}

	public GuangUser(String goodImage, String goodInfo, String goodName, double goodNowPrice, int goodPingJIa,
			double goodPrice, int id) {
		super();
		this.goodImage = goodImage;
		this.goodInfo = goodInfo;
		this.goodName = goodName;
		this.goodNowPrice = goodNowPrice;
		this.goodPingJIa = goodPingJIa;
		this.goodPrice = goodPrice;
		this.id = id;
	}

	public String getGoodImage() {
		return goodImage;
	}

	public void setGoodImage(String goodImage) {
		this.goodImage = goodImage;
	}

	public String getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(String goodInfo) {
		this.goodInfo = goodInfo;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public double getGoodNowPrice() {
		return goodNowPrice;
	}

	public void setGoodNowPrice(double goodNowPrice) {
		this.goodNowPrice = goodNowPrice;
	}

	public int getGoodPingJIa() {
		return goodPingJIa;
	}

	public void setGoodPingJIa(int goodPingJIa) {
		this.goodPingJIa = goodPingJIa;
	}

	public double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GuangAdapter [goodImage=" + goodImage + ", goodInfo=" + goodInfo + ", goodName=" + goodName
				+ ", goodNowPrice=" + goodNowPrice + ", goodPingJIa=" + goodPingJIa + ", goodPrice=" + goodPrice
				+ ", id=" + id + "]";
	}
	
}
