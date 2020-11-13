package ch7_6;

class InnerEx1 {
	class InstanceInner { // 인스턴스 클래스
		int iv = 100;
//		static int cv =100;					//에러! static 변수를 선언할 수 없다.
		final static int CONST = 100; // final static은 상수이므로 허용한다.
	}

	static class StaticInner {
		int iv = 200;
		static int cv = 200; // static 클래스만 static멤버를 정의할 수 있다.
	}

	void myMethod() {
		class LocalInner {
			int iv = 300;
//			static int cv =300;					//에러! static 변수를 선언할 수 없다.
			final static int CONST = 300; // final static은 상수이므로 허용한다.
		}
	}

	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}

	
	
	
	// 인스턴스멤버 간에는 서로 직접 접근이 가능하다.
	// 스테틱 멤버 간에는 서로 직접 접근이 가능하다
	
	// 스태틱 멤버는 인스턴스멤버에 직접 접근할 수 없다.
	// 접근할려면 객체를 생성해야 한다.
	// 인스턴스클래스는 외부 클래스를 먼저 생성해야만 생겅할 수 있다.
	
	
	// 인스턴스메서드에는 인스턴스멤버와 스태틱멤버 모두 접근 가능하다.
	// 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근 할 수 없다.
}