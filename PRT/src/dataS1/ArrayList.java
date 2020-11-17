package dataS1;

import java.util.Iterator;
import java.util.NoSuchElementException;

//오른쪽 마우스 클릭 -> 소스 -> 오버라이드
public class ArrayList<E> implements List<E> {

	private int size;
	private E[] data;
	
	public ArrayList() {
		this.size = 0;
		resize();
	};
	
	private void resize() {
		if(size == 0) {									//사이즈가 0이면 생성자에서 불러오고
			data = (E[]) new Object[10];				//사이즈가 0 -> 배열x => 새로운 배열을 만든다.
//			System.out.println("배열 생성");				// 제네릭타입으로 배열을 만드는 방법 : object타입으로 배열을 만들고 형변환해줌
			
		} else {										 //사이즈와 add가 같으면 add 메소드에서 불러온다.
			E[] newData = (E[]) new Object[size + 10];   //기존 배열보다 사이즈가 큰 배열을 만듬
//			System.out.println("배열 크기 증가");
			System.arraycopy(data, 0, newData, 0, size); //새로운 배열에 기존 배열을 복사한다.
			data = newData;								 //기존 배열 대신에 새로운 배열을 넣는다.
		}									
	}
	
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if(data.length == size) { //데이터의 사이즈가 데이터 타입의 길이와 같으면 리사이즈를 불러온다.
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
//			System.out.println("끝");
//		}
//	}
	
	//선생님 버전
	@Override
	public E get(int index) {
			checkBoundExclustion(index);
			return data[index];
	}
	
	
	//*********************
	@Override							//삭제한 값을 뽑아냄
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
	    		  throw new NoSuchElementException(); //데이터가 없을 경우 예이처리
	    	   return data[pos++];
			}
			
	   };
	}

	
	
}
