package bean;

import java.util.List;

public class result {
	
	private List<data> data;
	
	public result() {
	}

	public result(List<bean.data> data) {
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
		return "result [data=" + data + "]";
	}
	
}
