package bean;

import java.util.List;

public class Result {
	
	private List<data> data;

	public Result(List<bean.data> data) {
		super();
		this.data = data;
	}

	public List<data> getData() {
		return data;
	}

	public void setData(List<data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [data=" + data + "]";
	}
	
}
