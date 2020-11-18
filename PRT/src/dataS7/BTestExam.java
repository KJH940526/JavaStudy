package dataS7;

import java.util.Stack;

public class BTestExam {

	public static void main(String[] args) {

		// 스택을 이용한 괄호 검사
		//왼쪽 괄호 오른쪽 사이 같아야하고
		//같은 괄호에는 왼쪽 괄호가 오른쪽 괄호보다 먼저 나와야한다
		// 괄호 사이가 포함 관계만 존자한다                                => 잘못된 사용    a{b(c[d]e}f)  이상하게 묶음 짝은 
		
		
		//괄호검사 스택
		String expression = "[a{b+c-(a*3)}+4}";
		System.out.println(checkMatch(expression)); // false

		expression = "[a{b+c-(a*3)+4}]";
		System.out.println(checkMatch(expression)); // true
	}

	public static boolean checkMatch(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = expression.toCharArray(); // 문자열 expression을 char배열로 바꾸고 arr배열에 넣음

		// 김준호 버전 이상할 수 있음 //푸쉬가 많은 경우를 고려하지 않았음  //다시 하기
//			for(int i = 0; i < arr.length; i++) {
//				switch(arr[i]) {
//				case '(': case '{': case '[':	//for문으로 배열을 다 돌아! 그리고 배열에서 ( { [가 있으면 push를 해주세요
//					stack.push(arr[i]);
//				case ')':						//문자열을 검사하면서 switch로 (,{,[를 검사해서 이것들을 푸쉬해준다.
//					if(arr[i]==')') {
//						stack.pop();			//그리고 case에 if문으로 ),},]를 확인하여 비어있는지 확인하고 팝을 한다.
//					} else if(stack.isEmpty()){						
//						return false;
//					}							//그리고 비어있으면 false를 준다
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
//				} //여기에 스택이 비어있지 않은 경우를 리턴해줘야함 어떤경우냐? 푸쉬가 더 많은경우 팝보다 ex) [[[]]{}
//			} return true;					//이상이 없으면 true;

		
		// 선생님 버전  ***
		boolean retVal = true;								//처음에 true를 리턴받을 boolean을 선언해주고
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
				stack.push(arr[i]);							//if문으로 stack에 push 해주고
			} else {										//push가 끝나면
				switch (arr[i]) {
				case '}':									//stack이 비어있거나 or 꺼낸 pop이 { 이 아니라면 false를 리턴한다.
					if (stack.empty() || stack.pop() != '{')
						retVal = false;
					break;
				case ']':									//stack이 비어있거나 or 꺼낸 pop이 [ 이 아니라면 false를 리턴한다.
					if (stack.empty() || stack.pop() != '[')
						retVal = false;
					break;
				case ')':									//stack이 비어있거나 or 꺼낸 pop이 ( 이 아니라면 false를 리턴한다.
					if (stack.empty() || stack.pop() != '(')
						retVal = false;
					break;
				}
				if (!retVal)								//위에서 retVal이 false가 되는 순간 빠져나와서 false를 리턴한다.
					return retVal;
			}
		}													
		if (!stack.empty()) {								// stack이 비어있지 않으면 pop보다 push가 많았다는 소리이기 떄문에
			retVal = false;									// retVal에 false를 리턴한다
		}
		return retVal;										//그리고 checkMatch에 리턴한다.
	}

}
