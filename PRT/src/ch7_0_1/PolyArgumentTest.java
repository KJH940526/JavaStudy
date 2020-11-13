package ch7_0_1;



import java.util.Vector;

class Product{
	int price;
	int bounsPoint;
	int count = 0;    //ī��Ʈ ���ٲ�
	
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
		// ����Ŭ������ ������ Product(int price)�� ȣ���Ѵ�.
		super(100);	//Tv�� ������ 100�������� �Ѵ�.
	}
	
	public String toString() { //ObjectŬ������ toString()�� �������̵��Ѵ�.
		return "TV";
	}
}

class Computer extends Product{
	Computer(){
		// ����Ŭ������ ������ Product(int price)�� ȣ���Ѵ�.
		super(200);	//Tv�� ������ 100�������� �Ѵ�.
	}
	
	public String toString() { //ObjectŬ������ toString()�� �������̵��Ѵ�.
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
	int money = 1000; //�����ݾ�
	int bounsPoint = 0; //���ʽ� ����
	Vector item = new Vector();			   //�߰�
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		
		money -= p.price;				//���� ������ ������ ��ǰ�� ������ �A��.
		bounsPoint += p.bounsPoint;		// ��ǰ�� ���ʽ� ������ �߰��Ѵ�.
		item.add(p);					//������ ��ǰ�� Vector�� �����Ѵ�            //�߰�
		System.out.println(p+"��/�� �����Ͽ����ϴ�."); //p�� toString�� �����Ǿ���.
	}
	
	//�߰�
	void refund(Product p) {
		if(item.remove(p)) {		//��ǰ�� Vector���� �����Ѵ�.
			money += p.price;
			bounsPoint -= p.bounsPoint;
			System.out.println(p+ "��/�� ��ǰ�ϼ̽��ϴ�.");
		} else {
			System.out.println("�����ѽ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
		}
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";		//������ ��ǰ���
		
		if(item.isEmpty()) {		//Vector�� ����ִ��� Ȯ���Ѵ�.
			System.out.println("�����ѽ� ��ǰ�� �����ϴ�.");
			return;
		}
		
		//�ݺ����� �̿��ؼ� ������ ��ǰ�� �� ���ݰ� ����� �����.
		for(int i=0; i< item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
		    itemList += (i==0) ? ""+p : ", "+p;
		}
		 System.out.println("�����Ͻ� ��ǰ�� �� �ݾ��� "+sum+"�����Դϴ�");
		 System.out.println("�����Ͻ� ��ǰ�� "+ itemList+"�Դϴ�");
	}
}

class Store{
	Buyer buyer = new Buyer();
	Vector sNItem = new Vector();    //��ǰ ���(New)
//	Vector sItem = new Vector();	 //��ǰ ��ȸ(Look up)  => ���� ������ �迭�� �������� �Ǳ� ������ �ʿ����
	Vector sSItem = new Vector();	// �Ǹ� ����(sale)
	
	int sMoney = 0;
	String Tv = "TV";						
	String Com = "Computer";
	String Phone = "HandPhone";
	
	int cTV = 0;					//�Ǹż���
	int cComputer = 0;
	int cHandPhone = 0;
	
	void sale(Product p) {
		sSItem.add(p);			//�Ǹ� ��ũ�� �ø���
		if(buyer.money < p.price) {
			System.out.println("��ǰ�� ���ݺ��� �������� ���� �����ϴ�.");
			return;
		}
		

		sNItem.remove(p);		//��ǰ ��ȸ���� ���ְ�
		
		sMoney += p.price;     //��ǰ�� ���ݸ�ŭ ������ ���� �߰��Ѵ�.
		

		System.out.println(p+"��/�� �Ǹ��Ͽ����ϴ�. ���Ǹ� �ݾ��� " + sMoney +"�Դϴ�." );
		System.out.println("�Ǹ� ���� "+sSItem);
		System.out.println("��ǰ ��ȸ "+sNItem);
	}
	
	void newP(Product p) {
		sNItem.add(p);
	}
	
	void lookUp() {
		System.out.println("LookUp "+sNItem);
	}
	
}

class PolyArgumentTest{
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		Store s = new Store();  //�Ǹ���
		
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
		System.out.println("���� ���� ���� " + b.money + "�����Դϴ�.");
		System.out.println("���� ���ʽ������� " + b.bounsPoint +"���Դϴ�.");
		
		System.out.println("-------------------------");
		
		s.newP(tv);
		s.newP(com);
		s.newP(hand);	//���
		s.lookUp();		//��ȸ
		System.out.println();
		s.sale(tv);
		s.sale(com);

		
	}
}
