package bean;

import java.util.List;

public class User {
	
	private List<lol> lol;
	
	public User() {
	}

	public User(List<bean.lol> lol) {
		super();
		this.lol = lol;
	}

	public List<lol> getLol() {
		return lol;
	}

	public void setLol(List<lol> lol) {
		this.lol = lol;
	}

	@Override
	public String toString() {
		return "User []";
	}
	
}
