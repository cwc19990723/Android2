package com.example.day2_18;

import java.util.List;

public class result {
	
	private List<data> data;
	private String stat;
	
	public result() {
	}

	public result(List<com.example.day2_18.data> data, String stat) {
		super();
		this.data = data;
		this.stat = stat;
	}

	public List<data> getData() {
		return data;
	}

	public String getStat() {
		return stat;
	}

	public void setData(List<data> data) {
		this.data = data;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "result [stat=" + stat + "]";
	}
	
}
