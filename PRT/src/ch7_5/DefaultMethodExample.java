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
		System.out.println("잉크젯 프린터");
	}
	
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("잉크젯 프린터 취소");
	}
}

class LaserPrinter implements IPrinterable{
	@Override
	public void print() {
		System.out.println("레이저 프린터");
		
		//디폴트 메소드로 만들었기 떄문에... 에러가 안생김
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
