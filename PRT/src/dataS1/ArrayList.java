package dataS1;

import java.util.Iterator;
import java.util.NoSuchElementException;

//������ ���콺 Ŭ�� -> �ҽ� -> �������̵�
public class ArrayList<E> implements List<E> {

	private int size;
	private E[] data;
	
	public ArrayList() {
		this.size = 0;
		resize();
	};
	
	private void resize() {
		if(size == 0) {									//����� 0�̸� �����ڿ��� �ҷ�����
			data = (E[]) new Object[10];				//����� 0 -> �迭x => ���ο� �迭�� �����.
//			System.out.println("�迭 ����");				// ���׸�Ÿ������ �迭�� ����� ��� : objectŸ������ �迭�� ����� ����ȯ����
			
		} else {										 //������� add�� ������ add �޼ҵ忡�� �ҷ��´�.
			E[] newData = (E[]) new Object[size + 10];   //���� �迭���� ����� ū �迭�� ����
//			System.out.println("�迭 ũ�� ����");
			System.arraycopy(data, 0, newData, 0, size); //���ο� �迭�� ���� �迭�� �����Ѵ�.
			data = newData;								 //���� �迭 ��ſ� ���ο� �迭�� �ִ´�.
		}									
	}
	
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if(data.length == size) { //�������� ����� ������ Ÿ���� ���̿� ������ ������� �ҷ��´�.
			resize();
		}
		
		data[size++] = element;
		
	}

	//***********************
	@Override
	public void add(int index, E element) {
		checkBoundExclustion(index);
		if(size == data.length)
			resize();
		if(index != size)
			System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = element;
		size++;
		
	}

//	@Override
//	public E get(int index) {
//		try {
//			return data[index];
//		} catch (Exception e) {
//			e.printStackTrace();
//			resize();
//			return null;
//		}
//		finally {
//			System.out.println("��");
//		}
//	}
	
	//������ ����
	@Override
	public E get(int index) {
			checkBoundExclustion(index);
			return data[index];
	}
	
	
	//*********************
	@Override							//������ ���� �̾Ƴ�
	public E remove(int index) {
		checkBoundExclustion(index);
		E r = data[index];
		if(index != --size)
			System.arraycopy(data, index + 1, data, index, size - index);
//		data[size] = null;
		return r;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		size = 0;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
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

	public Iterator<E> iterator() {

	    return new Iterator<E>() {
	    	private int pos = 0;
	    	private int size = size();
	    	
	       @Override
	        public boolean hasNext() {
	    	   return pos<size;
	        }
	       
	       @Override
			public E next() {
	    	   if(pos == size) 
	    		  throw new NoSuchElementException(); //�����Ͱ� ���� ��� ����ó��
	    	   return data[pos++];
			}
			
	   };
	}

	
	
}
