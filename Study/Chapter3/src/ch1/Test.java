package ch1;

public class Test {
	public static void main(String[] args) {
		//���� ������
		//������ ���� �����ϴ� ������
		//�켱 ������ ���� ���� ������
		//���� ������ ������ ����(��)�� ����
		int age = 24;
		System.out.println(age);
		System.out.println();
		
		//��ȣ ������
		int num = 10;
		int num2 = -num;
		System.out.println(num);
		System.out.println(num2);
		num = -num;
		System.out.println(num);
		System.out.println();
		// ��� ������
		// %�� �������� ���ϴ� ������ => ���� n�� �������� 0~n-1 ������ �� => Ư�� ���� ���� ���� ���� �� ���� ���
		
		// ���� ���� ������
		// ���� ������
		// 1��ŭ ���ϰų� ��ŭ �� �� ����ϴ� ������
		// ���� ��/�� ��ġ�� ���� ������ ����� �޶����� ����
		num = 10;
		int val = ++num; //���� num���� 1 ������ �� val ������ ����  
		System.out.println(val);
		
		num = 10;
		System.out.println(num++);
		
		num = 10;
		int val2 = num++; //val ������ ���� num ���� ���� ������ �� num �� 1����  
		System.out.println(val2);
		System.out.println(num);
		System.out.println();
		
		// ���迬����
		// ������ ����� true,false�� ��ȯ ��
		System.out.println(3<5);
		System.out.println();
		
		//�� ������
		// ���� �����ڿ� ȥ���Ͽ� ���� ��� ��
		// ������ ����� true, false���� ���ѵ�
		// &&(����) �� ���� ��� ���� ��쿡�� ��, �ƴϸ� ����
		// ||(����) �� �� �� �ϳ��� �׸� ���̸� ��, �� ���� ��� �����̸� ��� ���� ����
		// ! (����) ���� �������Դϴ�. ���� ���� �������� �ٲٰ�, ������ ���� ������ �ٲ� ex) boolean = !(5>3)
		System.out.println((5>3)&&(5>2)); //t
		System.out.println((5>3)&&(5<2)); //f
		
		System.out.println((5>3)||(5>2)); //t
		System.out.println((5>3)||(5<2)); //t
		System.out.println((5<3)||(5<2)); //f

		System.out.println((5>3)); //t
		System.out.println(!(5>3)); //f
		System.out.println();
		
		// �߰�! ****�ܶ� ȸ�� ��****
		// �� ���� �� ���� ��� true �� ���� ����� true => ���� ���� false �̸� �� ���� ����� ������ �ʾƵ� false��
		// �� ���� �� ���� ��� false �� ���� ����� false => ���� ���� true �̸� �� ���� ����� ������ �ʾƵ� true��
		
		int num1 = 10;
		int i = 2;
		// �� ���� �� ���� ��� true �� ���� ����� true => ���� ���� false �̸� �� ���� ����� ������ �ʾƵ� false��
						//���� ���� false => && ���� ���� ���X
		boolean value = ((num1 = num1 + 10 ) < 10 && ( (i = i+2)> 10));
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i); 
		
		num1 = 10;
		i = 2;
							//���� ���� true => && ���� ���� ���
		boolean value1 = ((num1 = num1 + 10 ) > 10 && ( (i = i+2)> 10));
		System.out.println(value1);
		System.out.println(num1);
		System.out.println(i); 
		
		// �� ���� �� ���� ��� false �� ���� ����� false => ���� ���� true �̸� �� ���� ����� ������ �ʾƵ� true��
		num1 = 10;
		i = 2;
							//���� true => || ���� �� ��� X
		boolean value3 = ((num1 = num1 + 10 ) > 10 || ( (i = i+2)> 10));
		System.out.println(value3);
		System.out.println(num1);
		System.out.println(i); 
		
		num1 = 10;
		i = 2;
							//���� false => || ���� �� ���
		boolean value4 = ((num1 = num1 + 10 ) < 10 || ( (i = i+2)> 10));
		System.out.println(value4);
		System.out.println(num1);
		System.out.println(i); 
		
	}
}
