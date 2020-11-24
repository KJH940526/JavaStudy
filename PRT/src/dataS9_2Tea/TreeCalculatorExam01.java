package dataS9_2Tea;


import java.util.*;


public class TreeCalculatorExam01 {
	public static void main(String[] args) {
		
		//������ ����
		
		
		List<String> list = new ArrayList<String>();				//�迭�� ��������
			
		TreeCalculator cal = new TreeCalculator("7+4*2-1");			
		System.out.println(cal.infixToPostfix());						//742*+1-
		System.out.println("================================");
		
		
		LinkedTree<String> tree = cal.makeExpressionTree();				
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));			// [7,4,2,*,+,1,-]
		
		
		int result = cal.evaluateExpressionTree(tree.getRoot());
		System.out.println("================================");
		System.out.println(result);										//14
		
	}

}