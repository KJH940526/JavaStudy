package ch7_8;

class Outer {
	int value=10;   // Outer.this.value;
	
	class Inner{
		int value=20; // this.value;
		
		void method1() {
			int value=30;
			System.out.println("�޼ҵ�1 "+value);						//30
			System.out.println("�̳�Ŭ���� "+this.value);				//20
			System.out.println("�ƿ���Ŭ���� "+Outer.this.value);      //10
		}
	}	//�̳�Ŭ����
}	//�ƿ��� Ŭ����

public class InnerEx5 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method1();
	}
}
