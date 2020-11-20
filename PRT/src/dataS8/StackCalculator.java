package dataS8;


import java.util.Stack;


//알고리즘 작성능력 키우기
//객체지향의 디자인 패턴 공부하기			gof 객체지향 디자인 패턴


// 자바로 되어있는 객체지향 디자인패턴 책도 있음 -> 공부하다가 gof 디자인패턴을 공부(보통 c++)로 되어있음 // 디자인패턴이 중요
// 쉽게 나온 책 찾아보기

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
		char[] arr = s.toCharArray(); 					//배열을 받아

		
		
		Stack<Integer> stack = new Stack<Integer>();		//int를 스택에 넣기 위해서 integer 타입의 스택을 만듬			
		
		for(int i =0; i <arr.length; i++) {
			if(arr[i]>='0' && arr[i]<'9') {
//				System.out.println("타입확인 : " +stack.getClass().getName());
				

				stack.push(arr[i]-'0'); // char에서 char를 빼면 타입이 int로 바뀌기 때문에 /////// stack에 push를 할 수 있는거고 '0'을 뺴는 이유는 그냥 값을 바꾸지 않기 위해서
				
//				stack.push(arr[i]-48);	//아스키 코드 0은 int로 48이기 떄문에  위랑 둘이 같음
				
//				System.out.println("-0의 타입 확인 : " +(stack.push(arr[i]-'0').getClass().getName()));  //getclass는 object 타입만 됨 => 원시자료형은 안됨		unboxing integer to int java 구글 검색
				
			} else if(arr[i] == '+') {				//구글에서 char - '0' 검색하면 이유 자세히 나옴 ㅇㅅㅇ;
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
		String St = this.infixExpression; // StackCalculator 생성자에서 들어오는 스트링 값을 필드의 infixExprssion
											// 에 대입해주고 그 값을 메소드에서 St에 대입함
		Stack<Character> stack = new Stack<Character>(); // 스택 생성
		char[] arr = St.toCharArray(); // St를 char 타입의 배열로 바꿈
		String rest = ""; // 후위표기법으로 표현된 식 리턴 해줄꺼

		// (1+2)*(3/4)+(5+(6-7)) -> 12+34/*567-++
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '(': // 1. 여는 괄호는 무조건 스택에 푸쉬
				stack.push(arr[i]);
				break;
			case ')': // 2. 닫힌 괄호는 ( 나올떄 까지 pop이니깐
				while ('(' != stack.peek()) { // stack.peek()로 읽어서 값 넣어주기 ㅇㅇ로 읽어주고
					rest += stack.pop(); // 리턴할 문자열 스트링에 pop을 해준다.
				}
				stack.pop(); // ) 가 나오면 (를 없애주기 위한 pop을 해준다. 버림버림
				break;

			case '+':
			case '-':
				// top 연산자보다 우선순위가 높은경우
				if (stack.empty() || stack.peek() == '(') { // 여는 괄호는 무조건 push
					stack.push(arr[i]); // 괄호가 비어 있으면 push
				} else {
					while (!stack.empty() && stack.peek() != '(') {
						rest += stack.pop(); // rest에 pop()하고
					}
					stack.push(arr[i]);   //다음번 peek를 위한 작업
				}

				break;
			// 스택에 우선순위는 peek으로 읽어주면 될듯?
			case '*':
			case '/': // top 연산자보다 우선순위가 높은경우 (push)
				if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') {
					stack.push(arr[i]);
				}else {
					while (!stack.empty() && stack.peek() != '(') {  //왜 stack.peek() != '*' 가 아닌껄가??
						rest += stack.pop(); // rest에 pop()하고
					}
					stack.push(arr[i]);	//다음번 peek를 위한 작업
				}
				// top 연산자 보다 우선 순위가 낮거나 같을떄 까지 pop을 하고 그리고 push
				break;

			default:
				rest += arr[i]; // 피연산자들을 넣어줘야하고
				break;

			}
		}
		
		if (!stack.empty()) { // 남아있는 연산자 뿅뿅
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
//while (!stack.empty()) { // stack에 남아있는 것들 다 pop
//   res += stack.pop();
//}
//return res;
//}
//
//public int compareOfOperand (char a, char b) {
//// 연산자 a가 b보다 우선순위가 큰 경우 +1
//// b가 더 큰경우 -1
//// 같은 경우 == 0
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
//// 선생님 방법
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

	



//중위표기법 -> 후위표기법
//1.피연산자가 들어오면 바로 출력
//2.연산자가 들어오면 자기보다 우선순위가 높거나 같은것들을 빼고 자신을 스택에 담음
//2. 들어오는 연산자가 스택에 잇는 연산자보다 높으면 push하고 우선순위가 낮거나 같으면  스택이 빌 떄 까지 pop을 하고 우선순위가 낮거나 같아지면 push
//3.여는 괄호 '('를 만나면 무조건 스택에 담음
//4.닫는 괄호 ')'를 만날 때까지 스택에서 출력
//괄호의 처리
//여는 괄호는 스택에 push
//닫는 괄호를 만나면 여는 괄호가 나올 때까지 pop
//연산자를 만났을 때, 여는 괄호 너머까지 pop 하지 않도록
//여는 괄호 우선순위는 가장 낮게 설정

// 괄호가 없는 경우고
// 1) 3 + 2 * 4 => 324*+ 

// 후위표기법 계산하는 방법        (피연산자와 연산결과를 저장해야 하는데 즉, 숫자를 저장하는 스택이 필요
// stack 가로버전
// 324*+
// 24*+							3
// 4*+							32
// *+							324      //이쪽 방향이 들어오니깐 연산도 들어오는 방향으로 
// +							3   8
//                              11

// 3) 2 * 1 + 3 / 2 ==> 21*32/+
// 3)의 계산법					//stack
//   21*32/+
//   1*32/+					2
//   *32/+					21
//   32/+					2
//   2/+					23
//   /+ 					232
//   +						2  32/ (는 이런식으로 계산된다)  => 3/2   1.5
//                          3.5

// 2) 2 * 4 + 3 => 24*3+
// 3) 2 * 1 + 3 /2 ==> 21*32/+
// 4) 2 * 2 / 3 ==> 22*3/

// 괄호가 없는 1)의 경우
// 1) 3을 새 문자열로 넣고
// 2) +를 stack에 넣는다.
// 3) 4를 새 문자열로 넣는다
// 4) *는 스택이 비어 있으면 그냥 push하면 되고 비어있지 않으면 stack의 제일 위에 있는 연산자(+)보다 넣을 연산자(*)가 우선순위가 높으면 push
// 제일 위에 있는 연산자 보다 우선순위가 낮거나 같으면 스택이 빌 떄 까지 pop()을 해서 붙여 그리고 우선순위가 낮거나 같아지면 push()
// 5) 다시 문자열 4를 붙이고
// 6) 원래 문자열이 비워 지면 스택에서 pop()    324*
// 7) 원래 문자열이 비워 지면 스택에서 pop()    324*+

//1) 괄호를 고려하는 경우
//1) (1 * 2  + 3 ) / 4               ==> 12*3+4/
//2) (1 + 2  * 3 ) / 4 				 ==> 123*+4/
//3) 2 * 3 * ( 2 + 4 ) + 10			==>  23*24+*10+

//2.stack의 제일 위에 있는 연산자보다 넣을 연산자가 
//우선순위가 높으면 push 제일 위에 있는 연산자 보다 우선순위가 낮거나 같으면 스택이 빌 떄 까지 pop()을 해서 
//붙여 그리고 우선순위가 낮거나 같아지면 push()

// 후위 표기법으로 계산하는 이유는  후위계산법으로 계산하면 괄호를 제거하고 우선순위를 정렬해주었기 떄문에 편안하다.