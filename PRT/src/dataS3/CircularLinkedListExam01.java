package dataS3;

import java.util.Iterator;


public class CircularLinkedListExam01 {

	public static void main(String[] args) {
		List<Integer> list = new CircularLinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println("원형");
		System.out.println("현재 데이터 수: " + list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 데이터: " + list.get(i));
		}
		System.out.println("Add-----------------------------");
		
		list.add(4,25);
		System.out.println("현재 데이터 수: " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 데이터: " + list.get(i));
		}
		System.out.println();
		System.out.println("Remove-----------------------------");
		list.remove(5);
		System.out.println("현재 데이터 수: " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 데이터: " + list.get(i));
		}
		System.out.println();
		
//		list.removeAll();
		System.out.println("현재 데이터 수: " + list.size());
		
		System.out.println("---------------------------------");
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(i);
		}
		
		System.out.println();
		
//		for(int i : list) {
//			System.out.println(i);
//		}
		
	}

}


