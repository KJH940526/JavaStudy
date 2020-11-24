package dataS9_1;

import java.util.*;

public class LinkedTree<E> {

	private TreeNode<E> root; // 루트노드
	
	// 내부 클래스 정의
	public static class TreeNode<E> {
		TreeNode<E> left;
		TreeNode<E> right; // 양방향 링크드 리스트
		E data;

		public TreeNode(E data) {
			System.out.println("TreeNodeData : " + data);
			this.data = data;
			this.left = null;
			this.right = null;
		}

		//만들어줌 현재 노드를 얻기 위해서
		public E getNode() {
			System.out.println("GetNode : "  + data);
			return data;
		}

		//만들어줌
		public TreeNode<E> getLeftNode() {
			System.out.println("GetL : " + data);
			return left;
		}

		//만들어줌
		public TreeNode<E> getRightNode() {
			System.out.println("GetR : " + data);
			return right;
		}

	}
	
	//트리 기본생성자
	public LinkedTree() {
		System.out.println("기본생성자");
		// TODO Auto-generated constructor stub
	}

//	//생성시 루트노드에 값을 집어넣는 생성자
//	public LinkedTree(E data) {
//		root = new TreeNode<E>(data); // 생성자로 생기면 루트변수에 첫노드 데이터를 저장
//	}

	//만들었음 // Root 노드를 얻기위해서
	public void setRoot(TreeNode<E> root) { 
//		System.out.println("root: "+root);
//		System.out.println("this.root: "+ this.root);
		this.root = root;
//		System.out.println("this.root=root: "+this.root);
//		System.out.println();
	}

	public TreeNode<E> getRoot() {
//		System.out.println("get루트 : " +root);
		return root;
	}

	public TreeNode<E> insertLeft(TreeNode<E> node, E data) {
//     System.out.println("레프트: "+ node.data);
		TreeNode<E> leftNode = new TreeNode<E>(data);
		node.left = leftNode; // 다음 연결을 위한생긴 노드 왼쪽에 쇽쇽
		return leftNode; // 그리고 리턴

	}

	public TreeNode<E> insertRight(TreeNode<E> node, E data) {
		System.out.println("라이트: "+ node.data);
		TreeNode<E> rightNode = new TreeNode<E>(data);
		node.right = rightNode;
		return rightNode;

	}

	// 만들어준거!! 타고타고 내려가서 노드의 끝 레프트까지 가기 위해서
	public TreeNode<E> insertLeft(TreeNode<E> node, TreeNode<E> left) {
	    System.out.println("레프트 TreeNode: "+ left);
	    System.out.println("레프트 TreeNode node.left: "+ node.left);
		node.left = left;
		return left;
	}
	
	// 만들어준거!! 타고타고 내려가서 노드의 끝 라이트까지 가기 위해서
	public TreeNode<E> insertRight(TreeNode<E> node, TreeNode<E> right) {
	    System.out.println("라이트 TreeNode: "+ right);
	    System.out.println("라이트 TreeNode node.left: "+ node.right);
		node.right = right;
		return right;
	}

	public void traversalPostorder(List<E> result) {
		traversalPostorder(root, result);
	}

	public void traversalPostorder(TreeNode<E> node, List<E> result) {

		if (node.left != null) {
			traversalPostorder(node.left, result);
		}

		if (node.right != null) {
			traversalPostorder(node.right, result);
		}
		
		result.add(node.data);   //result는 List<E> 매개변수 확인!!
		System.out.println("LinkedTree.java result : " +result);
		

	}

}
