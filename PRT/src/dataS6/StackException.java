package dataS6;

public class StackException extends RuntimeException {		//java.lang.RuntimeException
	public StackException() {
		
	};
	
	public StackException(String message) {
		super(message);						//���⼭ super�� java.lang.RuntimeException.RuntimeException(String message) ��
	}

}

