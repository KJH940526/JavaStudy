package dataS8;


import java.util.Stack;


//�˰��� �ۼ��ɷ� Ű���
//��ü������ ������ ���� �����ϱ�			gof ��ü���� ������ ����


// �ڹٷ� �Ǿ��ִ� ��ü���� ���������� å�� ���� -> �����ϴٰ� gof ������������ ����(���� c++)�� �Ǿ����� // ������������ �߿�
// ���� ���� å ã�ƺ���

public class StackCalculator {
	private String infixExpression;
	
	

	public StackCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}
	
	public int CalculateUsingStack() {

		
		String s = infixToPostfix();
		
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		char[] arr = s.toCharArray(); 					//�迭�� �޾�

		
		
		Stack<Integer> stack = new Stack<Integer>();		//int�� ���ÿ� �ֱ� ���ؼ� integer Ÿ���� ������ ����			
		
		for(int i =0; i <arr.length; i++) {
			if(arr[i]>='0' && arr[i]<'9') {
//				System.out.println("Ÿ��Ȯ�� : " +stack.getClass().getName());
				

				stack.push(arr[i]-'0'); // char���� char�� ���� Ÿ���� int�� �ٲ�� ������ /////// stack�� push�� �� �� �ִ°Ű� '0'�� ���� ������ �׳� ���� �ٲ��� �ʱ� ���ؼ�
				
//				stack.push(arr[i]-48);	//�ƽ�Ű �ڵ� 0�� int�� 48�̱� ������  ���� ���� ����
				
//				System.out.println("-0�� Ÿ�� Ȯ�� : " +(stack.push(arr[i]-'0').getClass().getName()));  //getclass�� object Ÿ�Ը� �� => �����ڷ����� �ȵ�		unboxing integer to int java ���� �˻�
				
			} else if(arr[i] == '+') {				//���ۿ��� char - '0' �˻��ϸ� ���� �ڼ��� ���� ������;
				num1 = stack.pop();
				num2 = stack.pop();
				
				num3 = num2 + num1;
				
				stack.push(num3);
		
			} else if(arr[i] == '-') {
				num1 = stack.pop();
				num2 = stack.pop();
				num3 = num2 - num1;
				stack.push(num3);
		
			}  else if(arr[i] == '*') {
				num1 = stack.pop();
				num2 = stack.pop();
				num3 = num2 * num1;
				stack.push(num3);

			}  else if(arr[i] == '/') {
				num1 = stack.pop();
				num2 = stack.pop();
				
				num3 = num2 / num1;
				stack.push(num3);
				

			}	

		}	
			return num3;

	}			
	

	public String infixToPostfix() {
		String St = this.infixExpression; // StackCalculator �����ڿ��� ������ ��Ʈ�� ���� �ʵ��� infixExprssion
											// �� �������ְ� �� ���� �޼ҵ忡�� St�� ������
		Stack<Character> stack = new Stack<Character>(); // ���� ����
		char[] arr = St.toCharArray(); // St�� char Ÿ���� �迭�� �ٲ�
		String rest = ""; // ����ǥ������� ǥ���� �� ���� ���ٲ�

		// (1+2)*(3/4)+(5+(6-7)) -> 12+34/*567-++
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '(': // 1. ���� ��ȣ�� ������ ���ÿ� Ǫ��
				stack.push(arr[i]);
				break;
			case ')': // 2. ���� ��ȣ�� ( ���Ë� ���� pop�̴ϱ�
				while ('(' != stack.peek()) { // stack.peek()�� �о �� �־��ֱ� ������ �о��ְ�
					rest += stack.pop(); // ������ ���ڿ� ��Ʈ���� pop�� ���ش�.
				}
				stack.pop(); // ) �� ������ (�� �����ֱ� ���� pop�� ���ش�. ��������
				break;

			case '+':
			case '-':
				// top �����ں��� �켱������ �������
				if (stack.empty() || stack.peek() == '(') { // ���� ��ȣ�� ������ push
					stack.push(arr[i]); // ��ȣ�� ��� ������ push
				} else {
					while (!stack.empty() && stack.peek() != '(') {
						rest += stack.pop(); // rest�� pop()�ϰ�
					}
					stack.push(arr[i]);   //������ peek�� ���� �۾�
				}

				break;
			// ���ÿ� �켱������ peek���� �о��ָ� �ɵ�?
			case '*':
			case '/': // top �����ں��� �켱������ ������� (push)
				if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') {
					stack.push(arr[i]);
				}else {
					while (!stack.empty() && stack.peek() != '(') {  //�� stack.peek() != '*' �� �ƴѲ���??
						rest += stack.pop(); // rest�� pop()�ϰ�
					}
					stack.push(arr[i]);	//������ peek�� ���� �۾�
				}
				// top ������ ���� �켱 ������ ���ų� ������ ���� pop�� �ϰ� �׸��� push
				break;

			default:
				rest += arr[i]; // �ǿ����ڵ��� �־�����ϰ�
				break;

			}
		}
		
		if (!stack.empty()) { // �����ִ� ������ �л�
			rest += stack.pop();
		}
		return rest; // 324*+
	}
	
	

}













