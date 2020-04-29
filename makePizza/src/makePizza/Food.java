package makePizza;

import java.util.List;

public class Food {
	int price;
	String name;
	String ovenType;
	boolean success;
	String reason;
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public boolean getSuccess() {
		return success;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
