package ch7_8;

class Outer {
	int value=10;   // Outer.this.value;
	
	class Inner{
		int value=20; // this.value;
		
		void method1() {
			int value=30;
			System.out.println("메소드1 "+value);						//30
			System.out.println("이너클래스 "+this.value);				//20
			System.out.println("아우터클래스 "+Outer.this.value);      //10
		}
	}	//이너클래스
}	//아우터 클래스

public class InnerEx5 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method1();
	}
}
