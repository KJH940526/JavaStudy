package ch3;

public class StudentTest {

	//main 함수는 클래스안에 쓰지만 메서드는 아니다.
	public static void main(String[] args) {
		
		//변수는 기본자로형이랑 참조자로형으로 나뉜다.
		//기본 자료형(객체x)
		int i = 10;  
		
		//객체타입                     //new를 써서 생성자를 호출해야함
		Student studentLee = new Student(100,"이순신");		//heap 메모리에 생성됨
		//참조변수가 생성됨// studenLee에 . 찍으면 참주할수 있는 값들이 나타남
		studentLee.address = "서울시";
		
		Student studentKim = new Student();
		studentKim.studentName = "김순신";
		studentKim.studentID = 100;
		studentKim.address = "성남시";
		
		studentLee.showStudnetInfo();
		studentKim.showStudnetInfo();
		
		System.out.println(studentKim); //ch3.Student@15db9742 이런식으로 나오는데 ch3는 패키지이고 Student가 나옴
		System.out.println(studentLee); //16진수로 표현되는데 16진수는 각 4바이트기 때문에 32비트의 주소를 가진다.
										//heap메모리 생성된 주소값이다.
		
		// 클래스 => 객체를 프로그래밍하기 위해 코드로 만든 상태
		// 인스턴스 => 클래스가 메모리에 생성된 상태
		// 멤버변수 => 클래스의 속성, 특성
		// 메서드 => 멤버 변수를 이용하여 클래스의 기능을 구현
		// 참조변수 => 메모리에 생성된 인스턴스를 가리키는 변수
		// 참조 값 => 생성된 인스턴스의 메모리 주소 값
		

	}
}

