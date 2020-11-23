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

		tree.insertLeft( nodeD, "H" );										//여기가 다른 이유는 여기는 종결노드니깐 더이상 추가를 안하기 때문에 저 합수로 만들지 않음 추가 노드 생성 안함
		tree.insertRight( nodeD, "I" );
				
		tree.insertLeft( nodeE, "J" );

		tree.insertRight( nodeF, "K" );

		tree.insertLeft( nodeG, "L" );
		tree.insertRight( nodeG, "M" );
		
		//후위
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));	
//		list.removeAll(list); //를 하거나?
//		list.clear();
//		
//		//전위
//		tree.traversalPreorder(list);
//		System.out.println(Arrays.toString(list.toArray()));
//		list.clear();
//		
//		//중위
//		tree.traversalInorder(list);
//		System.out.println(Arrays.toString(list.toArray()));
				
		
//						A
//			B						C
//		D			E			F				G
//	H		I	 J					K		L		M
	}

}
