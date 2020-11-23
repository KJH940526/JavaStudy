package dataS9_1;

import dataS9_1.LinkedTree.TreeNode;
import dataS5.Stack;

public class TreeCalculator<E> {
	private String infixExpression;
	private String postfixExpression = "";		//필드 사용하기
	
	LinkedTree<String> tree = new LinkedTree<String>();	//dataS9_1.LinkedTree

	public TreeCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
		
	}
	
    public String infixToPostfix() {
    	String St = this.infixExpression; // StackCalculator 생성자에서 들어오는 스트링 값을 필드의 infixExprssion
    										// 에 대입해주고 그 값을 메소드에서 St에 대입함
    	Stack<Character> stack = new Stack<Character>(); // 스택 생성
    	char[] arr = St.toCharArray(); // St를 char 타입의 배열로 바꿈
    	//String rest = ""; // 후위표기법으로 표현된 식 리턴 해줄꺼

    	// (1+2)*(3/4)+(5+(6-7)) -> 12+34/*567-++
    	for (int i = 0; i < arr.length; i++) {
    		switch (arr[i]) {
    		case '(': // 1. 여는 괄호는 무조건 스택에 푸쉬
    			stack.push(arr[i]);
    			break;
    		case ')': // 2. 닫힌 괄호는 ( 나올떄 까지 pop이니깐
    			while ('(' != stack.peek()) { // stack.peek()로 읽어서 값 넣어주기 ㅇㅇ로 읽어주고
    				this.postfixExpression += stack.pop(); // 리턴할 문자열 스트링에 pop을 해준다.
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
    					this.postfixExpression += stack.pop(); // rest에 pop()하고
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
    					this.postfixExpression += stack.pop(); // rest에 pop()하고
    				}
    				stack.push(arr[i]);	//다음번 peek를 위한 작업
    			}
    			// top 연산자 보다 우선 순위가 낮거나 같을떄 까지 pop을 하고 그리고 push
    			break;

    		default:
    			this.postfixExpression += arr[i]; // 피연산자들을 넣어줘야하고
    			break;

    		}
    	}
    	
    	if (!stack.empty()) { // 남아있는 연산자 뿅뿅
    		this.postfixExpression += stack.pop();
    	}
    	return this.postfixExpression; // 324*+
    }
    
	////////////////////////////////////////////////////////////
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
   	
   	

    /////////////////////////////////////////////////
   	//이거 내가 하나하나 넣어줘야할듯?
	public LinkedTree<String> makeExpressionTree() {
		//나온 후위연산자를  스택을 통해서 수식트리 만들어주기
		Stack<LinkedTree.TreeNode<String>> stack = new Stack<LinkedTree.TreeNode<String>>();	//이걸로 해야지 stack에 노드를 넣을수 있다

		
		char[] arr = postfixExpression.toCharArray();
		
		//연산자 만나면 팝팝하고
		//새로운 스택에 푸쉬
		//브레이크

		//디폴트(비연산자)
		//새로운 노드 만들고 그대로 푸쉬		
		for(int i = 0; i<arr.length; i++) {
			char s = arr[i];
			switch(s) {
			case '+': case '-': case '*': case '/':
				TreeNode<String> node = new TreeNode<String>(String.valueOf(arr[i])); 
				tree.setRoot(node);						//중심노드
				tree.insertRight(node, stack.pop()); 
				tree.insertLeft(node, stack.pop());
				stack.push(node);
				break;
			
			default:
				stack.push(new TreeNode<String>(String.valueOf(s)));
				break;
			}
		}
		//1. 트리에 넣고
		//2. 계산하는데 계산은 1.자식이 없는 노드까지가고 
		//2. 맨 마지막 노드가 자식이 없을떄 switch를 돌려서 node.left.data는 node.left.right.data  + node.left.left.data를 한다.
		//3. 마지막에 getroot를 해준다? 

		//다른 방식1 root에 1이나 0 같은 특정값을 주고 그게 아니면 루트노드가 아니기떄문에 계산을 끝낼수 있다?
		//다른 방법2 연산하면서 자손노드를 지운다 따라서 자손 노드가 없으면 계산을 멈추고 그 값을 root에 넘겨준다  *******
		
		return tree;
	}

	
	int evaluateExpressionTree(LinkedTree.TreeNode<E> node) {
		int lvalue = 0;
		int rvalue = 0;
		String cal = "";
		if(node.getLeftNode() != null) { // 단말노드가 아닌 경우=연산자!
			lvalue = evaluateExpressionTree(node.getLeftNode());			//재귀
			rvalue = evaluateExpressionTree(node.getRightNode());
			cal = (String) node.getNode();
			return getResult(lvalue, rvalue, cal);
		} else {
			return Integer.parseInt(String.valueOf(node.getNode()));
		}
	}

	public int getResult(int a, int b, String c) {
		int result = 0;
		switch (c) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}
		return result;
	}
}