package ch4c;

class BirthDay {

//	int day;
//	int month;
//	int year;
	
	//private 접근제어자는 같은 클래스에서만 사용가능한다 => getter와 setter를 이용해야한다.
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	
	//무결성을 지키기 위해서 사용한다
	public void setDay(int day) {
		if(month == 2) {
			if(day <1 || day>28) {
				System.out.println("날자 오류입니다.");
			}
		} else {
			this.day = day;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	
	//아래를 주석 잡으면 아래 main에는 set을 못할때 변경 못할때 사용한다 접근제한자는
	public void setYear(int year) {
		this.year = year;
	}
}

public class BirthDayTest {
	
	public static void main(String[] args) {
		
		BirthDay day = new BirthDay();
//		day.month = 2;
//		day.day = 30;
//		day.year = 2018;
		
		day.setMonth(2);
		day.setDay(30);
		day.setYear(2018);
		
		
	}
	
}
