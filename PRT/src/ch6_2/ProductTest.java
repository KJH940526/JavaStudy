package ch6_2;

class Product{
	static int count = 0 ; //������ �ν��Ͻ��� ���� �����ϱ� ���� ����
	int serialNo;			//�ν��Ͻ� ������ ��ȣ
	
	{						//�ν��Ͻ� �ʱ�ȭ ���
		++count;
		serialNo = count;
	}
	
	public Product() {}
	
	
}

public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println(p1.serialNo);
		System.out.println(p2.serialNo);
		System.out.println(p3.serialNo);
		System.out.println();
		System.out.println(p1.count);
		System.out.println(p2.count);
		System.out.println(p3.count);
		
	}
}
