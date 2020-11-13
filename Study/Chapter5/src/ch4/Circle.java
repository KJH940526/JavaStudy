package ch4;

//언어에서 제공해주는 기본 자료형 (int, long, float, double 등)

// 참조 자료형
// 자바 라이브러리에서 클래스로 제공되는 자료형 (String, Date) + Student처럼 직접 만든 자료형 => 참조 자료형
// 클래스형으로 선언하는 자료형



public class Circle {
	
	Point point; //클래스 안에서 다른 클래스를 참조변수형으로 쓰기 위해서 생성을하고 선언을 함
	int radius;
	
	//생성자
	public Circle() {
		point = new Point();
	}
}
