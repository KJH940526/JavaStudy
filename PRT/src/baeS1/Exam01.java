package baeS1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class Exam01 {
	
//	private static List<Student> list = Arrays.asList(
//	new Student("홍길동", 95,80),
//	new Student("김길동", 95,80)
//);
//	public static void printString(Function<Student, String> function) {
//		for(Student student: list) {
//			System.out.println(function.apply(student)+" ");
//		}
//		System.out.println();
//	};
//	
//	
//	
//	public static void printInt(ToIntFunction<Student> function) {
//		for(Student student: list) {
//			System.out.println(function.applyAsInt(student)+" ");
//		}
//		System.out.println();	
//	};
	
	//-----------------------------------------------------------------
	
//	private static int [] scores = {94,96,86};
//	
//								//인트인자가 두개와서 인트를 반환하는 인터페이스
//	public static int  maxOrMin(IntBinaryOperator operator) {
//		int result = scores[0];
//		for (int socre : scores) {
//			result = operator.applyAsInt(result, socre);
//		}
//		return result;
//	}
//	
	//-------------------------------------
	private static List<Student2> list = Arrays.asList(
			new Student2("홍길동", "남자", 45),
			new Student2("홍길ㄴ", "여자", 40),
			new Student2("홍길동", "남자", 45),
			new Student2("홍길동", "남자", 60)
		);
	
	
	public static double avg(Predicate<Student2> predicate) {
		int count = 0, sum =0;
		for(Student2 student: list) {
			if(predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		return (double) sum /count;
	}
//	
	public static void main(String[] args) {
		
		double maleAvg = avg(t-> t.getSex().equals("남자"));
		System.out.println("남자 평균점수: " + maleAvg);
		
		double femaleAvg = avg(t-> t.getSex().equals("여자"));
		System.out.println("여자 평균점수: " + femaleAvg);
		System.out.println("-------------------------");
		//----------------------------------------------------
		
		
		//인트바이나리 오퍼레이트
//		int max = maxOrMin((a,b) -> {
//			if(a>=b)
//				return a;
//			else
//				return b;
//		});
//		
//		System.out.println("최대값: "+ max);
//		
//		int min = maxOrMin((a,b) -> {
//			if(a<=b)
//				return a;
//			else
//				return b;
//		});
//		System.out.println("최소값: " + min);
//		System.out.println("-----------------------");
		
		//-------------------------------------------------------------
		SimpleInterface s = new SimpleClass();
		System.out.println(s.sum(10, 20));

		
		//익명 구현 클래스
		s = new SimpleInterface() {
			
			@Override
			public int sum(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
//		
		System.out.println(s.sum(100, 200));
		
		//람다식 인터페이스의 메소드가 하나!!! 이기떄문에 이름도 필요없고 
		//  매개변수2개 받고 리턴으로 a+b를 준다. 리턴타입도 안 받는다 자동으로 됨
		// 추상메소드가 하나인 인터페이스만 람다식을 사용할 수 있음
		s = (x,y) -> x+y;
		
		System.out.println(s.sum(7, 8));
//		
//		
//		// 자바8 부터 java.utll.function 패키지에 자주 사용되는 함수적 인터페이스를 표준 API로 제공되는 인터페이는 아래와 같은 4가지
//		
//		// Consumer : 매개값은 잇고 리턴값이 없음
		Consumer<String> consumer = t -> System.out.println(t + "class");
		consumer.accept("Java");
		
		BiConsumer<String, String> biConsumer = (t,u) -> System.out.println(t + u);
		biConsumer.accept("Java", "Class");
		
		DoubleConsumer doubleConsumer = d -> System.out.println(d +
				"를 10으로 나눈 나머지는 " + d % 10 + "입니다.");
		doubleConsumer.accept(14.0);
		
		//앞에는 매개변수는 오브젝트 뒤에는 무조건 int타입을 받는다. 여기서는 스트링 오브젝트를 매개변수로 받았다.
		ObjIntConsumer<String> objIntConsumer = (t,i) -> System.out.println(t + i);
		objIntConsumer.accept("Java", 8);
		
		//Supplier - 파라미터는 없고, 리턴 값은 있음
		//파라미터는 없고 리턴타입이 int이다
		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random()*6)+1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("주사위 눈: "+ num);
		
		
//		// printString
//		System.out.println("[학생이름]");
//		printString(t -> t.getName());
//		
//		System.out.println("[영어점수]");
//		printInt(t -> t.getEnglishScore());
//		
//		System.out.println("[수학점수]");
//		printInt(t -> t.getMathScore());
		

		

		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}
