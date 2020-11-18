package dataS6;

public class StackException extends RuntimeException {		//java.lang.RuntimeException
	public StackException() {
		
	};
	
	public StackException(String message) {
		super(message);						//여기서 super는 java.lang.RuntimeException.RuntimeException(String message) 임
	}

}

