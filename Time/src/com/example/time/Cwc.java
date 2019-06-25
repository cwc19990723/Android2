package com.example.time;

public class Cwc {
	
	private data data;
	
	public Cwc() {
	}

	public Cwc(com.example.time.data data) {
		super();
		this.data = data;
	}

	public data getData() {
		return data;
	}

	public void setData(data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Cwc []";
	}
	
}
