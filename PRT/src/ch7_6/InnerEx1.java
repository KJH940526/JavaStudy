package ch7_6;

class InnerEx1 {
	class InstanceInner { // �ν��Ͻ� Ŭ����
		int iv = 100;
//		static int cv =100;					//����! static ������ ������ �� ����.
		final static int CONST = 100; // final static�� ����̹Ƿ� ����Ѵ�.
	}

	static class StaticInner {
		int iv = 200;
		static int cv = 200; // static Ŭ������ static����� ������ �� �ִ�.
	}

	void myMethod() {
		class LocalInner {
			int iv = 300;
//			static int cv =300;					//����! static ������ ������ �� ����.
			final static int CONST = 300; // final static�� ����̹Ƿ� ����Ѵ�.
		}
	}

	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}

	
	
	
	// �ν��Ͻ���� ������ ���� ���� ������ �����ϴ�.
	// ����ƽ ��� ������ ���� ���� ������ �����ϴ�
	
	// ����ƽ ����� �ν��Ͻ������ ���� ������ �� ����.
	// �����ҷ��� ��ü�� �����ؾ� �Ѵ�.
	// �ν��Ͻ�Ŭ������ �ܺ� Ŭ������ ���� �����ؾ߸� ������ �� �ִ�.
	
	
	// �ν��Ͻ��޼��忡�� �ν��Ͻ������ ����ƽ��� ��� ���� �����ϴ�.
	// �޼��� ���� ���������� ����� ���� Ŭ������ �ܺο��� ���� �� �� ����.
}