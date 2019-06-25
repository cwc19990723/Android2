package bean;

public class forecast {
	
	private String week;
	private String high;
	private String low;
	private String fl;
	private String fx;
	private String type;
	
	public forecast() {
	}

	public forecast(String week, String high, String low, String fl, String fx, String type) {
		super();
		this.week = week;
		this.high = high;
		this.low = low;
		this.fl = fl;
		this.fx = fx;
		this.type = type;
	}

	public String getWeek() {
		return week;
	}

	public String getHigh() {
		return high;
	}

	public String getLow() {
		return low;
	}

	public String getFl() {
		return fl;
	}

	public String getFx() {
		return fx;
	}

	public String getType() {
		return type;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "forecast [week=" + week + ", high=" + high + ", low=" + low + ", fl=" + fl + ", fx=" + fx + ", type="
				+ type + "]";
	}
	
}
