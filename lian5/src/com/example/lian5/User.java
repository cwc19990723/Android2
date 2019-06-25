package com.example.lian5;

public class User {
	
	private int tu;
	private String biaoti;
	private String neirong;
	
	public User() {
	}

	public User(int tu, String biaoti, String neirong) {
		super();
		this.tu = tu;
		this.biaoti = biaoti;
		this.neirong = neirong;
	}

	public int getTu() {
		return tu;
	}

	public void setTu(int tu) {
		this.tu = tu;
	}

	public String getBiaoti() {
		return biaoti;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	@Override
	public String toString() {
		return "User [tu=" + tu + ", biaoti=" + biaoti + ", neirong=" + neirong + "]";
	}

}
