package dataS9_1;

import java.util.*;

public class LinkedTree<E> {

	private TreeNode<E> root; // ��Ʈ���
	
	// ���� Ŭ���� ����
	public static class TreeNode<E> {
		TreeNode<E> left;
		TreeNode<E> right; // ����� ��ũ�� ����Ʈ
		E data;

		public TreeNode(E data) {
			System.out.println("TreeNodeData : " + data);
			this.data = data;
			this.left = null;
			this.right = null;
		}

		//������� ���� ��带 ��� ���ؼ�
		public E getNode() {
			System.out.println("GetNode : "  + data);
			return data;
		}

		//�������
		public TreeNode<E> getLeftNode() {
			System.out.println("GetL : " + data);
			return left;
		}

		//�������
		public TreeNode<E> getRightNode() {
			System.out.println("GetR : " + data);
			return right;
		}

	}
	
	//Ʈ�� �⺻������
	public LinkedTree() {
		System.out.println("�⺻������");
		// TODO Auto-generated constructor stub
	}

//	//������ ��Ʈ��忡 ���� ����ִ� ������
//	public LinkedTree(E data) {
//		root = new TreeNode<E>(data); // �����ڷ� ����� ��Ʈ������ ù��� �����͸� ����
//	}

	//������� // Root ��带 ������ؼ�
	public void setRoot(TreeNode<E> root) { 
//		System.out.println("root: "+root);
//		System.out.println("this.root: "+ this.root);
		this.root = root;
//		System.out.println("this.root=root: "+this.root);
//		System.out.println();
	}

	public TreeNode<E> getRoot() {
//		System.out.println("get��Ʈ : " +root);
		return root;
	}

	public TreeNode<E> insertLeft(TreeNode<E> node, E data) {
//     System.out.println("����Ʈ: "+ node.data);
		TreeNode<E> leftNode = new TreeNode<E>(data);
		node.left = leftNode; // ���� ������ ���ѻ��� ��� ���ʿ� ���
		return leftNode; // �׸��� ����

	}

	public TreeNode<E> insertRight(TreeNode<E> node, E data) {
		System.out.println("����Ʈ: "+ node.data);
		TreeNode<E> rightNode = new TreeNode<E>(data);
		node.right = rightNode;
		return rightNode;

	}

	// ������ذ�!! Ÿ��Ÿ�� �������� ����� �� ����Ʈ���� ���� ���ؼ�
	public TreeNode<E> insertLeft(TreeNode<E> node, TreeNode<E> left) {
	    System.out.println("����Ʈ TreeNode: "+ left);
	    System.out.println("����Ʈ TreeNode node.left: "+ node.left);
		node.left = left;
		return left;
	}
	
	// ������ذ�!! Ÿ��Ÿ�� �������� ����� �� ����Ʈ���� ���� ���ؼ�
	public TreeNode<E> insertRight(TreeNode<E> node, TreeNode<E> right) {
	    System.out.println("����Ʈ TreeNode: "+ right);
	    System.out.println("����Ʈ TreeNode node.left: "+ node.right);
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
		
		result.add(node.data);   //result�� List<E> �Ű����� Ȯ��!!
		System.out.println("LinkedTree.java result : " +result);
		

	}

}
