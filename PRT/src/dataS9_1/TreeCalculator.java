package dataS9_1;

import java.util.*;
import dataS9_1.LinkedTree.TreeNode;


public class TreeCalculator<E> {
	private String infixExpression;
	private String postfixExpression = ""; // �ʵ� ����ϱ�

	LinkedTree<String> tree = new LinkedTree<String>(); // dataS9_1.LinkedTree

	public TreeCalculator(String infixExpression) {
		this.infixExpression = infixExpression;

	}
	
	public String infixToPostfix() {
		String St = this.infixExpression; // StackCalculator �����ڿ��� ������ ��Ʈ�� ���� �ʵ��� infixExprssion
											// �� �������ְ� �� ���� �޼ҵ忡�� St�� ������
		Stack<Character> stack = new Stack<Character>(); // ���� ����
		char[] arr = St.toCharArray(); // St�� char Ÿ���� �迭�� �ٲ�
		// String rest = ""; // ����ǥ������� ǥ���� �� ���� ���ٲ�

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
					stack.push(arr[i]); // ������ peek�� ���� �۾�
				}

				break;
			// ���ÿ� �켱������ peek���� �о��ָ� �ɵ�?
			case '*':
			case '/': // top �����ں��� �켱������ ������� (push)
				if (stack.empty() || stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') {
					stack.push(arr[i]);
				} else {
					while (!stack.empty() && stack.peek() != '(') { // �� stack.peek() != '*' �� �ƴѲ���??
						this.postfixExpression += stack.pop(); // rest�� pop()�ϰ�
					}
					stack.push(arr[i]); // ������ peek�� ���� �۾�
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

	
	
	
	public LinkedTree<String> makeExpressionTree() {
		// ���� ���������ڸ� ������ ���ؼ� ����Ʈ�� ������ֱ�
		
		// ���ÿ� ��ũ��Ʈ���� ��� -> 1)�츮������ Ʈ����带 ���ؼ� �����ڸ޼ҵ带 ���� ���ؼ� 2)Node�� ���� ���۷����� �����ϱ� ���ؼ�
		Stack<LinkedTree.TreeNode<String>> stack = new Stack<LinkedTree.TreeNode<String>>(); // �̰ɷ� �ؾ��� stack�� ��带 ������ ����
																								
		
		char[] arr = postfixExpression.toCharArray();

		// ������ ������ �����ϰ�
		// ���ο� ���ÿ� Ǫ��
		// �극��ũ
		// ����Ʈ(�񿬻���)
		// ���ο� ��� ����� �״�� Ǫ��
	
		for (int i = 0; i < arr.length; i++) {
			char s = arr[i];
			switch (s) {
			case '+':
			case '-':
			case '*':
			case '/':
				System.out.println("������");
				TreeNode<String> node = new TreeNode<String>(String.valueOf(arr[i]));
				tree.setRoot(node); // �߽ɳ��
				System.out.println("������: " +tree.getRoot().data);  //
				tree.insertRight(node, stack.pop());
				System.out.println("����Ʈ : " + node.right.data);
				tree.insertLeft(node, stack.pop());
				System.out.println("����Ʈ : " + node.left.data);
				stack.push(node);
				break;

			default:
				stack.push(new TreeNode<String>(String.valueOf(s)));
				System.out.println("������ ��ũ ������" +stack.peek().data);
				break;
			}
		}


		// �ٸ� ���1 root�� 1�̳� 0 ���� Ư������ �ְ� �װ� �ƴϸ� ��Ʈ��尡 �ƴϱ⋚���� ����� ������ �ִ�?
		// �ٸ� ���2 �����ϸ鼭 �ڼճ�带 ����� ���� �ڼ� ��尡 ������ ����� ���߰� �� ���� root�� �Ѱ��ش� *******
		return tree;
	}

	
	
	// ���ϱ�
	// 1. Ʈ���� �ְ�
	// 2. ����ϴµ� ����� 1.�ڽ��� ���� ����������
	// 2. �� ������ ��尡 �ڽ��� ���������� if���̶� for���� ���� node.left.data�� node.left.right.data +
	// node.left.left.data�� �Ѵ�.
	// 3. �������� ���� ��尡 ������ ��ȯ�޴´�. �̷��� �����߾���
	
	// 2. ���� LinkedTree���� getLeftNode��� ������ �޼ҵ带 ���� ����� left���� �޾ƿͼ� Ȯ��
	// 3. 
	
	//���� Ʈ�� ���� ����Ʈ���� �̷��� �ְ� �� ����Ʈ���� �� �̷�����ִ� -> ��͸� ���� ����� ���������� �ܸ���� �ϋ�
	int evaluateExpressionTree(LinkedTree.TreeNode<E> node) {
		System.out.println("�Ű����� node: " +node.data);
		int lvalue = 0;
		int rvalue = 0;
		String cal = "";
		if (node.getLeftNode() != null && node.getRightNode() != null) { // ��尡 �߰��� ���� -> ��������
			lvalue = evaluateExpressionTree(node.getLeftNode()); // ���
			System.out.println("���� ���� : "+lvalue);
			System.out.println();
			rvalue = evaluateExpressionTree(node.getRightNode());
			System.out.println("���� ���� : "+rvalue);
			System.out.println();
			cal = (String) node.getNode();
			return getResult(lvalue, rvalue, cal);
		} else { 											//�ǿ�����
			System.out.println("�ٳ�� : " +node.getNode());
			System.out.println();
			System.out.println("��� ����Ÿ: "+node.data);
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
		System.out.println("�����: "+result);
		return result;
	}
}