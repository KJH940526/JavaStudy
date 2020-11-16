package dataS1;

import java.util.Iterator;

public class ArrayListExam01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
//		list.add(2,30);  에러발생
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
//		list.add(50);
//		list.add(50);
//		list.add(50);
//		list.add(50);
//		list.add(50);
//		list.add(50);
//		list.add(50);
		
		System.out.println("현재 데이터 수:" + list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번쨰 데이터: " + list.get(i));
		}
		System.out.println();
//		
//		list.add(2,25);
//		System.out.println("현재 데이터 수:" + list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(i + "번쨰 데이터: " + list.get(i));
//		}
//		System.out.println();
		
		
		System.out.println("-------------------");
		System.out.println(list.remove(3));
		
		System.out.println("현재 데이터 수:" + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번쨰 데이터: " + list.get(i));
		}
		System.out.println();
		
//		try {
//			list.get(0);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		list.removeAll();
		System.out.println("현재 데이터 수:" + list.size());
	
	System.out.println("---------------------------------");
	Iterator<Integer> it = list.iterator();
	
	while(it.hasNext()) {
		System.out.println("들어감");

//		System.out.println(i);
	}
	System.out.println();
	
//	for(int i : list) {
//		System.out.println(i);
//	}
	
	
	}
}
