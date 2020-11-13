package ch1;
//this가 하는 일
// 자신의 메모리를 가르킴
// 생성자에서 다른 생성자를 호출
// 자신의 주소를 반환 함

class Birthday{
	int day;
	int month;
	int year;
	
	// 이클립스에서 멤버 변수는 파랑색으로 표시된다.
	public void setYear(int year) {
		//자신의 메모리를 가르키는 this
		this.year = year;
		// year = year;  //이런식으로 코드를 짜면 멤버변수 year가 아니라 지역변수 year에 매개변수를 넣는 의미없는 코딩
		// year = y 	// 항상 자기에서 가까운 곳을 인식하기 떄문에 this를 안 쓸꺼면 이런식이면 바꾸고 매개변수를 y로 바꾼다.     
	}
	public void printThis() {
		System.out.println(this);
	}
}

	//생성자에서 다른 생성자를 호출하는 this
	

public class ThisExample {
	public static void main(String[] args) {
		
		Birthday b1 = new Birthday();
		Birthday b2 = new Birthday();
		
		System.out.println(b1); 
		b1.printThis();          //위와 메모리 주소가 같다 => 자신의 메로리를 가르키는 this를 사용했기 때문
		
		System.out.println(b2);
		b2.printThis(); 
		


		
		
		
	}

	//자신의 메모리를 가르키는 this => 생성도니 인스턴스 스스로를 가르키는 예약어
}
