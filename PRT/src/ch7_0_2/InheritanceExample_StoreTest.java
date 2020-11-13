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
   public String toString() { // �ֻ��� Ŭ������ ObjectŬ������ toString() �޼ҵ� �������̵�
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
         System.out.println("�ܾ��� ������ ������ �� �������ϴ�");
         return;
      }
      if(p.count == 0) {
         System.out.println("�Ǹ� ��ǰ�� ��� ������ ���Ű� �Ұ����մϴ�.");
         return;
      }
      
      money -= p.price;
      bonusPoint += p.bonusPoint;
      item.add(p);
      
      // �Ǹ��� ���� �߰�, list ����
      s.sum += p.price;
      s.items.remove(p);
      
      p.count--; // ��� ����
      
      System.out.println(p+"��/�� �����ϼ̽��ϴ�"); // p.toString�� �����Ȱ�!
   }
   
   void refund(Product p, Store s) { // ��ǰ ȯ��
      if(item.remove(p)) {
         money += p.price;
         bonusPoint -= p.bonusPoint;
         
         // �Ǹ��� ���� ����, list ����
         s.sum -= p.price;
         s.items.add(p);
         
         p.count++; // ��� Ȯ��
         
         System.out.println(p+"��/�� ��ǰ�ϼ̽��ϴ�.");
      } else {
         System.out.println("�����Ͻ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
      }
   }
   
   void summary() {
      int sum = 0;
      String itemList = "";
      
      if(item.isEmpty()) {
         System.out.println("������ ��ǰ�� �����ϴ�.");
         return;
      }
      
      for(int i = 0 ; i < item.size() ; i++) {
         Product p = (Product)item.get(i);
         sum += p.price;
         itemList += (i==0) ? ""+p : ", "+p;
      }
      System.out.println("�����Ͻ� ��ǰ�� �� �ݾ��� "+sum+"�����Դϴ�");
      System.out.println("�����Ͻ� ��ǰ�� "+ itemList+"�Դϴ�");
   }
}

class Store { // �Ǹ���
   Vector items = new Vector(); // ��ǰ ���
   int sum = 0;
   
   void stock(Product p) { // ��ǰ �԰�
      items.add(p);
      p.count++;
   }
   
   void searchProduct() { // ��ǰ ��ȸ
      String itemsList = "";
      
      for(int i = 0 ; i<items.size(); i++) {
         Product p = (Product)items.get(i);
         itemsList += (i==0)? ""+p : ", "+p;
      }
      System.out.println("���� ��� �ִ� ��ǰ�� ["+itemsList+"] �Դϴ�");
   }
   
   void sumOfSale() {
      System.out.println("�� �Ǹ� �ݾ��� "+sum+"�� �Դϴ�.");
   }
}

/* ��ǰ ���(�԰�), ��� ��ȸ, �Ǹ� ���� ��� <= �Ǹ��� class �߰� */

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

