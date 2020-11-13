package ch7_2;

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("부릉~");
	}
	
	void stop() {
		System.out.println("스탑!!!");
	}
}

class FireEngine extends Car{
	void water() {
		System.out.println("물 뿌려!!");
	}
}



public class CastingTest {
	public static void main(String[] args) {
		Car car = null;							//객체 생성 x
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; //car = (Car)fe; 에서 형변환이 생략된 형태이다.  		Car car = new FireEngine(); //업캐스팅

//		car.water();		//안되는 이유는 부모에서는 자식으로 못 넘어감
		fe2 = (FireEngine)car; //자손타입 <- 조상타입			//다운캐스팅
		fe2.water();
	}

}
