package chapter2;

public class BinaryTest {
	public static void main(String[] args) {
		
		//int는 4바이트(32비트)의 크기를 가진 자료형
		
		int num = 10;
		int bNum = 0B1010; //앞에 0B가 붙으면 2진수
		int oNum = 012; // 앞에 0이 붙으면 8진수
		int hNum = 0XA; // 앞에 0X가 붙으면 16진수
		
		System.out.println(num);
		System.out.println(bNum); 
		System.out.println(oNum);
		System.out.println(hNum);
		
		//음수를 나타내는법 int는 32bit이다
		//정수의 가장 왼쪽에 존재하는 비트는 부호비트 입니다.
		//예시 0000 0101 => 5
		//1의 보수를 취한다 1111 1010 
		//1을 더한다 => 1111 1011
		
		int num1 = 0B00000000000000000000000000000101; //5
		int num2 = 0B11111111111111111111111111111011; //-5
		int sum = num1 + num2;
		System.out.println(sum);
	}
}
