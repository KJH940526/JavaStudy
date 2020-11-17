package dataS2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.lang.model.element.Element;

public class LinkedList<E> implements List<E> {

	private int size;
	private Node<E> head; // ���� ��尪�� ����

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

//	@Override					//������ ����
//	public void add(int index, E element) {
//		checkBoundExclustion(index);		//�ε����� ��带 �߰��ϰ� �ϸ���Ʈ�� �־���Ѵ�.
//						//������ ��带 �����Ѵ� -> ������ ��尡 ���� �ε����� ����Ű�� �Ѵ� 
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

	// ������ ����
	@Override // ������ �� ���� �Ǿ� �ǵ� ��� �̷������� ����ȭ �ؼ� ����
	public void add(int index, E element) {
		checkBoundExclustion(index);
		if (index == size) {
			add(element); // ���� �� �������� �ִ� add�޼ҵ带 �ҷ��ͼ� ����
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
		Node<E> x = head; // �ϴ� �ʱ��� ���� ��尪�� ����ְ�
		for (int i = 0; i < index; i++) {
			x = x.next; // ��� ���� ������ ��
		}
		return x.data; // ������ �����Ͱ��� ������
	}

//	@Override //����������
//	public E remove(int index) {//���� ����� ������ �����ϴ� �� �����ɷ� �ٲ��ְ� �ٲ� ��带 null�� �ٲ��ش�.
//		checkBoundExclustion(index);
//		
//		Node<E> last = head;
//		
//		for(int i = 0 ; i< index-1 ;i++) {
//			last = last.next; // for�� ������ last���� index�� �ּҰ���������
//			System.out.println(last.next+"   next:"+last.data);
//		}
//		System.out.println();
//		System.out.println(last.next.data+"������");
//		last.next = last.next.next;
////		last.next; // remove�� ��� ���� �ּ�
//		
//		
//		size--;
//		
//		return last.data;			
//	}
//	

	@Override // ������ ����
	public E remove(int index) {// ���� ����� ������ �����ϴ� �� �����ɷ� �ٲ��ְ� �ٲ� ��带 null�� �ٲ��ش�.
		checkBoundExclustion(index);
		E element;
		if (index == 0) { // ����°� ���� ù������
			element = head.data; // ����� ���� head.data�Դϴ�. => ������ ����
			head = head.next; // �׸��� head.next�� head�� �˴ϴ�.
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

		for (Node<E> x = head; x != null;) { // x���ٰ� head���� �ְ� �� ���¿���
			Node<E> next = x.next;
			x.data = null; // x.data�� x.next�� null���ؼ� ���´�.
			x.next = null; // ��ü�̱� ������ null�� ������� ������ �÷��Ͱ� �����.
			x = next; // �� ���� x�� next�� �ٲٰ� �ٽ� �������� �����.
		}
		head = null; // ������ ������ head = null size = 0���� �Ѵ�.
		size = 0;

	}

	@Override
	public int size() {
		return size;
	}

	// inner class ���� ����Ʈ�� ���� ���� ����� Ŭ����
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

	private void checkBoundExclustion(int index) // index�� size�� ���� ���� ����ó��
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
//				return (pos != null); // ��尪
//			}
			
			@Override
			public boolean hasNext() {   //size�� ������ ��� ����.
				if(pos != null) {
//					System.out.println("�������� �־�");
					return true;
				}else {
//					System.out.println("�������� ����");
					return false;
				}
			}
//				

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if (pos == null) {
					throw new NoSuchElementException();
				} // ���� ��Ҹ� �ѱ�Ű�

				E data = pos.data; // ����� ����Ÿ�� �ѱ��
				pos = pos.next; // ������ ���� �ؽ�Ʈ�� �Ǹ� ������ �ݺ��ҋ� �ٽ� �ٲ� ������ �ٽ� ���� �ؽ�Ʈ�� �θ�
				return data; // �׸��� ����Ÿ�� ���Ϲ޴´�
			};

		};
	}
}
