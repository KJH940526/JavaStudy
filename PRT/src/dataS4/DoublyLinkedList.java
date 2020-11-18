package dataS4;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class DoublyLinkedList <E> implements List<E> {
	
	private int size;
	private Node<E> head;
	private Node<E> tail;

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {

			private Node<E> pos = head;


			@Override
			public boolean hasNext() {   //size만 있으면 계속 돈다.
				return pos != null;
			}

			@Override
			public E next() {
				
				if(pos == null)
					throw new NoSuchElementException();
				E data = pos.data;
				pos = pos.next;
				return data;
			}
		};
	}
	
	
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);	
		if(head == null) {
			head = tail = newNode;
		} else {
			tail.next =newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
		
	}
// 김준호
//	@Override
//	public void add(int index, E element) {
//		// TODO Auto-generated method stub
//		checkBoundExclustion(index);
//		if(index == size) {
//			add(element);
//			return;
//		}
//		Node<E> newNode = new Node<E>(element);
//		Node<E> h = head;
//		Node<E> t = tail;
//		for (int i = 0; i < index; i++) {
//			h = h.next;
//		}
//		for (int i = 0; i < index; i++) {
//			t = t.prev;
//
//		}
//		if(index == 0) {
//			head = newNode;
//			newNode.next = h;
//			newNode.prev = t;
//		} else {
//			newNode.next = h.next;
//			h.next = newNode;
//			newNode.prev = t.prev;
//		}
//		size++;
//	}
	
//	//선생님 버전
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclustion(index);
		if(index == size) {
			add(element);
			return;
		}
		Node<E> newNode = new Node<E>(element);
		Node<E> x = head;	
		
		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		if(index == 0) {
			newNode.prev = x.prev;
			newNode.next = x;
			head = newNode;
		} else {
			x.prev.next = newNode;
			newNode.prev = x.prev;
			newNode.next = x;
			x.prev = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		checkBoundExclustion(index);
		Node<E> x = head;  //헤드값을 저장하고
		for(int i=0; i <index; i++) { //인덱수만큼 for문을로 빙글빙글 뽑고
			x= x.next;				//x.next를 x에 넣고 돌려준다.
		}
		return x.data;				//그리고 x.data를 리턴해서 보여준다.
	}

//  김준호 버전  조금 다르지만 맞는거 같음
//	@Override
//	public E remove(int index) {
//		checkBoundExclustion(index);
//		E element;
//		if(index == 0) {
//			element = head.data;
//			head = head.next;
//			tail = tail.prev;
//		} else {
//			Node<E> h = head;
//			for(int i = 0; i<index -1; i++) {			//아래랑 합치자 지금은 귀찮음
//				h = h.next;								
//			}
//			Node<E> t = tail;
//			for(int i = 0; i<index -1; i++) {
//				t = t.prev;
//			}
//			element = h.next.data;
//			h.next = h.next.next;
//			t.prev = t.prev.prev;
//		}
//		size--;
//		return element;
//	}
	
	@Override
	public E remove(int index) {
		checkBoundExclustion(index);
		Node<E> x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		if(index == 0 ) {
			if(size ==1) {		//사이즈를 기준으로 반반 나눠서 하면 효율성이 올라갈수도 있다?
				head = null;
				tail = null;
			} else {
				x.next.prev = x.prev;
				head = x.next;
			}
		} else if(x == tail) {
			x.prev.next = x.next;
			tail = x.prev;
		} else {
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}
		size--;
		return x.data;
	}

	@Override
	public void removeAll() {
		Node<E> x= head;
		
		while( x != null) {
			Node<E> next = x.next;
			
			x.next = null;
			x.prev = null;
			x = next;
		}
		head = null;
		tail = null;
		size = 0;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private static class Node<E> {
		private Node<E> next;
		private Node<E> prev; // 양방향이기 떄문에 노드가 2개 필요함
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
			this.prev = null;
		}
	}

	
	private void checkBoundExclustion(int index) // index랑 size가 같을 떄도 에러처리
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	private void checkBoundInclustion(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

}
