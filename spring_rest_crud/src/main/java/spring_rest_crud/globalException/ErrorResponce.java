package spring_rest_crud.globalException;

public class ErrorResponce {
	String msg;
	String details;
	public ErrorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponce(String msg, String details) {
		super();
		this.msg = msg;
		this.details = details;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
