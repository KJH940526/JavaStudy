package ch7;

import java.util.Vector;

class Product{
	int price;
	int bounsPoint;
	
	Product(int price){
		this.price = price;
		bounsPoint = (int)(price/10.0);
	}
	
	Product(){
		price = 0;
		bounsPoint = 0;
	}
}

class TV extends Product{
	TV(){
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100);	//Tv의 가격을 100만원으로 한다.
	}
	
	public String toString() { //Object클래스의 toString()을 오버라이딩한다.
		return "TV";
	}
}

class Computer extends Product{
	Computer(){
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(200);	//Tv의 가격을 100만원으로 한다.
	}
	
	public String toString() { //Object클래스의 toString()을 오버라이딩한다.
		return "Computer";
	}
}

class HandPhone extends Product{
	HandPhone(){
		super(150);
	}
	
	public String toString() {
		return "HandPhone";
	}
}

class Buyer{
	int money = 1000; //소유금액
	int bounsPoint = 0; //보너스 점수
	Vector item = new Vector();			   //추가
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;				//가진 돈에서 구입한 제품의 가격을 뺸다.
		bounsPoint += p.bounsPoint;		// 제품의 보너스 점수를 추가한다.
		item.add(p);					//구입한 제품을 Vector에 저장한다            //추가
		System.out.println(p+"을/를 구입하였습니다."); //p는 toString이 생략되었다.
	}
	
	//추가
	void refund(Product p) {
		if(item.remove(p)) {		//제품을 Vector에서 제거한다.
			money += p.price;
			bounsPoint -= p.bounsPoint;
			System.out.println(p+ "을/를 반품하셨습니다.");
		} else {
			System.out.println("구입한신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";		//구입한 물품목록
		
		if(item.isEmpty()) {		//Vector가 비어있는지 확인한다.
			System.out.println("구입한신 제품이 없습니다.");
			return;
		}
		
		//반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0; i< item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
		    itemList += (i==0) ? ""+p : ", "+p;
		}
		 System.out.println("구입하신 상품의 촘 금액은 "+sum+"만원입니다");
		 System.out.println("구입하신 제품은 "+ itemList+"입니다");
	}
}


class PolyArgumentTest{
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		TV tv = new TV();
		Computer com = new Computer();
		HandPhone hand = new HandPhone();
		
		b.buy(tv);
		b.buy(com);
		b.buy(hand);
		b.summary();
		System.out.println();
		
		b.refund(com);
		b.summary();
		
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 보너스점수는 " + b.bounsPoint +"점입니다.");
		
	}
}

/* Product의 세분화 */
/* 제품 등록(입고), 재고 조회, 판매 집계 기능 */