package baeS1;

public class Student {
	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int enlishScore, int mathScore) {
		this.name = name;
		this.englishScore  = enlishScore;
		this.mathScore = mathScore;
	}

	
	public String getName() {
		return name;
	}



	public int getEnglishScore() {
		return englishScore;
	}



	public int getMathScore() {
		return mathScore;
	}


	
	

}
