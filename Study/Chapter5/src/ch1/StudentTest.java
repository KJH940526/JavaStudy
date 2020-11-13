package ch1;

public class StudentTest {
	
	//메인 함수가 있는 쪽으로 실행한다.
	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.studentName = "이순신";
		studentLee.address = "서울시";
		
		studentLee.showStudnetInfo();	
	}
}


