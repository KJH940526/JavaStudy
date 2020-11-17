package dataS3;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularLinkedList<E> implements List<E> {
	
	private class Node<E>{    //��尡 �ϳ� ������ ��� �ؽ�Ʈ�� �ڱ� �ڽ��� ����Ű�� �ȴ�.
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
	private Node<E> tail;		//���� ���

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
	public void add(int index, E element) {	//�ε����� ������ ������ �ƴ��� �Ǵ� ���̸� ���� ���� ���ְ�
												//���� �ƴϸ�  �������� x �ؽ�Ʈ�ϰ�
		checkBoundExclustion(index);
		if(index == size) {
			add(element);
			return;
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> x;
		
		if(index == 0) {						//index�� 0�̸� x�� ������ �ٰ� x.next�� newNode�� next�� �ӽ÷� ����.
			x=tail;								//�׸��� newNode�� x.next�� �پ �������ش�.
		}else {
			x = tail.next;						//index�� 1�� �ƴϸ� ���� ������ �Ȱ����� for�� ���ؼ� ��ĭ�� ���� �Ű��ش�.
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
			public boolean hasNext() {   //size�� ������ ��� ����.
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
					throw new NoSuchElementException(); { //���� ��Ҹ� �ѱ�Ű�
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


	private void checkBoundExclustion(int index)	//index�� size�� ���� ���� ����ó��
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
