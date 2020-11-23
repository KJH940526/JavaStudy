package dataS9_1;

import java.util.List;

public class LinkedTree<E> {

	private TreeNode<E> root; // 루트노드

	public LinkedTree() {
	}

	public LinkedTree(E data) {
		root = new TreeNode<E>(data); // 생성자로 생기면 루트변수에 첫노드 데이터를 저장
	}

	//만들었음 // Root 노드를 얻기위해서
	public void setRoot(TreeNode root) { 
		this.root = root;
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public TreeNode<E> insertLeft(TreeNode<E> node, E data) {
//     System.out.println("레프트: "+ node.data);
		TreeNode<E> leftNode = new TreeNode<E>(data);
		node.left = leftNode; // 다음 연결을 위한생긴 노드 왼쪽에 쇽쇽
		return leftNode; // 그리고 리턴

	}

	public TreeNode<E> insertRight(TreeNode<E> node, E data) {
		TreeNode<E> rightNode = new TreeNode<E>(data);
		node.right = rightNode;
		return rightNode;

	}

	// 만들어준거!! 타고타고 내려가서 노드의 끝 레프트까지 가기 위해서
	public TreeNode<E> insertLeft(TreeNode<E> node, TreeNode<E> left) {
		node.left = left;
		return left;
	}
	
	// 만들어준거!! 타고타고 내려가서 노드의 끝 레프트까지 가기 위해서
	public TreeNode<E> insertRight(TreeNode<E> node, TreeNode<E> right) {
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

		result.add(node.data);

	}

	public void traversalInorder(List<E> result) {
		traversalInorder(root, result);
	}

	public void traversalInorder(TreeNode<E> node, List<E> result) {
		if (node.left != null) {
			traversalInorder(node.left, result);
		}
		result.add(node.data);
		if (node.right != null) {
			traversalInorder(node.right, result);
		}
	}

	public void traversalPreorder(List<E> result) {
		traversalPreorder(root, result);
	}

	public void traversalPreorder(TreeNode<E> node, List<E> result) {
		result.add(node.data);
		if (node.left != null) {
			traversalPreorder(node.left, result);
		}
		if (node.right != null) {
			traversalPreorder(node.right, result);
		}
	}

	// 내부 클래스 정의
	public static class TreeNode<E> {
		TreeNode<E> left;
		TreeNode<E> right; // 양방향 링크드 리스트
		E data;

		public TreeNode(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		//만들어줌 현재 노드를 얻기 위해서
		public E getNode() {
			return data;
		}

		//만들어줌
		public TreeNode<E> getLeftNode() {
			return left;
		}

		//만들어줌
		public TreeNode<E> getRightNode() {
			return right;
		}

	}

}
