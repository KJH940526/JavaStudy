package dataS9;

import java.util.List;

public class LinkedTree<E> {
	
    //���� Ŭ���� ����
    public static class TreeNode<E>{
   	 private TreeNode<E> left;
   	 private TreeNode<E> right;		//����� ��ũ�� ����Ʈ
   	 private E data;
   	 
   	 public TreeNode(E data) {
   		 this.data = data;
   		 this.left = null;
   		 this.right = null;
   	 }
    }
    
	private TreeNode<E> root;			//��Ʈ���
	
	public LinkedTree(E data) {			
		root = new TreeNode<E>(data);	//�����ڷ� ����� ��Ʈ������ ù��� �����͸� ����
	}
	
	
    public TreeNode<E> getRoot() {
        return root;	
    }
	
     public TreeNode<E> insertLeft( TreeNode<E> node, E data ) {
       	 System.out.println("����Ʈ: "+ node.data);
    	 TreeNode<E> leftNode = new TreeNode<E>(data);
    	 node.left = leftNode;		//���� ������ ���ѻ��� ��� ���ʿ� ���
         return leftNode;			//�׸��� ����
         
     }

     public TreeNode<E> insertRight( TreeNode<E> node, E data ) {
    	 
    	 TreeNode<E> rightNode = new TreeNode<E>(data);
    	 node.right = rightNode;		
         return rightNode;
         
     }
     

     ////////////////////////////////////////////////////////////////////////
     //��͸� ����� ���� ��ȸ ����
     public void traversalPostorder( List<E> result ) {	//�������� �����Ұ� ������
//    	 System.out.println("ó��");
//    	 System.out.println(root.data);	//�������� ����Ÿ
//    	 System.out.println("Ʈ������ ������:  " +result);
    	 traversalPostorder( root, result );
    	 System.out.println("�ڽľ��� : " +result);

    	};
    	
    	public void traversalPostorder( TreeNode<E> node, List<E> result ) {
//    		 System.out.println("��嵥����   : " + node.data);
//    		System.out.println("�ڽ��ִ�  : " + result);
    	    if( node.left != null ) {	//���ʿ� ���� �ƴϸ� 
    	       traversalPostorder( node.left, result );
    	    }
    			
    	    if( node.right != null ) {
    	       traversalPostorder( node.right, result );
    	    }
    			
    	    result.add( node.data );
//    	    System.out.println("��� ����Ʈ  " +result);

    	}

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	////////////////////////////////////////////////////////////////////
    	//����  ��ȸ
        public void traversalPreorder( List<E> result ) {
        	traversalPreorder( root, result );

       	};
       	
       	public void traversalPreorder( TreeNode<E> node, List<E> result ) {

       		result.add( node.data );
       	    if( node.left != null ) {
       	    	traversalPreorder( node.left, result );
       	    }
       			
       	    if( node.right != null ) {
       	    	traversalPreorder( node.right, result );
       	    }
       			
       	    

       	}
       	
       	
       	/////////////////////////////////////////////////////////////////////
       	//���� ��ȸ
        public void traversalInorder( List<E> result ) {
//        	System.out.println(root.data); //A
        	traversalInorder( root, result );

       	};
       	
       	public void traversalInorder( TreeNode<E> node, List<E> result ) {
       	    if( node.left != null ) {
       	       traversalPostorder( node.left, result );
       	    }
       	    result.add( node.data );	
       	    if( node.right != null ) {
       	       traversalPostorder( node.right, result );
       	    }

       	}
    	

     
     

     
    
     
     
     
     
     
     
}
