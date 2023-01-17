package spring_rest_crud.globalException;

public class EmployeeNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotAvailableException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotAvailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotAvailableException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotAvailableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotAvailableException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
