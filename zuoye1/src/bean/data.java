package bean;

import java.util.List;

public class data {
	
	private List<datas> datas;
	
	public data() {
	}

	public data(List<bean.datas> datas) {
		super();
		this.datas = datas;
	}

	public List<datas> getDatas() {
		return datas;
	}

	public void setDatas(List<datas> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "data [datas=" + datas + "]";
	}

}
