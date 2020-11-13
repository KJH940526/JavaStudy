package ch1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 조건문 => 주어진 조건에 따라 다른 수행문이 실행되로고 프로그래밍 하는 것
		// if문, if-else문, if-else if-else문,    switch-case문
		// 간단한 조건문은 조건 연산자로 구현할 수 있음
		int age = 10;
		if(age >= 8 ) {
			System.out.println("학교 다닙니다.");
		}
		System.out.println();
		
		int age1 = 9;
		int charge;
		if(age1 < 8) {
			charge = 1000;
			System.out.println("미 취학 아동");
			age1 = age1 + 1;
		}else if(age1 < 14) {
			charge = 2000;
			System.out.println("초등학생");
		}else if(age1 < 20) {
			charge = 3000;
			System.out.println("청소년");
			age1 = age + 1;
		}else {
			charge = 3000;
			System.out.println("성인");
		}
		System.out.println(charge + "원 입니다");
									// Chapter3 ch1에 나오는 단락 회로 평가와 같은 원리
		System.out.println(age1);   // 9살이 나오는데 위에서 age1 < 8 은 조건식에서 걸려져서 아예 계산을 하지 않는다.
		
		System.out.println();
		//switch-case문  => 조건에 대한 값이 간단한 정수이거나 문자열 일떄 쓰면 간결하게 사용가능
		//스위치와 if문의 비교
		int rank = 1;
		char medalColor;
		if(rank ==1 ) {
			medalColor = 'G';
		} else if(rank == 2) {
			medalColor = 'S';
		} else {
			medalColor = 'A';
		}
		System.out.println(medalColor);
		
		switch (rank) {
		case 1: medalColor = 'G';
				break;
		case 2: medalColor = 'S';
				break;
		default: medalColor = 'A';
		}
		System.out.println(medalColor);	
		switch (rank) {
		case 1: medalColor = 'G';;
		case 2: medalColor = 'S';
		default: medalColor = 'A';
		}
		//break는 switch문을 빠져 나오는데 사용한다. 브레이크가 없어서 전부 다 실행되었기 때문에 A가 출력되었다.
		System.out.println(medalColor);	
		System.out.println();
		
		int month = 10;
		int day;
		// 이런식으로 한번에 여러개도 가능
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			day = 31;
			break;
		case 2:
			day = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		default:
			day = 0;
			break;
		}
		System.out.println(month + "월은" + day + "일까지 있습니다.");
	}

}
