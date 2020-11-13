package ch7_7;

public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv;	//외부 클래스의 private멤버도 접근 가능하다.
		int iiv2 = outerCv;
	}
	
	static class StaticInner{
		//스태틱 클라스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
//		int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;//JDK 1.8부터 final 생략 가능
		
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv; //바깥쪽 클래스의 인스턴스변수    myMethod에 있는 LocalInner도 인스턴스 클래스이기 떄문에 접근가능
			// 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능하다.
			int liv3 = lv; //에러!! (JDK1.8부터 에러 아님)
			int liv4 = LV; //OK
		}
	}

}


