package bean;

import java.util.List;

public class data {
	
	private int curPage;
	private List<datas> datas;
	private int offset;
	private int pageCount;
	private int size;
	private int total;
	
	public data() {
		// TODO Auto-generated constructor stub
	}

	public data(int curPage, List<bean.datas> datas, int offset, int pageCount, int size, int total) {
		super();
		this.curPage = curPage;
		this.datas = datas;
		this.offset = offset;
		this.pageCount = pageCount;
		this.size = size;
		this.total = total;
	}

	public int getCurPage() {
		return curPage;
	}

	public List<datas> getDatas() {
		return datas;
	}

	public int getOffset() {
		return offset;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getSize() {
		return size;
	}

	public int getTotal() {
		return total;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setDatas(List<datas> datas) {
		this.datas = datas;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "data [curPage=" + curPage + ", datas=" + datas + ", offset=" + offset + ", pageCount=" + pageCount
				+ ", size=" + size + ", total=" + total + "]";
	}
	
}
