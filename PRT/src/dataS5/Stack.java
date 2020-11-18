package dataS5;

import dataS1.ArrayList;  //내가 만든 어레이리스트

public class Stack<E> extends ArrayList<E> {
	
	public void push(E item) {
		add(item);
	}
	
	public E pop() {
		return remove(size()-1);
	}
	
	public E peek() {
		return get(size()-1);    //스택에 제일 마지막에 추가된 항목을 삭제하지 않고 반환한다.
	}
	
	public boolean empty() {
		return size() ==0;
	}
	
	

}
