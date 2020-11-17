package dataS2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.lang.model.element.Element;

public class LinkedList<E> implements List<E> {

	private int size;
	private Node<E> head; // 시작 노드값을 저장

	@Override
	public void add(E element) {

		final Node<E> newNode = new Node<E>(element);

		if (head == null) {
			head = newNode;
		} else {
			Node<E> last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		size++;

	}

//	@Override					//오지영 버전
//	public void add(int index, E element) {
//		checkBoundExclustion(index);		//인덱스의 노드를 추가하고 일리멘트를 넣어야한다.
//						//삽입할 노드를 생성한다 -> 삽입한 노드가 다음 인덱스를 가르키게 한다 
//		
//		size++;
//		Node<E> newNode = new Node<E>(element);
//		Node<E> last = head;
//		for(int i = 0 ; i < index-1 ; i++) {
//			last = last.next;
//		}
//		Node<E> nextStart = last.next;
//		last.next = newNode;
//		newNode.next = nextStart;
//		
//	}

	// 선생님 버전
	@Override // 검증을 할 떄는 맨앞 맨뒤 가운데 이런식으로 세분화 해서 넣자
	public void add(int index, E element) {
		checkBoundExclustion(index);
		if (index == size) {
			add(element); // 위에 맨 마지막에 넣는 add메소드를 불러와서 넣음
			return;
		}
		Node<E> newNode = new Node<E>(element);
		Node<E> x = head;
		for (int i = 0; i < index - 1; i++) {
			x = x.next;
		}
		if (index == 0) {
			head = newNode;
			newNode.next = x;
		} else {
			newNode.next = x.next;
			x.next = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		checkBoundExclustion(index);
		Node<E> x = head; // 일단 초기노드 값인 헤드값을 집어넣고
		for (int i = 0; i < index; i++) {
			x = x.next; // 계속 다음 노드까지 감
		}
		return x.data; // 마지막 데이터값을 리턴함
	}

//	@Override //오지영버전
//	public E remove(int index) {//전에 노드의 연결을 삭제하는 것 다음걸로 바꿔주고 바뀐 노드를 null로 바꿔준다.
//		checkBoundExclustion(index);
//		
//		Node<E> last = head;
//		
//		for(int i = 0 ; i< index-1 ;i++) {
//			last = last.next; // for문 끝나면 last에는 index의 주소값갖고있음
//			System.out.println(last.next+"   next:"+last.data);
//		}
//		System.out.println();
//		System.out.println(last.next.data+"데이터");
//		last.next = last.next.next;
////		last.next; // remove할 노드 다음 주소
//		
//		
//		size--;
//		
//		return last.data;			
//	}
//	

	@Override // 선생님 버전
	public E remove(int index) {// 전에 노드의 연결을 삭제하는 것 다음걸로 바꿔주고 바뀐 노드를 null로 바꿔준다.
		checkBoundExclustion(index);
		E element;
		if (index == 0) { // 지우는게 제일 첫번쨰면
			element = head.data; // 지우는 값은 head.data입니다. => 리턴을 해줌
			head = head.next; // 그리고 head.next는 head가 됩니다.
		} else {
			Node<E> x = head;
			for (int i = 0; i < index - 1; i++) {
				x = x.next;
			}
			element = x.next.data;
			x.next = x.next.next;
		}
		size--;
		return element;
	}

	@Override
	public void removeAll() {

		for (Node<E> x = head; x != null;) { // x에다가 head값을 넣고 그 상태에서
			Node<E> next = x.next;
			x.data = null; // x.data와 x.next를 null로해서 끊는다.
			x.next = null; // 객체이기 때문에 null로 해줘야지 가비지 컬렉터가 지운다.
			x = next; // 그 다음 x를 next로 바꾸고 다시 다음것을 지운다.
		}
		head = null; // 루프가 끝나면 head = null size = 0으로 한다.
		size = 0;

	}

	@Override
	public int size() {
		return size;
	}

	// inner class 연결 리스트를 쓰기 위한 노드의 클래스
	private static class Node<E> {
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

	private void checkBoundExclustion(int index) // index랑 size가 같을 떄도 에러처리
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	private void checkBoundInclustion(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {
			private Node<E> pos = head;

//			@Override
//			public boolean hasNext() {
//				return (pos != null); // 헤드값
//			}
			
			@Override
			public boolean hasNext() {   //size만 있으면 계속 돈다.
				if(pos != null) {
//					System.out.println("다음것이 있어");
					return true;
				}else {
//					System.out.println("다음것이 없어");
					return false;
				}
			}
//				

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if (pos == null) {
					throw new NoSuchElementException();
				} // 범위 요소를 넘긴거고

				E data = pos.data; // 헤드의 데이타를 넘기고
				pos = pos.next; // 포스는 포스 넥스트가 되면 다음에 반복할떄 다시 바뀐 포스가 다시 포스 넥스트를 부름
				return data; // 그리고 데이타를 리턴받는다
			};

		};
	}
}
