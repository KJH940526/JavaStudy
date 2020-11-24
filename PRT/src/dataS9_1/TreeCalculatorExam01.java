package dataS9_1;


import java.util.*;


public class TreeCalculatorExam01 {
	public static void main(String[] args) {
		
		
		
		List<String> list = new ArrayList<String>();				//�迭�� ��������
			
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
�⺻������
742*+1-
================================
TreeNodeData : 7
������ ��ũ ������7
TreeNodeData : 4
������ ��ũ ������4
TreeNodeData : 2
������ ��ũ ������2
������
TreeNodeData : *
������: *
����Ʈ TreeNode: dataS9_1.LinkedTree$TreeNode@15db9742
����Ʈ TreeNode node.left: null
����Ʈ : 2
����Ʈ TreeNode: dataS9_1.LinkedTree$TreeNode@6d06d69c
����Ʈ TreeNode node.left: null
����Ʈ : 4
������
TreeNodeData : +
������: +
����Ʈ TreeNode: dataS9_1.LinkedTree$TreeNode@7852e922
����Ʈ TreeNode node.left: null
����Ʈ : *
����Ʈ TreeNode: dataS9_1.LinkedTree$TreeNode@4e25154f
����Ʈ TreeNode node.left: null
����Ʈ : 7
TreeNodeData : 1
������ ��ũ ������1
������
TreeNodeData : -
������: -
����Ʈ TreeNode: dataS9_1.LinkedTree$TreeNode@70dea4e
����Ʈ TreeNode node.left: null
����Ʈ : 1
����Ʈ TreeNode: dataS9_1.LinkedTree$TreeNode@5c647e05
����Ʈ TreeNode node.left: null
����Ʈ : +
LinkedTree.java result : [7]
LinkedTree.java result : [7, 4]
LinkedTree.java result : [7, 4, 2]
LinkedTree.java result : [7, 4, 2, *]
LinkedTree.java result : [7, 4, 2, *, +]
LinkedTree.java result : [7, 4, 2, *, +, 1]
LinkedTree.java result : [7, 4, 2, *, +, 1, -]
[7, 4, 2, *, +, 1, -]
�Ű����� node: -
GetL : -
GetR : -
GetL : -
�Ű����� node: +
GetL : +
GetR : +
GetL : +
�Ű����� node: 7
GetL : 7
GetNode : 7
�ٳ�� : 7

��� ����Ÿ: 7
GetNode : 7
���� ���� : 7

GetR : +
�Ű����� node: *
GetL : *
GetR : *
GetL : *
�Ű����� node: 4
GetL : 4
GetNode : 4
�ٳ�� : 4

��� ����Ÿ: 4
GetNode : 4
���� ���� : 4

GetR : *
�Ű����� node: 2
GetL : 2
GetNode : 2
�ٳ�� : 2

��� ����Ÿ: 2
GetNode : 2
���� ���� : 2

GetNode : *
int a: 4 int b: 2 String c: *
�����: 8
���� ���� : 8

GetNode : +
int a: 7 int b: 8 String c: +
�����: 15
���� ���� : 15

GetR : -
�Ű����� node: 1
GetL : 1
GetNode : 1
�ٳ�� : 1

��� ����Ÿ: 1
GetNode : 1
���� ���� : 1

GetNode : -
int a: 15 int b: 1 String c: -
�����: 14
================================
14
 */
