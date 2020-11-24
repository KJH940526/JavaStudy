package dataS9_1;


import java.util.*;


public class TreeCalculatorExam01 {
	public static void main(String[] args) {
		
		
		
		List<String> list = new ArrayList<String>();				//배열을 담을것임
			
		TreeCalculator<String> cal = new TreeCalculator<String>("7+4*2-1");			
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

/*
기본생성자
742*+1-
================================
TreeNodeData : 7
스태의 피크 데이터7
TreeNodeData : 4
스태의 피크 데이터4
TreeNodeData : 2
스태의 피크 데이터2
연산자
TreeNodeData : *
연산자: *
라이트 TreeNode: dataS9_1.LinkedTree$TreeNode@15db9742
라이트 TreeNode node.left: null
라이트 : 2
레프트 TreeNode: dataS9_1.LinkedTree$TreeNode@6d06d69c
레프트 TreeNode node.left: null
레프트 : 4
연산자
TreeNodeData : +
연산자: +
라이트 TreeNode: dataS9_1.LinkedTree$TreeNode@7852e922
라이트 TreeNode node.left: null
라이트 : *
레프트 TreeNode: dataS9_1.LinkedTree$TreeNode@4e25154f
레프트 TreeNode node.left: null
레프트 : 7
TreeNodeData : 1
스태의 피크 데이터1
연산자
TreeNodeData : -
연산자: -
라이트 TreeNode: dataS9_1.LinkedTree$TreeNode@70dea4e
라이트 TreeNode node.left: null
라이트 : 1
레프트 TreeNode: dataS9_1.LinkedTree$TreeNode@5c647e05
레프트 TreeNode node.left: null
레프트 : +
LinkedTree.java result : [7]
LinkedTree.java result : [7, 4]
LinkedTree.java result : [7, 4, 2]
LinkedTree.java result : [7, 4, 2, *]
LinkedTree.java result : [7, 4, 2, *, +]
LinkedTree.java result : [7, 4, 2, *, +, 1]
LinkedTree.java result : [7, 4, 2, *, +, 1, -]
[7, 4, 2, *, +, 1, -]
매개변수 node: -
GetL : -
GetR : -
GetL : -
매개변수 node: +
GetL : +
GetR : +
GetL : +
매개변수 node: 7
GetL : 7
GetNode : 7
겟노드 : 7

노드 데이타: 7
GetNode : 7
왼쪽 벨류 : 7

GetR : +
매개변수 node: *
GetL : *
GetR : *
GetL : *
매개변수 node: 4
GetL : 4
GetNode : 4
겟노드 : 4

노드 데이타: 4
GetNode : 4
왼쪽 벨류 : 4

GetR : *
매개변수 node: 2
GetL : 2
GetNode : 2
겟노드 : 2

노드 데이타: 2
GetNode : 2
오른 벨류 : 2

GetNode : *
int a: 4 int b: 2 String c: *
결과값: 8
오른 벨류 : 8

GetNode : +
int a: 7 int b: 8 String c: +
결과값: 15
왼쪽 벨류 : 15

GetR : -
매개변수 node: 1
GetL : 1
GetNode : 1
겟노드 : 1

노드 데이타: 1
GetNode : 1
오른 벨류 : 1

GetNode : -
int a: 15 int b: 1 String c: -
결과값: 14
================================
14
 */
