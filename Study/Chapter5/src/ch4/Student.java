package ch4;

public class Student {
	
	int studentID;
	String studentName;
	
	//�л��� ���� ��ұ⵵ ������ Ŭ������ �������� �� ����ϴ�. subject��
	/*
	int KoreaScore;
	int mathScore;
	String koreaSubject;
	String mathSubject;
	int engScore;
	String engSubject;
	 */
	
	//�̷��� �ϴ°� �����ڷ����̴�.
	//Ŭ���� �ȿ��� �ٸ� Ŭ������ �������������� ���� ���ؼ� �������ϰ� ������ ��
	Subject korea;  //?
	Subject	math;

	//����ϱ� ���ؼ��� �����ڸ� ���ؼ� �ν��Ͻ��� �������Ѵ�.
	//���� korea��� ������ Subject��� Ŭ������ ȣ����״�.
	
	//Subject���� �����ڸ� ������⋚���� ����Ʈ ������ x
//	public Student() {
//		korea = new Subject(); //
//		math = new Subject();
//	}
	
	//��Ű��  ��Ʈ�� + �����̽���
	//������ �����ε�
	public Student(int id, String name) {
		studentID = id; 
		studentName = name;
		korea = new Subject("����");
		math = new Subject("����");
	}
	
	//�޼���
				//�����̰����� �ִ� �������(korea)���� setSubjectName���� (name)�� �ִ´�.
	public void setKorea( int score) {
		//korea�� ������ �����ڸ� ���ؼ� �ν��Ͻ��� ���������.
		korea.setScore(score);
	
//		korea.subjectName = name; //�̷������� ��뵵 ���� ���������ڰ� preiva
	}
	
	public void setMath( int score) {
		//korea�� ������ �����ڸ� ���ؼ� �ν��Ͻ��� ���������.
		math.setScore(score);
	}
	
	public void showStudentInfo() {
		int total = korea.getScore() + math.getScore();
		System.out.println(studentName + " ������ " + total);
	}
}
