package ch3;
// http://tcpschool.com/java/java_class_intro
// 클래스와 인스턴스
				// 생성(인스턴스 화)
// 클래스(static 코드)      ->      인스턴스(dynamic memory)
								//인스턴스는 메모리에 할당된 객체를 의미한다.
// 클래스 생성하기
// 클래스를 사용하기 위해서는 인스턴스를 생성하여야 함

// 클래스이름 변수이름 = new 생성자(클래스이름);
// 생성자는 클래스랑 이름이 같아야함
// new를 써서 생성자를 호출함

// 인스턴스와 힙(heap) 메모리
// 하나의 클래스 코드로 부터 여러 개의 인스턴스를 생성
// 인스턴스는 힙 메모리에 생성됨, 각각의 인스턴스는 다른 메모리에 다른 값을 가짐


public class Student {

		int studentID;
		String studentName;
		int grade;
		String address;
		
		// 생성자
		// 인스턴스 생성시 new 키워드와 함께 사용했던 생성자
		// 생성자가 하나도 없는 경우는 자바컴파일러에 의해 디폴트 생성자가 만들어진다
		
		// 디폴트 생성자
		// 하나의 클래스에는 반드시 적어도 하나 이상의 생성자가 존재
		// 생성자를 기술하지 않으면 디폴트 생성자가 생김
		// 만약 클래스에 매개변수가 이쓴 생성자를 추가하면 디폴트 생성자는 제공되지 않음
		// 예시로 아래 디폴트 생성자를 주석처리하면 test에서 생성자가 없다고 뜸
		
		// 생성자의 용도는 객체를 생성하면서 해야할 일들을 구현하는 것
		// 생성자는 메소드가 아님, 상속되지 않으며, 리턴 값은 없다.
	//접근제한자  //클래스네임
		public Student( ) {
		} // 디폴트 생성자를 임의로 만듬 => 생성자가 아래에 있기떄문에 안 만들어진다.
		  // 위아래와 같은 경우는 생성자 오버로딩이라고 말한다.
		
						//매개변수 리스트
		public Student(int id, String name) { //학생이 생성될때 id와 name을 변수로 받을것이다.
			studentID = id;
			studentName = name;
		};
		


		
		public void showStudnetInfo() {
			System.out.println(studentName + "," + address);
		};
		
		public String getStudnetName() {
			return studentName;
		};
		
		public void setStudnetName(String name) {
			studentName = name;
		};
}

