package ch4;
//�ѹ� �� �������� �� �����ڶ�
public class Subject {
	
	String subjectName;
	int score;
	
	//������
	public Subject(String name) {
		subjectName = name;
	}
	
	//���콺 �����ʹ�ư Ŭ�� �ҽ� => getter�� setter�� ����� �ִ�.
	public void setSubjectName(String name) {
		subjectName = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSubjectName() {
		return subjectName;
	}
	
	

}
