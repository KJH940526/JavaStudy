package ch4c;

class BirthDay {

//	int day;
//	int month;
//	int year;
	
	//private ���������ڴ� ���� Ŭ���������� ��밡���Ѵ� => getter�� setter�� �̿��ؾ��Ѵ�.
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	
	//���Ἲ�� ��Ű�� ���ؼ� ����Ѵ�
	public void setDay(int day) {
		if(month == 2) {
			if(day <1 || day>28) {
				System.out.println("���� �����Դϴ�.");
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
	
	//�Ʒ��� �ּ� ������ �Ʒ� main���� set�� ���Ҷ� ���� ���Ҷ� ����Ѵ� ���������ڴ�
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
