package ch1;
//this�� �ϴ� ��
// �ڽ��� �޸𸮸� ����Ŵ
// �����ڿ��� �ٸ� �����ڸ� ȣ��
// �ڽ��� �ּҸ� ��ȯ ��

class Birthday{
	int day;
	int month;
	int year;
	
	// ��Ŭ�������� ��� ������ �Ķ������� ǥ�õȴ�.
	public void setYear(int year) {
		//�ڽ��� �޸𸮸� ����Ű�� this
		this.year = year;
		// year = year;  //�̷������� �ڵ带 ¥�� ������� year�� �ƴ϶� �������� year�� �Ű������� �ִ� �ǹ̾��� �ڵ�
		// year = y 	// �׻� �ڱ⿡�� ����� ���� �ν��ϱ� ������ this�� �� ������ �̷����̸� �ٲٰ� �Ű������� y�� �ٲ۴�.     
	}
	public void printThis() {
		System.out.println(this);
	}
}

	//�����ڿ��� �ٸ� �����ڸ� ȣ���ϴ� this
	

public class ThisExample {
	public static void main(String[] args) {
		
		Birthday b1 = new Birthday();
		Birthday b2 = new Birthday();
		
		System.out.println(b1); 
		b1.printThis();          //���� �޸� �ּҰ� ���� => �ڽ��� �޷θ��� ����Ű�� this�� ����߱� ����
		
		System.out.println(b2);
		b2.printThis(); 
		


		
		
		
	}

	//�ڽ��� �޸𸮸� ����Ű�� this => �������� �ν��Ͻ� �����θ� ����Ű�� �����
}
