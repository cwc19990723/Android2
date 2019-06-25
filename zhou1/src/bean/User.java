package bean;

public class User {
	
	private result result;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(bean.result result) {
		super();
		this.result = result;
	}

	public result getResult() {
		return result;
	}

	public void setResult(result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "User [result=" + result + "]";
	}
	
}
