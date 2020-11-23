package dataS9;

import java.util.List;

public class LinkedTree<E> {
	
    //내부 클래스 정의
    public static class TreeNode<E>{
   	 private TreeNode<E> left;
   	 private TreeNode<E> right;		//양방향 링크드 리스트
   	 private E data;
   	 
   	 public TreeNode(E data) {
   		 this.data = data;
   		 this.left = null;
   		 this.right = null;
   	 }
    }
    
	private TreeNode<E> root;			//루트노드
	
	public LinkedTree(E data) {			
		root = new TreeNode<E>(data);	//생성자로 생기면 루트변수에 첫노드 데이터를 저장
	}
	
	
    public TreeNode<E> getRoot() {
        return root;	
    }
	
     public TreeNode<E> insertLeft( TreeNode<E> node, E data ) {
       	 System.out.println("레프트: "+ node.data);
    	 TreeNode<E> leftNode = new TreeNode<E>(data);
    	 node.left = leftNode;		//다음 연결을 위한생긴 노드 왼쪽에 쇽쇽
         return leftNode;			//그리고 리턴
         
     }

     public TreeNode<E> insertRight( TreeNode<E> node, E data ) {
    	 
    	 TreeNode<E> rightNode = new TreeNode<E>(data);
    	 node.right = rightNode;		
         return rightNode;
         
     }
     

     ////////////////////////////////////////////////////////////////////////
     //재귀를 사용한 후위 순회 구현
     public void traversalPostorder( List<E> result ) {	//다음것이 연결할게 업을떄
//    	 System.out.println("처음");
//    	 System.out.println(root.data);	//조상노드의 데이타
//    	 System.out.println("트래버스 포스터:  " +result);
    	 traversalPostorder( root, result );
    	 System.out.println("자식없는 : " +result);

    	};
    	
    	public void traversalPostorder( TreeNode<E> node, List<E> result ) {
//    		 System.out.println("노드데이터   : " + node.data);
//    		System.out.println("자식있는  : " + result);
    	    if( node.left != null ) {	//왼쪽에 널이 아니면 
    	       traversalPostorder( node.left, result );
    	    }
    			
    	    if( node.right != null ) {
    	       traversalPostorder( node.right, result );
    	    }
    			
    	    result.add( node.data );
//    	    System.out.println("결과 리저트  " +result);

    	}

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	////////////////////////////////////////////////////////////////////
    	//전위  순회
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
       	//중위 순회
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
