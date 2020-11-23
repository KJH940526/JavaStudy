package dataS9_1;

import dataS9_1.LinkedTree.TreeNode;
import dataS5.Stack;

public class TreeCalculator<E> {
	private String infixExpression;
	private String postfixExpression = "";		//�ʵ� ����ϱ�
	
	LinkedTree<String> tree = new LinkedTree<String>();	//dataS9_1.LinkedTree

	public TreeCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
		
	}
	
    public String infixToPostfix() {
    	String St = this.infixExpression; // StackCalculator �����ڿ��� ������ ��Ʈ�� ���� �ʵ��� infixExprssion
    										// �� �������ְ� �� ���� �޼ҵ忡�� St�� ������
    	Stack<Character> stack = new Stack<Character>(); // ���� ����
    	char[] arr = St.toCharArray(); // St�� char Ÿ���� �迭�� �ٲ�
    	//String rest = ""; // ����ǥ������� ǥ���� �� ���� ���ٲ�

    	// (1+2)*(3/4)+(5+(6-7)) -> 12+34/*567-++
    	for (int i = 0; i < arr.length; i++) {
    		switch (arr[i]) {
    		case '(': // 1. ���� ��ȣ�� ������ ���ÿ� Ǫ��
    			stack.push(arr[i]);
    			break;
    		case ')': // 2. ���� ��ȣ�� ( ���Ë� ���� pop�̴ϱ�
    			while ('(' != stack.peek()) { // stack.peek()�� �о �� �־��ֱ� ������ �о��ְ�
    				this.postfixExpression += stack.pop(); // ������ ���ڿ� ��Ʈ���� pop�� ���ش�.
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
    					this.postfixExpression += stack.pop(); // rest�� pop()�ϰ�
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
    					this.postfixExpression += stack.pop(); // rest�� pop()�ϰ�
    				}
    				stack.push(arr[i]);	//������ peek�� ���� �۾�
    			}
    			// top ������ ���� �켱 ������ ���ų� ������ ���� pop�� �ϰ� �׸��� push
    			break;

    		default:
    			this.postfixExpression += arr[i]; // �ǿ����ڵ��� �־�����ϰ�
    			break;

    		}
    	}
    	
    	if (!stack.empty()) { // �����ִ� ������ �л�
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
   	
   	

    /////////////////////////////////////////////////
   	//�̰� ���� �ϳ��ϳ� �־�����ҵ�?
	public LinkedTree<String> makeExpressionTree() {
		//���� ���������ڸ�  ������ ���ؼ� ����Ʈ�� ������ֱ�
		Stack<LinkedTree.TreeNode<String>> stack = new Stack<LinkedTree.TreeNode<String>>();	//�̰ɷ� �ؾ��� stack�� ��带 ������ �ִ�

		
		char[] arr = postfixExpression.toCharArray();
		
		//������ ������ �����ϰ�
		//���ο� ���ÿ� Ǫ��
		//�극��ũ

		//����Ʈ(�񿬻���)
		//���ο� ��� ����� �״�� Ǫ��		
		for(int i = 0; i<arr.length; i++) {
			char s = arr[i];
			switch(s) {
			case '+': case '-': case '*': case '/':
				TreeNode<String> node = new TreeNode<String>(String.valueOf(arr[i])); 
				tree.setRoot(node);						//�߽ɳ��
				tree.insertRight(node, stack.pop()); 
				tree.insertLeft(node, stack.pop());
				stack.push(node);
				break;
			
			default:
				stack.push(new TreeNode<String>(String.valueOf(s)));
				break;
			}
		}
		//1. Ʈ���� �ְ�
		//2. ����ϴµ� ����� 1.�ڽ��� ���� ���������� 
		//2. �� ������ ��尡 �ڽ��� ������ switch�� ������ node.left.data�� node.left.right.data  + node.left.left.data�� �Ѵ�.
		//3. �������� getroot�� ���ش�? 

		//�ٸ� ���1 root�� 1�̳� 0 ���� Ư������ �ְ� �װ� �ƴϸ� ��Ʈ��尡 �ƴϱ⋚���� ����� ������ �ִ�?
		//�ٸ� ���2 �����ϸ鼭 �ڼճ�带 ����� ���� �ڼ� ��尡 ������ ����� ���߰� �� ���� root�� �Ѱ��ش�  *******
		
		return tree;
	}

	
	int evaluateExpressionTree(LinkedTree.TreeNode<E> node) {
		int lvalue = 0;
		int rvalue = 0;
		String cal = "";
		if(node.getLeftNode() != null) { // �ܸ���尡 �ƴ� ���=������!
			lvalue = evaluateExpressionTree(node.getLeftNode());			//���
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