package ch7_2;

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("�θ�~");
	}
	
	void stop() {
		System.out.println("��ž!!!");
	}
}

class FireEngine extends Car{
	void water() {
		System.out.println("�� �ѷ�!!");
	}
}



public class CastingTest {
	public static void main(String[] args) {
		Car car = null;							//��ü ���� x
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; //car = (Car)fe; ���� ����ȯ�� ������ �����̴�.  		Car car = new FireEngine(); //��ĳ����

//		car.water();		//�ȵǴ� ������ �θ𿡼��� �ڽ����� �� �Ѿ
		fe2 = (FireEngine)car; //�ڼ�Ÿ�� <- ����Ÿ��			//�ٿ�ĳ����
		fe2.water();
	}

}
