package bean;

import java.util.List;

public class User {
	
	private int error_code;
	private String reason;
	private Result result;
	
	public User() {
	}

	public User(int error_code, String reason, Result result) {
		super();
		this.error_code = error_code;
		this.reason = reason;
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "User [error_code=" + error_code + ", reason=" + reason + ", result=" + result + "]";
	}

}