//public String infixToPostfix2() {
//Stack<Character> stack = new Stack<Character>();
//char[] arr = infixExpression.toCharArray();
//
//
//for (int i = 0; i < arr.length; i++) {
//   if(arr[i] == '(') {
//      stack.push(arr[i]);
//   } else if(arr[i] == ')') {
//      while (stack.peek() != '(') {
//         res += stack.pop();
//      }
//      stack.pop(); 
//   }
//   else if( arr[i] >= '0' && arr[i] <= '9') {
//      res += arr[i];
//   } else { 
//      if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1) ) {
//         while (!stack.empty() && stack.peek() != '(') {
//            res += stack.pop();
//         }
//      }
//      stack.push(arr[i]);
//   }
////   else if( arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i]=='/') {
////      if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1) ) {
////         while (!stack.empty() && stack.peek() != '(') {
////            res += stack.pop();
////         }
////      }
////      stack.push(arr[i]);
////   } else { 
////      res += arr[i];
////   }
//}
//while (!stack.empty()) { // stack�� �����ִ� �͵� �� pop
//   res += stack.pop();
//}
//return res;
//}
//
//public int compareOfOperand (char a, char b) {
//// ������ a�� b���� �켱������ ū ��� +1
//// b�� �� ū��� -1
//// ���� ��� == 0
////int valOfReturn = 0;
////switch(a) {
////case '+':
////case '-':
////   if( b == '/' || b == '*') valOfReturn = -1;
////   else valOfReturn = 0;
////   break;
////case '*':
////case '/':
////   if( b == '+' || b == '-') valOfReturn = 0;
////   else valOfReturn = 1;
////   break;
////}
////return valOfReturn;
//
//// ������ ���
//if(a == '*' || a == '/') {
//   if(b == '/' || b == '*') {
//      return 0;
//   } else {
//      return 1;
//   }
//} else {
//   if(b == '/' || b == '*') {
//      return -1;
//   } else {
//      return 0;
//   }
//}
//}
//

	



//����ǥ��� -> ����ǥ���
//1.�ǿ����ڰ� ������ �ٷ� ���
//2.�����ڰ� ������ �ڱ⺸�� �켱������ ���ų� �����͵��� ���� �ڽ��� ���ÿ� ����
//2. ������ �����ڰ� ���ÿ� �մ� �����ں��� ������ push�ϰ� �켱������ ���ų� ������  ������ �� �� ���� pop�� �ϰ� �켱������ ���ų� �������� push
//3.���� ��ȣ '('�� ������ ������ ���ÿ� ����
//4.�ݴ� ��ȣ ')'�� ���� ������ ���ÿ��� ���
//��ȣ�� ó��
//���� ��ȣ�� ���ÿ� push
//�ݴ� ��ȣ�� ������ ���� ��ȣ�� ���� ������ pop
//�����ڸ� ������ ��, ���� ��ȣ �ʸӱ��� pop ���� �ʵ���
//���� ��ȣ �켱������ ���� ���� ����

// ��ȣ�� ���� ����
// 1) 3 + 2 * 4 => 324*+ 

// ����ǥ��� ����ϴ� ���        (�ǿ����ڿ� �������� �����ؾ� �ϴµ� ��, ���ڸ� �����ϴ� ������ �ʿ�
// stack ���ι���
// 324*+
// 24*+							3
// 4*+							32
// *+							324      //���� ������ �����ϱ� ���굵 ������ �������� 
// +							3   8
//                              11

// 3) 2 * 1 + 3 / 2 ==> 21*32/+
// 3)�� ����					//stack
//   21*32/+
//   1*32/+					2
//   *32/+					21
//   32/+					2
//   2/+					23
//   /+ 					232
//   +						2  32/ (�� �̷������� ���ȴ�)  => 3/2   1.5
//                          3.5

// 2) 2 * 4 + 3 => 24*3+
// 3) 2 * 1 + 3 /2 ==> 21*32/+
// 4) 2 * 2 / 3 ==> 22*3/

// ��ȣ�� ���� 1)�� ���
// 1) 3�� �� ���ڿ��� �ְ�
// 2) +�� stack�� �ִ´�.
// 3) 4�� �� ���ڿ��� �ִ´�
// 4) *�� ������ ��� ������ �׳� push�ϸ� �ǰ� ������� ������ stack�� ���� ���� �ִ� ������(+)���� ���� ������(*)�� �켱������ ������ push
// ���� ���� �ִ� ������ ���� �켱������ ���ų� ������ ������ �� �� ���� pop()�� �ؼ� �ٿ� �׸��� �켱������ ���ų� �������� push()
// 5) �ٽ� ���ڿ� 4�� ���̰�
// 6) ���� ���ڿ��� ��� ���� ���ÿ��� pop()    324*
// 7) ���� ���ڿ��� ��� ���� ���ÿ��� pop()    324*+

//1) ��ȣ�� ����ϴ� ���
//1) (1 * 2  + 3 ) / 4               ==> 12*3+4/
//2) (1 + 2  * 3 ) / 4 				 ==> 123*+4/
//3) 2 * 3 * ( 2 + 4 ) + 10			==>  23*24+*10+

//2.stack�� ���� ���� �ִ� �����ں��� ���� �����ڰ� 
//�켱������ ������ push ���� ���� �ִ� ������ ���� �켱������ ���ų� ������ ������ �� �� ���� pop()�� �ؼ� 
//�ٿ� �׸��� �켱������ ���ų� �������� push()

// ���� ǥ������� ����ϴ� ������  ������������ ����ϸ� ��ȣ�� �����ϰ� �켱������ �������־��� ������ ����ϴ�.