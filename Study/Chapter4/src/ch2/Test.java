package ch2;

public class Test {
	public static void main(String[] args) {
		//�ݺ���
		// �־��� ������ ���� �� ������ ���๮�� �ݺ������� ������
		// while, do-while, for���� ����
		// ������ ������ �ݺ� ���� ���ο� ���� ��Ȯ�� �ڵ��� �ؾ� ��
		
		//while�� => ���ǽ��� ���� ���� ���๮�� �ݺ��ؼ� ����
		int num = 1;
		int sum = 0;
		while(num <= 10) {
			sum += num; 
			num++;		//sum ������ ���� num ���� ���� ������ �� num �� 1����  //Chpt3 ch1
		}
		System.out.println(sum);
		System.out.println(num);   //10���� ������ �ؼ� 11�� �ǰ� while���� ���� ���� ���°ű� ������ 11�� �ȴ�
		System.out.println();
		num = 1;
		sum = 0;
		while(num < 1) {
			sum += num; 
			num++;
			System.out.println("�ٺ�"); //���� �ȵ�
		}
		System.out.println(sum);
		System.out.println();	
		
		//do while��
		num = 1;
		sum = 0;
		do {				//do���� ���ǽ�(while)���� �ڿ� �ֱ⋚���� ������ �ѹ��� ����ȴ�.
			sum += num; 
			num++;
			System.out.println("�ٺ�");
		}while(num < 1);
		System.out.println(sum);
		System.out.println();
		
		// for��
		// �ݺ��� �� ���� ���� ����ϴ� �ݺ���
		// �ַ� ������ Ƚ���� ��쿡 ���, �ʱ�ȭ��, ���ǽ�,�������� �Ѳ����� �ۼ�
		int num1;
		int sum1;
		// �ʱ�ȭ�� ����                   //num1 <=10(���ǽ�); num1++(������)
		for (num1 = 1, sum1 = 0; num1 <= 10; num1++) {
			sum1 += num1;		//���๮
		// �ʱ�ȭ�� 1�� �����ϰ� => ���ǽĿ� �����ϸ� ���๮ ���� => ������ ���� =>
		// ���ǽ��� �����ϴ��� üũ => ���ǽ��� �����ϸ� ���๮ ���� => ���ǽ��� �������� ������ for�� ���� ����
		}
		System.out.println(sum1);
		System.out.println(num1);  //10���� ������ �ؼ� 11�� �ǰ� while���� ���� ���� ���°ű� ������ 11�� �ȴ�
		System.out.println();
		
		//�� �ݺ����� ����
		//while ��  =>  �ϳ��� ���ǽ�(��, ����)�� ���� �ݺ������� �̷������ ���
		//do-while�� => �ϳ��� ���ǽ�(��, ����)�� ���� �ݺ������� �̷������ ���, �� ���ǽ��� �ڿ� �ձ� ������ ������ �ѹ� �̻��� �����
		//for�� => ���� Ư�� ����, Ƚ���� ������ �ݺ����࿡�� �ַ� ���
		
		//��ø�� �ݺ��� ������ �����
		int dan;
		int times;
		for(dan =2; dan <= 9; dan++) {
			for(times = 1; times <=9; times++) {
				System.out.println(dan + "X" + times + "=" + dan*times);
			}
			System.out.println();
		}
		
		//while��
		int dan1 = 2;
		int time1 = 1;
		
		while(dan1 <=9) {
			time1 = 1;  //���� *** �ʱ�ȭ�� �ʿ��� ������ �̹� ���� ������ while������ 9�� �ǹ��ȱ⶧���� �ٽ� �ʱ�ȭ ������Ѵ�.
			while( time1<=9) {
				System.out.println(dan1 + "X" + time1 + "=" + dan1*time1);
				time1++; // ������ ����������
			}
			dan1++; //���� ���� ������
			System.out.println();
		}
		
		//continue��
		//�ݺ����� �Բ� ���̸�, �ݺ��� ���� continue ���� ������ ���� �ݺ��Ǵ� �κ��� �������� �ʰ� ���ǽ��̳� �������� ������
		
		int total = 0;
		int num3;
		// 1���� 100���� ¦���� �� 
		for (num3 =1; num3<=100; num3++) {
			if( (num3 % 2) == 1) {
				continue; //=> �ٽ� ���������� �� => �ڿ� +=�� ���� ����
			}
			total += num3;
		}
		System.out.println(total);
		System.out.println("--------");
		
		//break��
		//�ݺ������� break ���� ������ �� �̻� �ݺ��� �������� �ʰ� �ݺ����� ���� ����
		int sum4 = 0;
		int num4 = 0;
		
		while( sum4 < 100) {
			sum4 += num4;
			num4++;
		}
		System.out.println(sum4);
		System.out.println(num4);    //15
		sum4 = 0;
		num4 = 0;
		
		while (true) {
			sum4 += num4;
			if(sum4 > 100) {
				break;
			}
				num4++;
			
		}
		System.out.println(sum4);
		System.out.println(num4); //14���� �̹� 100�� �Ѿ��� break�� ������ ������ �ݺ����� �������� => num4++ �� ����ȵ�
		
		
		
	}

}
