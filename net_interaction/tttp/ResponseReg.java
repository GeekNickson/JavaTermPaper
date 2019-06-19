package tttp;

public class ResponseReg extends Protocol {
	private boolean status;
	private String message;
	public ResponseReg(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	
	boolean getStatus() {
		return status;
	}
	
	String getMessage() {
		return message;
	}
}
