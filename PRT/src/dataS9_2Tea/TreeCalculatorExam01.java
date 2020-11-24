package dataS9_2Tea;


import java.util.*;


public class TreeCalculatorExam01 {
	public static void main(String[] args) {
		
		//선생님 버전
		
		
		List<String> list = new ArrayList<String>();				//배열을 담을것임
			
//		TreeCalculator cal = new TreeCalculator("7+4*2-1");
		TreeCalculator cal = new TreeCalculator("1+1+1*9*1*4");		//이거 하니깐 답이 달랐음
		System.out.println(cal.infixToPostfix());					//변환이 잘못된듯
		System.out.println("================================");
		
		
		LinkedTree<String> tree = cal.makeExpressionTree();				
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));			
		
		
		int result = cal.evaluateExpressionTree(tree.getRoot());
		System.out.println("================================");
		System.out.println(result);										
		
	}

}
