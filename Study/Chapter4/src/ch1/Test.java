package ch1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ǹ� => �־��� ���ǿ� ���� �ٸ� ���๮�� ����Ƿΰ� ���α׷��� �ϴ� ��
		// if��, if-else��, if-else if-else��,    switch-case��
		// ������ ���ǹ��� ���� �����ڷ� ������ �� ����
		int age = 10;
		if(age >= 8 ) {
			System.out.println("�б� �ٴմϴ�.");
		}
		System.out.println();
		
		int age1 = 9;
		int charge;
		if(age1 < 8) {
			charge = 1000;
			System.out.println("�� ���� �Ƶ�");
			age1 = age1 + 1;
		}else if(age1 < 14) {
			charge = 2000;
			System.out.println("�ʵ��л�");
		}else if(age1 < 20) {
			charge = 3000;
			System.out.println("û�ҳ�");
			age1 = age + 1;
		}else {
			charge = 3000;
			System.out.println("����");
		}
		System.out.println(charge + "�� �Դϴ�");
									// Chapter3 ch1�� ������ �ܶ� ȸ�� �򰡿� ���� ����
		System.out.println(age1);   // 9���� �����µ� ������ age1 < 8 �� ���ǽĿ��� �ɷ����� �ƿ� ����� ���� �ʴ´�.
		
		System.out.println();
		//switch-case��  => ���ǿ� ���� ���� ������ �����̰ų� ���ڿ� �ϋ� ���� �����ϰ� ��밡��
		//����ġ�� if���� ��
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
		//break�� switch���� ���� �����µ� ����Ѵ�. �극��ũ�� ��� ���� �� ����Ǿ��� ������ A�� ��µǾ���.
		System.out.println(medalColor);	
		System.out.println();
		
		int month = 10;
		int day;
		// �̷������� �ѹ��� �������� ����
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
		System.out.println(month + "����" + day + "�ϱ��� �ֽ��ϴ�.");
	}

}
