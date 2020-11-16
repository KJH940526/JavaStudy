package dataS2;

public class LinkedListExam01 {
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println("현재 데이터 수: " + list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 데이터: " + list.get(i));
		}
		System.out.println("Add-----------------------------");
		
		list.add(3,25);
		System.out.println("현재 데이터 수: " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 데이터: " + list.get(i));
		}
		System.out.println();
		System.out.println("Remove-----------------------------");
		list.remove(3);
		System.out.println("현재 데이터 수: " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 데이터: " + list.get(i));
		}
		System.out.println();
		
//		list.removeAll();
		System.out.println("현재 데이터 수: " + list.size());
		
	}
	

}
