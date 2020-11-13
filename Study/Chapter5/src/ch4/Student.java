package ch4;

public class Student {
	
	int studentID;
	String studentName;
	
	//학생이 가진 요소기도 하지만 클래스를 나눴을때 더 깔끔하다. subject로
	/*
	int KoreaScore;
	int mathScore;
	String koreaSubject;
	String mathSubject;
	int engScore;
	String engSubject;
	 */
	
	//이렇게 하는게 참조자료형이다.
	//클래스 안에서 다른 클래스를 참조변수형으로 쓰기 위해서 생성을하고 선언을 함
	Subject korea;  //?
	Subject	math;

	//사용하기 위해서는 생성자를 통해서 인스턴스를 만들어야한다.
	//위에 korea라는 변수명에 Subject라는 클래스를 호출시켰다.
	
	//Subject에서 생성자를 만들엇기떄문에 디폴트 생성자 x
//	public Student() {
//		korea = new Subject(); //
//		math = new Subject();
//	}
	
	//핫키는  컨트를 + 스페이스바
	//생성자 오버로딩
	public Student(int id, String name) {
		studentID = id; 
		studentName = name;
		korea = new Subject("국어");
		math = new Subject("수학");
	}
	
	//메서드
				//본인이가지고 있는 멤버변수(korea)에서 setSubjectName에서 (name)을 넣는다.
	public void setKorea( int score) {
		//korea는 위에서 생성자를 통해서 인스턴스가 만들어졌다.
		korea.setScore(score);
	
//		korea.subjectName = name; //이런식으로 사용도 가능 접근제한자가 preiva
	}
	
	public void setMath( int score) {
		//korea는 위에서 생성자를 통해서 인스턴스가 만들어졌다.
		math.setScore(score);
	}
	
	public void showStudentInfo() {
		int total = korea.getScore() + math.getScore();
		System.out.println(studentName + " 총점은 " + total);
	}
}
