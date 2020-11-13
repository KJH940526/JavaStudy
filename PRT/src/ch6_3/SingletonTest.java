package ch6_3;

final class Singleton{ //Ŭ���� �տ� ������ ��� �Ұ�, �޼ҵ� �տ� final�� ������ ����Ŭ�������� �������̵� �Ұ�
	private static Singleton s = new Singleton();
	
	private Singleton() {
		
	}
	
	//static => �̱��� ��ü�� �������� �ʰ� 
	public static Singleton getInstance() {
		if(s==null) {
			s = new Singleton();
		}
		return s;
	}
	
}

public class SingletonTest {
	public static void main(String[] args) {
		// Singleton s = new Singleton();
		Singleton s = Singleton.getInstance(); //�̱��� ��ü�� �������� �ʰ� getInstance �޼ҵ带 ȣ���Ѵ�.
		
	}
}
