package dataS9_1;

import java.util.*;
import dataS9_1.LinkedTree.TreeNode;


public class TreeCalculator<E> {
	private String infixExpression;
	private String postfixExpression = ""; // 필드 사용하기

	LinkedTree<String> tree = new LinkedTree<String>(); // dataS9_1.LinkedTree

	public TreeCalculator(String infixExpression) {
		this.infixExpression = infixExpression;

	}
	
	public String infixToPostfix() {
		String St = this.infixExpression; // StackCalculator 생성자에서 들어오는 스트링 값을 필드의 infixExprssion
											// 에 대입해주고 그 값을 메소드에서 St에 대입함
		Stack<Character> stack = new Stack<Character>(); // 스택 생성
		char[] arr = St.toCharArray(); // St를 char 타입의 배열로 바꿈
		// String rest = ""; // 후위표기법으로 표현된 식 리턴 해줄꺼

		// (1+2)*(3/4)+(5+(6-7)) -> 12+34/*567-++
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '(': // 1. 여는 괄호는 무조건 스택에 푸쉬
				stack.push(arr[i]);
				break;
			case ')': // 2. 닫힌 괄호는 ( 나올 까지 pop이니깐
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
					stack.push(arr[i]); // 다음번 peek를 위한 작업
				}

				break;
			// 스택에 우선순위는 peek으로 읽어주면 될듯?
			case '*':
			case '/': // top 연산자보다 우선순위가 높은경우 (push)
				if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') {
					stack.push(arr[i]);
				} else {
					while (!stack.empty() && stack.peek() != '(') { // 왜 stack.peek() != '*' 가 아닌껄가??
						this.postfixExpression += stack.pop(); // rest에 pop()하고
					}
					stack.push(arr[i]); // 다음번 peek를 위한 작업
				}
				// top 연산자 보다 우선 순위가 낮거나 같을 까지 pop을 하고 그리고 push
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

	
	
	
	public LinkedTree<String> makeExpressionTree() {
		// 나온 후위연산자를 스택을 통해서 수식트리 만들어주기
		
		// 스택에 링크드트리의 노드 -> 1)우리가만든 트리노드를 통해서 생성자메소드를 쓰기 위해서 2)Node를 값과 레퍼런스를 유지하기 위해서
		Stack<LinkedTree.TreeNode<String>> stack = new Stack<LinkedTree.TreeNode<String>>(); // 이걸로 해야지 stack에 노드를 넣을수 있음
																								
		
		char[] arr = postfixExpression.toCharArray();

		// 연산자 만나면 팝팝하고
		// 새로운 스택에 푸쉬
		// 브레이크
		// 디폴트(비연산자)
		// 새로운 노드 만들고 그대로 푸쉬
	
		for (int i = 0; i < arr.length; i++) {
			char s = arr[i];
			switch (s) {
			case '+':
			case '-':
			case '*':
			case '/':
				System.out.println("연산자");
				TreeNode<String> node = new TreeNode<String>(String.valueOf(arr[i]));
				tree.setRoot(node); // 중심노드
				System.out.println("연산자: " +tree.getRoot().data);  //
				tree.insertRight(node, stack.pop());
				System.out.println("라이트 : " + node.right.data);
				tree.insertLeft(node, stack.pop());
				System.out.println("레프트 : " + node.left.data);
				stack.push(node);
				break;

			default:
				stack.push(new TreeNode<String>(String.valueOf(s)));
				System.out.println("스태의 피크 데이터" +stack.peek().data);
				break;
			}
		}


		// 다른 방식1 root에 1이나 0 같은 특정값을 주고 그게 아니면 루트노드가 아니기문에 계산을 끝낼수 있다?
		// 다른 방법2 연산하면서 자손노드를 지운다 따라서 자손 노드가 없으면 계산을 멈추고 그 값을 root에 넘겨준다 *******
		return tree;
	}

	
	
	// 비교하기
	// 1. 트리에 넣고
	// 2. 계산하는데 계산은 1.자식이 없는 노드까지가고
	// 2. 맨 마지막 노드가 자식이 없을까지 if문이랑 for문을 리고 node.left.data는 node.left.right.data +
	// node.left.left.data를 한다.
	// 3. 마지막에 상위 노드가 없으면 반환받는다. 이렇게 생각했었음
	
	// 2. 에서 LinkedTree에서 getLeftNode라는 생성자 메소드를 만들어서 노드의 left값을 받아와서 확인
	// 3. 
	
	//서브 트리 역시 서브트리로 이뤄져 있고 또 서브트리는 또 이루어져있다 -> 재귀를 쓰고 재귀의 종료조건은 단말노드 일
	int evaluateExpressionTree(LinkedTree.TreeNode<E> node) {
		System.out.println("매개변수 node: " +node.data);
		int lvalue = 0;
		int rvalue = 0;
		String cal = "";
		if (node.getLeftNode() != null && node.getRightNode() != null) { // 노드가 추가로 있음 -> 연산자임
			lvalue = evaluateExpressionTree(node.getLeftNode()); // 재귀
			System.out.println("왼쪽 벨류 : "+lvalue);
			System.out.println();
			rvalue = evaluateExpressionTree(node.getRightNode());
			System.out.println("오른 벨류 : "+rvalue);
			System.out.println();
			cal = (String) node.getNode();
			return getResult(lvalue, rvalue, cal);			//이 결과값이 다시 노드로?
			
		} else { 											//피연산자
			System.out.println("겟노드 : " +node.getNode());
			System.out.println();
			System.out.println("노드 데이타: "+node.data);
			return Integer.parseInt(String.valueOf(node.getNode()));
		}
	}

	public int getResult(int a, int b, String c) {
		System.out.println("int a: " + a + " int b: "+ b + " String c: " +c);
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
		System.out.println("결과값: "+result);
		return result;
	}
}