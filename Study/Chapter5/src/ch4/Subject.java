package ch4;
//한번 더 들어봐야할 듯 생성자랑
public class Subject {
	
	String subjectName;
	int score;
	
	//생성자
	public Subject(String name) {
		subjectName = name;
	}
	
	//마우스 오른쪽버튼 클릭 소스 => getter와 setter를 만들수 있다.
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
