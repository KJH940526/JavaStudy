package dataS6;

import dataS2.LinkedList;

public class LStack<E> extends LinkedList<E> {
	
	public void push(E item) {
		add(item);
	}
	
	public E pop() {
		if(size()==0) {
			throw new StackException("stack is empty");
		}
		return remove(size()-1);
	}
	
	public E peek() {
		return get(size()-1);    //스택에 제일 마지막에 추가된 항목을 삭제하지 않고 반환한다.
	}
	
	public boolean empty() {
		return size() ==0;
	}
	
	

}
