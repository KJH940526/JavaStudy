package ch7_5;

interface IPrinterable{
	public void print();
	public default void cancel() {
		System.out.println("Printer Cancel");
	};
}

class InkJetPrinter implements IPrinterable{
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("��ũ�� ������");
	}
	
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("��ũ�� ������ ���");
	}
}

class LaserPrinter implements IPrinterable{
	@Override
	public void print() {
		System.out.println("������ ������");
		
		//����Ʈ �޼ҵ�� ������� ������... ������ �Ȼ���
		//cancel Method No Override!! But No Error!!
	}
}

public class DefaultMethodExample {
	public static void main(String[] args) {
		IPrinterable printer = null;
		
		printer = new InkJetPrinter();
		printer.print();
		printer.cancel();
		
		printer = new LaserPrinter();
		printer.print();
		printer.cancel();
		
	}
}
