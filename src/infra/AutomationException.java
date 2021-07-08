package infra;

@SuppressWarnings("serial")
public class AutomationException extends RuntimeException {

	 public AutomationException(String message) {
	        super(message);
	    }

	    public AutomationException(String message, Throwable e) {
	        super(message, e);
	    }

}
