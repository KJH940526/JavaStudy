package chapter4;

public class Test3 {
	public static void main(String[] args) {
		//��� -> ������ �ʴ� ��
		final int MAX_NUM = 100;
		final float PI = 3.14f;
		
		final int STUDENT_NUM = 30;
		
		//���ͷ�: ���α׷����� ����ϴ� ��� ����, ��, ����
		
		//����ȯ
		int iNum;
		double dNum = 3.14;
		iNum = (int)dNum;
		System.out.println(iNum);
		float fNum = 0.9f;
		System.out.println((int)(fNum)); // 0.9�� 0�� �� => �Ʒ� ������ ���� �޶���
		
		int num1 = (int)dNum + (int)fNum;
		int num2 = (int)(dNum + fNum);

		System.out.println(num1);
		System.out.println(num2);
	}

}
