package ch4;

public class StudentClass {
	public static void main(String[] args) {
		
		Student studentJame = new Student(100, "James");
		studentJame.setKorea(100);
		studentJame.setMath(100);
		
		Student studentTomas = new Student(101, "Tomas");
		studentTomas.setKorea(80);
		studentTomas.setMath(60);
		
		studentJame.showStudentInfo();
		studentTomas.showStudentInfo();
	}

}
