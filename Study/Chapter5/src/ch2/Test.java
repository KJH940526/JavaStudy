package ch2;
//메서드란?
/*
 * 메서드는 함수의 일종
 * 객체의 기능을 제공하기 위한 클래스 내부에 구현되는 함수
 * 함수중에서 클래스 안에 구현된 멤버변수들을 이용해서 구현된 함수를 메서드라고 부른다.
 * 
 * 함수란??
 * 하나의 기능을 수행하는 일련의 코드  ** 함수는 하나의 기능만 구현하는게 좋다
 * 중복되는 기능은 함수로 구현하여 함수를 호출하여 사용함
 * 
 */

public class Test {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		// 함수를 실행하고 반환된 결과값(30)을 sum에 대입한다.
		int sum  = addNum(num1,num2); //addNum() 함수호출			
		System.out.println(sum);
	}
	
	//int는 함수의 반환형, addNum(함수이름), // int n1, int n2는 매개변수
	public static int addNum(int n1, int n2) {
		int result = n1 +n2;
		System.out.println(n1+n2);
		return result; //결과값 반환
	}
	// 매개변수 : 함수의 수행을 위해 필요한 변수
	// return : 함수 수행 결과를 반환하기 위한 예약어
	// 함수 반환형 : 반환 값의 자료형을 나타냄(여기서는 int) 반환값이 없는 경우 void라고 씀

	
	
	

}
