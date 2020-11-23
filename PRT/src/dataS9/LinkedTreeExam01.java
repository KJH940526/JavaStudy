package dataS9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


					
public class LinkedTreeExam01 {
	public static void main(String[] args) {
		
		LinkedTree<String> tree = new LinkedTree<String>("A");
		List<String> list = new ArrayList<String>();

		
		LinkedTree.TreeNode<String> nodeA = tree.getRoot();					
		
		LinkedTree.TreeNode<String> nodeB = tree.insertLeft( nodeA, "B" );		//public TreeNode<E> insertLeft( TreeNode<E> node, E data ) {
		LinkedTree.TreeNode<String> nodeC = tree.insertRight( nodeA, "C" );
				
		LinkedTree.TreeNode<String> nodeD = tree.insertLeft( nodeB, "D" );
		LinkedTree.TreeNode<String> nodeE = tree.insertRight( nodeB, "E" );
				
		LinkedTree.TreeNode<String> nodeF = tree.insertLeft( nodeC, "F" );
		LinkedTree.TreeNode<String> nodeG = tree.insertRight( nodeC, "G" );

		tree.insertLeft( nodeD, "H" );										//���Ⱑ �ٸ� ������ ����� ������ϱ� ���̻� �߰��� ���ϱ� ������ �� �ռ��� ������ ���� �߰� ��� ���� ����
		tree.insertRight( nodeD, "I" );
				
		tree.insertLeft( nodeE, "J" );

		tree.insertRight( nodeF, "K" );

		tree.insertLeft( nodeG, "L" );
		tree.insertRight( nodeG, "M" );
		
		//����
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));	
//		list.removeAll(list); //�� �ϰų�?
//		list.clear();
//		
//		//����
//		tree.traversalPreorder(list);
//		System.out.println(Arrays.toString(list.toArray()));
//		list.clear();
//		
//		//����
//		tree.traversalInorder(list);
//		System.out.println(Arrays.toString(list.toArray()));
				
		
//						A
//			B						C
//		D			E			F				G
//	H		I	 J					K		L		M
	}

}
