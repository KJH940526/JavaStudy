package ch1;
//객체 지향프로그래밍과 클래스
//객체 지향 프로그래밍에서는 모든 데이터를 객체(object)로 취급하며, 이러한 객체가 바로 프로그래밍의 중심이 됩니다.
//객체 지향 프로그래밍 => 객체를 정의 , 객체의 기능 구현, 객체 사이의 협력 구현

//클래스란? 객체에 대한 속성과 기능을 코드로 구현 한것 
//객체의 속성
//객체의 특성, 속성, 멤버 변수
//property, attribute, member variable

//객체의 기능
//객체가 하는 기능들을 메서드로 구현
//method, member function

//클래스 정의  => 속성을 멤버변수로 만들고, 기능들을 메서드로 만든다. ex)학생 클래스의 예// 속성: 학번,이름 등등 // 기능: 수강신청, 시험, 공부 등등

//하나의 java 파일에 하나의 클래스르 두는 것이 원치이나, 여러 개의 클래스가 같이 있는 경우 public 클래스는 단 하나이며,
//public 클래스와 자바 파일의 이름은 동일해야 함

public class Student {
		int studentID;
		String studentName;
		int grade;
		String address;
		
		public void showStudnetInfo() {
			System.out.println(studentName + "," + address);
		}
	
//		//메인 함수가 있는 쪽으로 실행한다.
//		public static void main(String[] args) {
//			Student studentLee = new Student();
//			studentLee.studentName = "이순신";
//			studentLee.address = "서울시";
//			
//			studentLee.showStudnetInfo();
//			
//		}
		
		//ch2 후반
		//이름을 외부에다가 알려주는 메서드 // 외부에서 쓰이는걸 만들기 위해 get라고 한다. 보통
				//String은 반환형 => studentName이 스트링 타입이기 떄문
		public String getStudnetName() {
			return studentName;
		};
		
			//반환값이 없음			//매개변수가 String
		public void setStudnetName(String name) {
			studentName = name;
		}
		
}
