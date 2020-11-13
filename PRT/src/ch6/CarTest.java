package ch6;

class Car {
	String color;
	String gearType;
	int door; 
	
	Car(){};
	Car(String c, String g, int d){
		color = c;
		gearType = g;
		door = d;
	}
}

public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();       //기본생성자 호출에서 객체생성
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		
		Car c2 = new Car("white","auto",3); //오버로딩한 생성자
		
		System.out.println("c1의 색상 "+c1.color+" c1의 타입"+c1.gearType+" c1의 문"+c1.door);
		System.out.println("c2의 색상 "+c2.color+" c2의 타입"+c2.gearType+" c2의 문"+c2.door);
	}
}
