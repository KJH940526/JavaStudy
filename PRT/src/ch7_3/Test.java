package ch7_3;


class Car{
		
}

class FireEngine extends Car{

}
public class Test {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if( fe instanceof FireEngine ) {
			System.out.println("실행");
		}
		
		if( fe instanceof Car ) {
			System.out.println("실행");
		}
		
		if( fe instanceof Object ) {
			System.out.println("실행");
		}
		
		System.out.println(fe.getClass().getName());
		
		
	}

}
