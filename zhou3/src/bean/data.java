package bean;

import java.util.List;

public class data {
	
	private List<forecast> forecast;
	
	public data() {
	}

	public data(List<bean.forecast> forecast) {
		super();
		this.forecast = forecast;
	}

	public List<forecast> getForecast() {
		return forecast;
	}

	public void setForecast(List<forecast> forecast) {
		this.forecast = forecast;
	}

	@Override
	public String toString() {
		return "data []";
	}
	
}
