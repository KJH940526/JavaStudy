package dataS7;

import java.util.Stack;

public class BTestExam {

	public static void main(String[] args) {

		// ������ �̿��� ��ȣ �˻�
		//���� ��ȣ ������ ���� ���ƾ��ϰ�
		//���� ��ȣ���� ���� ��ȣ�� ������ ��ȣ���� ���� ���;��Ѵ�
		// ��ȣ ���̰� ���� ���踸 �����Ѵ�                                => �߸��� ���    a{b(c[d]e}f)  �̻��ϰ� ���� ¦�� 
		
		
		//��ȣ�˻� ����
		String expression = "[a{b+c-(a*3)}+4}";
		System.out.println(checkMatch(expression)); // false

		expression = "[a{b+c-(a*3)+4}]";
		System.out.println(checkMatch(expression)); // true
	}

	public static boolean checkMatch(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = expression.toCharArray(); // ���ڿ� expression�� char�迭�� �ٲٰ� arr�迭�� ����

		// ����ȣ ���� �̻��� �� ���� //Ǫ���� ���� ��츦 ������� �ʾ���  //�ٽ� �ϱ�
//			for(int i = 0; i < arr.length; i++) {
//				switch(arr[i]) {
//				case '(': case '{': case '[':	//for������ �迭�� �� ����! �׸��� �迭���� ( { [�� ������ push�� ���ּ���
//					stack.push(arr[i]);
//				case ')':						//���ڿ��� �˻��ϸ鼭 switch�� (,{,[�� �˻��ؼ� �̰͵��� Ǫ�����ش�.
//					if(arr[i]==')') {
//						stack.pop();			//�׸��� case�� if������ ),},]�� Ȯ���Ͽ� ����ִ��� Ȯ���ϰ� ���� �Ѵ�.
//					} else if(stack.isEmpty()){						
//						return false;
//					}							//�׸��� ��������� false�� �ش�
//				case '}':
//					if(arr[i]=='}') {
//						stack.pop();
//					} else if(stack.isEmpty()){
//						return false;
//					}
//				case ']':
//					if(arr[i]==']') {
//						stack.pop();
//					} else if(stack.isEmpty()){
//						return false;
//					}
//				} //���⿡ ������ ������� ���� ��츦 ����������� �����? Ǫ���� �� ������� �˺��� ex) [[[]]{}
//			} return true;					//�̻��� ������ true;

		
		// ������ ����  ***
		boolean retVal = true;								//ó���� true�� ���Ϲ��� boolean�� �������ְ�
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
				stack.push(arr[i]);							//if������ stack�� push ���ְ�
			} else {										//push�� ������
				switch (arr[i]) {
				case '}':									//stack�� ����ְų� or ���� pop�� { �� �ƴ϶�� false�� �����Ѵ�.
					if (stack.empty() || stack.pop() != '{')
						retVal = false;
					break;
				case ']':									//stack�� ����ְų� or ���� pop�� [ �� �ƴ϶�� false�� �����Ѵ�.
					if (stack.empty() || stack.pop() != '[')
						retVal = false;
					break;
				case ')':									//stack�� ����ְų� or ���� pop�� ( �� �ƴ϶�� false�� �����Ѵ�.
					if (stack.empty() || stack.pop() != '(')
						retVal = false;
					break;
				}
				if (!retVal)								//������ retVal�� false�� �Ǵ� ���� �������ͼ� false�� �����Ѵ�.
					return retVal;
			}
		}													
		if (!stack.empty()) {								// stack�� ������� ������ pop���� push�� ���Ҵٴ� �Ҹ��̱� ������
			retVal = false;									// retVal�� false�� �����Ѵ�
		}
		return retVal;										//�׸��� checkMatch�� �����Ѵ�.
	}

}
