package ch7_0_3;

import java.util.*;

class Product {
	int price;
	int bonusPoint;
	int count = 0;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}

	Product() {
		price = 0;
		bonusPoint = 0;
	}
}

class Electronic extends Product {
	int watt;
	String color;

	Electronic(int watt, String color) {
		this.watt = watt;
		this.color = color;
	}
}

class Furniture extends Product {
	int size;
	String material;

	Furniture(int size, String material) {
		this.size = size;
		this.material = material;
	}
}

class Tv extends Electronic {
	Tv() {
		super(110, "Balck");
		price = 500;
	}

	public String toString() { // 최상위 클래스인 Object클래스의 toString() 메소드 오버라이딩
		return "Tv";
	}
}

class Computer extends Electronic {
	Computer() {
		super(220, "white");
		price = 300;
	}

	public String toString() {
		return "Computer";
	}
}

class Bed extends Furniture {
	Bed() {
		super(1000, "Wood");
		price = 100;
	}

	public String toString() {
		return "Bed";
	}
}

class Table extends Furniture {
	Table() {
		super(500, "Marble");
		price = 50;
	}

	public String toString() {
		return "Table";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();
	String itemList = "";
	Product p;

	void buy(int selectBuyProduct, Store s) {
		switch (selectBuyProduct) {
		case 1:
			p = s.tv;
			break;
		case 2:
			p = s.com;
			break;
		case 3:
			p = s.bed;
			break;
		default:
			p = s.tab;
			break;
		}

		if (money < p.price) {
			System.out.println("잔액이 부족해 물건을 살 수없습니다");
			return;
		}
		if (p.count == 0) {
			System.out.println("판매 상품의 재고가 부족해 구매가 불가능합니다.");
			return;
		}

		money -= p.price;
		bonusPoint += p.bonusPoint;
		item.add(p);

		// 판매자 실적 추가, list 수정
		s.sum += p.price;
		s.items.remove(p);

		p.count--; // 재고 소진

		System.out.println(p + "을/를 구입하셨습니다"); // p.toString이 생략된것!
	}

	void refund(int selectRefundProduct, Store s) { // 제품 환불
		Product p;

		switch (selectRefundProduct) {
		case 1:
			p = s.tv;
			break;
		case 2:
			p = s.com;
			break;
		case 3:
			p = s.bed;
			break;
		default:
			p = s.tab;
			break;
		}

		if (item.remove(p)) { // 이미 여기서 p가 s.tv인지 다 걸러짐 스위치문에서
			money += p.price;
			bonusPoint -= p.bonusPoint;

			// 판매자 실적 차감, list 수정
			s.sum -= p.price;
			s.items.add(p);

			p.count++; // 재고 확보

			System.out.println(p + "을/를 반품하셨습니다.");
		} else {
			System.out.println("구입하신 제품 중 해당 상품이 없습니다.");
		}
	}

	void summary() {
		int sum = 0;

		if (item.isEmpty()) {
			System.out.println("구입한 제품이 없습니다.");
			return;
		}

		for (int i = 0; i < item.size(); i++) {
			Product p = (Product) item.get(i); // 타입 캐스팅
			sum += p.price;
			itemList += (i == 0) ? "" + p : ", " + p; // 이부분 잘 모르겠음
		}
		System.out.println("구입하신 상품의 촘 금액은 " + sum + "만원입니다");
		System.out.println("구입하신 제품은 " + itemList + "입니다");
	}
}

class Store { // 판매자
	Vector items = new Vector(); // 상품 목록
	int sum = 0;
	Product p;

	Tv tv = new Tv();
	Computer com = new Computer();
	Bed bed = new Bed();
	Table tab = new Table();

	void stock(int selectStockProduct) { // 제품 입고
		switch (selectStockProduct) {
		case 1:
			p = tv;
			break;
		case 2:
			p = com;
			break;
		case 3:
			p = bed;
			break;
		default:
			p = tab;
			break;
		}
		items.add(p);
		p.count++;
	}

	void searchProduct() { // 제품 조회
		String itemsList = "";

		for (int i = 0; i < items.size(); i++) {
			Product p = (Product) items.get(i);
			itemsList += (i == 0) ? "" + p : ", " + p;
		}
		System.out.println("현재 재고에 있는 상품은 [" + itemsList + "] 입니다");
	}

	void sumOfSale() {
		System.out.println("총 판매 금액은 " + sum + "만원 입니다.");
	}
}

/* 제품 등록(입고), 재고 조회, 판매 집계 기능 <= 판매자 class 추가 */

public class InheritanceExample_StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b1 = new Buyer();
		Store s1 = new Store();

		int select = 0;

		Scanner scanner = new Scanner(System.in);

		while (select != 7) { // 7이 아니면 반복 -> 7이면 반복 끝

			System.out.println("1.제품 입고 2.재고 조회 3.총 판매금액 4.상품구매 5.상품환불 6.구매내역 7.기능 종료");
			System.out.print("기능을 선택해주세요 :");
			select = scanner.nextInt();

			switch (select) {
			case 1:
				System.out.println("1.Tv 2.Computer 3.Bed 4.Table");
				System.out.print("입고할 제품의 종류를 선택해주세요 :");
				int selectStockProduct = scanner.nextInt();
				s1.stock(selectStockProduct);
				break;
			case 2:
				s1.searchProduct();
				break;
			case 3:
				s1.sumOfSale();
				break;
			case 4:
				System.out.println("1.Tv 2.Computer 3.Bed 4.Table");
				System.out.print("구매하고자하는 상품의 종류를 선택해주세요 :");
				int selectBuyProduct = scanner.nextInt();
				b1.buy(selectBuyProduct, s1);
				break;
			case 5:
				System.out.println(b1.itemList);
				System.out.println("1.Tv 2.Computer 3.Bed 4.Table");
				System.out.print("환불하고자하는 상품의 종류를 선택해주세요 :");
				int selectRefundProduct = scanner.nextInt();
				b1.refund(selectRefundProduct, s1);
				break;
			case 6:
				b1.summary();
				break;
			case 7:
				System.out.println("기능을 종료합니다");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			System.out.println();
		}
	}
}