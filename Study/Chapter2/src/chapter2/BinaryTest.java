package chapter2;

public class BinaryTest {
	public static void main(String[] args) {
		
		//int�� 4����Ʈ(32��Ʈ)�� ũ�⸦ ���� �ڷ���
		
		int num = 10;
		int bNum = 0B1010; //�տ� 0B�� ������ 2����
		int oNum = 012; // �տ� 0�� ������ 8����
		int hNum = 0XA; // �տ� 0X�� ������ 16����
		
		System.out.println(num);
		System.out.println(bNum); 
		System.out.println(oNum);
		System.out.println(hNum);
		
		//������ ��Ÿ���¹� int�� 32bit�̴�
		//������ ���� ���ʿ� �����ϴ� ��Ʈ�� ��ȣ��Ʈ �Դϴ�.
		//���� 0000 0101 => 5
		//1�� ������ ���Ѵ� 1111 1010 
		//1�� ���Ѵ� => 1111 1011
		
		int num1 = 0B00000000000000000000000000000101; //5
		int num2 = 0B11111111111111111111111111111011; //-5
		int sum = num1 + num2;
		System.out.println(sum);
	}
}
