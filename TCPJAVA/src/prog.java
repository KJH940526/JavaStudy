class Car {
	private String modelName;
	private int modelYear = 10;
	private String color = "����";
	private int maxSpeed;
	private int currentSpeed;
	
	Car(){};
	
	Car(String modelName, int modelYear, String color, int maxSpeed) {
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.currentSpeed = 0;
	}
	
	public String getModel() {
		return this.modelYear + "��� " + this.modelName + " " + this.color;
	}
}

public class prog {
	public static void main(String[] args) {
		Car myCar = new Car();					// �⺻ �������� ȣ��
		// Car myCar = new Car("�ƹݶ�", 2016, "���", 200);	// �������� ȣ��
		
		System.out.println(myCar.getModel());	// �����ڿ� ���� �ʱ�ȭ�Ǿ������� Ȯ����.
	}
}