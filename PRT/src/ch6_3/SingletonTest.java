package ch6_3;

final class Singleton{ //클래스 앞에 있으면 상속 불가, 메소드 앞에 final이 있으면 하위클래스에서 오버라이드 불가
	private static Singleton s = new Singleton();
	
	private Singleton() {
		
	}
	
	//static => 싱글톤 객체를 생성하지 않고 
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
		Singleton s = Singleton.getInstance(); //싱글톤 객체를 생성하지 않고 getInstance 메소드를 호출한다.
		
	}
}
