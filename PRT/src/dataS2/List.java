package dataS2;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
	
	void add(E elemnet);			//리스트에 데이터를 추가한다. (맨 뒤에)

	void add(int index, E element); //지정된 위치에 데이터를 추가한다. 
	
	E get(int index );				//지정된 위치에 데이터 반환

	E remove(int index);			//지정된 위치의 항목을 삭제 한다. ( 삭제 데이터 반환 )
	
	void removeAll();				//전체 항목을 삭제한다.
	
	int size();						//리스트의 항목 수를 반환
		
	Iterator<E> iterator();			//
}

