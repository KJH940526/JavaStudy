package chapter4;

public class Test3 {
	public static void main(String[] args) {
		//상수 -> 변하지 않는 수
		final int MAX_NUM = 100;
		final float PI = 3.14f;
		
		final int STUDENT_NUM = 30;
		
		//리터럴: 프로그램에서 사용하는 모든 숫자, 값, 논리값
		
		//형변환
		int iNum;
		double dNum = 3.14;
		iNum = (int)dNum;
		System.out.println(iNum);
		float fNum = 0.9f;
		System.out.println((int)(fNum)); // 0.9가 0이 됨 => 아래 연산의 값이 달라짐
		
		int num1 = (int)dNum + (int)fNum;
		int num2 = (int)(dNum + fNum);

		System.out.println(num1);
		System.out.println(num2);
	}

}
