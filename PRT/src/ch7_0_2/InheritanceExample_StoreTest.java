package ch7_0_2;

import java.util.Vector;

class Product {
   int price;
   int bonusPoint;
   int count = 0;
   
   Product(int price){
      this.price = price;
      bonusPoint = (int)(price/10.0);
   }
   
   Product(){
      price = 0;
      bonusPoint = 0;
   }
}

class Electronic extends Product{
   int watt;
   String color;
   
   Electronic(int watt, String color){
      this.watt = watt;
      this.color = color;
   }
}

class Furniture extends Product{
   int size;
   String material;
   
   Furniture(int size, String material){
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
   Computer(){
      super(220, "white");
      price = 300;
   }
   
   public String toString() {
      return "Computer";
   }
}

class Bed extends Furniture{
   Bed(){
      super(1000, "Wood");
      price = 100;
   }
   
   public String toString() {
      return "Bed";
   }
}

class Table extends Furniture {
   Table(){
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
   
   void buy(Product p, Store s) {
      if(money < p.price) {
         System.out.println("잔액이 부족해 물건을 살 수없습니다");
         return;
      }
      if(p.count == 0) {
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
      
      System.out.println(p+"을/를 구입하셨습니다"); // p.toString이 생략된것!
   }
   
   void refund(Product p, Store s) { // 제품 환불
      if(item.remove(p)) {
         money += p.price;
         bonusPoint -= p.bonusPoint;
         
         // 판매자 실적 차감, list 수정
         s.sum -= p.price;
         s.items.add(p);
         
         p.count++; // 재고 확보
         
         System.out.println(p+"을/를 반품하셨습니다.");
      } else {
         System.out.println("구입하신 제품 중 해당 상품이 없습니다.");
      }
   }
   
   void summary() {
      int sum = 0;
      String itemList = "";
      
      if(item.isEmpty()) {
         System.out.println("구입한 제품이 없습니다.");
         return;
      }
      
      for(int i = 0 ; i < item.size() ; i++) {
         Product p = (Product)item.get(i);
         sum += p.price;
         itemList += (i==0) ? ""+p : ", "+p;
      }
      System.out.println("구입하신 상품의 촘 금액은 "+sum+"만원입니다");
      System.out.println("구입하신 제품은 "+ itemList+"입니다");
   }
}

class Store { // 판매자
   Vector items = new Vector(); // 상품 목록
   int sum = 0;
   
   void stock(Product p) { // 제품 입고
      items.add(p);
      p.count++;
   }
   
   void searchProduct() { // 제품 조회
      String itemsList = "";
      
      for(int i = 0 ; i<items.size(); i++) {
         Product p = (Product)items.get(i);
         itemsList += (i==0)? ""+p : ", "+p;
      }
      System.out.println("현재 재고에 있는 상품은 ["+itemsList+"] 입니다");
   }
   
   void sumOfSale() {
      System.out.println("총 판매 금액은 "+sum+"원 입니다.");
   }
}

/* 제품 등록(입고), 재고 조회, 판매 집계 기능 <= 판매자 class 추가 */

public class InheritanceExample_StoreTest {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Buyer b1 = new Buyer();
      Store s1 = new Store();

      Tv tv1 = new Tv();
      Computer com1 = new Computer();
      Bed bed1 = new Bed();
      Table tab1 = new Table();
      
      s1.stock(tv1);
      s1.stock(bed1);
      s1.stock(bed1);
      s1.stock(tv1);
      s1.stock(tab1);
      s1.stock(com1);
      s1.stock(tab1);
      s1.stock(tv1);
      s1.stock(com1);
      s1.stock(com1);
      s1.stock(bed1);
      s1.stock(tab1);
      
      
      s1.searchProduct();
      
      b1.buy(tv1, s1);
      b1.buy(com1, s1);
      b1.buy(tab1, s1);
      b1.buy(tab1, s1);
      b1.buy(tab1, s1);
      b1.buy(tab1, s1);
      s1.sumOfSale();
      b1.refund(com1, s1);
      b1.summary();
      s1.searchProduct();
      s1.sumOfSale();
      
   }

}

