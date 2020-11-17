package dataS3;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularLinkedList<E> implements List<E> {
	
	private class Node<E>{    //노드가 하나 있으면 노드 넥스트는 자기 자신을 가르키게 된다.
		private Node<E> next;
		private E data;
		
		private Node(E element) {
			this.data = element;
			this.next = null;
		}
		
		private Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}
		
	}
	
	private int size;
	private Node<E> tail;		//꼬리 노드

	@Override
	public void add(E element) {
		Node<E> newNode = new Node<>(element);
		
		if(tail == null) {
			tail = newNode.next = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
		
	}

	
	@Override
	public void add(int index, E element) {	//인덱스의 꼬리가 널인지 아닌지 판단 널이면 위와 같이 해주고
												//널이 아니면  포문으로 x 넥스트하고
		checkBoundExclustion(index);
		if(index == size) {
			add(element);
			return;
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> x;
		
		if(index == 0) {						//index가 0이면 x가 꼬리에 붙고 x.next가 newNode의 next에 임시로 들어간다.
			x=tail;								//그리고 newNode는 x.next에 붙어서 연결해준다.
		}else {
			x = tail.next;						//index가 1이 아니면 위와 과정은 똑같지만 for을 통해서 한칸씩 쇽쇽쇽 옮겨준다.
			for(int i=0; i<index -1; i++) {
				x= x.next;
			}
		}
		
		newNode.next = x.next;
		x.next = newNode;
		size++;
	}
	

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclustion(index);
		Node<E> x = tail.next;
		for(int i=0; i< index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		checkBoundExclustion(index);
		Node<E> x;
		if(index == 0) {
			x = tail;
		} else {
			x = tail.next;
		}
		
		for(int i=0; i < index -1 ; i++) {
			x = x.next;
		}
		if(x.next == tail) {
			tail = x;
		}
		Node<E> deleted;
		deleted = x.next;
		x.next = deleted.next;
		size--;
		return deleted.data;
	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next;
		
		while(x != tail) {
			Node<E> next = x.next;
			x.next = null;
			x = next;
		}
		tail.next = null;
		tail = null;
		size = 0;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {
			private Node<E> x = tail.next; 

			private int count = 0;
			

			@Override
			public boolean hasNext() {   //size만 있으면 계속 돈다.
				if(count < size ) {
					count ++;
					return true;
				} else {
					return false;
				}
			}

			@Override
			public E next() {
				if(x == null)
					throw new NoSuchElementException(); { //범위 요소를 넘긴거고
				}		
					if(x == tail) {			
						E data = x.data;
//						System.out.println("data"+ data);
						return data;
					}
					E data = x.data;
					x = x.next;
					return data;
			}
		};
		
	}


	private void checkBoundExclustion(int index)	//index랑 size가 같을 떄도 에러처리
	{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	
	private void checkBoundInclustion(int index)
	{
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	
}
