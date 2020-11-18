package dataS5;

import dataS1.ArrayList;  //���� ���� ��̸���Ʈ

public class Stack<E> extends ArrayList<E> {
	
	public void push(E item) {
		add(item);
	}
	
	public E pop() {
		return remove(size()-1);
	}
	
	public E peek() {
		return get(size()-1);    //���ÿ� ���� �������� �߰��� �׸��� �������� �ʰ� ��ȯ�Ѵ�.
	}
	
	public boolean empty() {
		return size() ==0;
	}
	
	

}
