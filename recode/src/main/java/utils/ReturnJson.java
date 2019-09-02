package utils;

public class ReturnJson {
public ReturnJson() {
	// TODO Auto-generated constructor stub
}

	public ReturnJson(int status) {
	super();
	this.status = status;
}

	private int status=0;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
