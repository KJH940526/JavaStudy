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
//	new Student("ȫ�浿", 95,80),
//	new Student("��浿", 95,80)
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
//								//��Ʈ���ڰ� �ΰ��ͼ� ��Ʈ�� ��ȯ�ϴ� �������̽�
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
			new Student2("ȫ�浿", "����", 45),
			new Student2("ȫ�椤", "����", 40),
			new Student2("ȫ�浿", "����", 45),
			new Student2("ȫ�浿", "����", 60)
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
		
		double maleAvg = avg(t-> t.getSex().equals("����"));
		System.out.println("���� �������: " + maleAvg);
		
		double femaleAvg = avg(t-> t.getSex().equals("����"));
		System.out.println("���� �������: " + femaleAvg);
		System.out.println("-------------------------");
		//----------------------------------------------------
		
		
		//��Ʈ���̳��� ���۷���Ʈ
//		int max = maxOrMin((a,b) -> {
//			if(a>=b)
//				return a;
//			else
//				return b;
//		});
//		
//		System.out.println("�ִ밪: "+ max);
//		
//		int min = maxOrMin((a,b) -> {
//			if(a<=b)
//				return a;
//			else
//				return b;
//		});
//		System.out.println("�ּҰ�: " + min);
//		System.out.println("-----------------------");
		
		//-------------------------------------------------------------
		SimpleInterface s = new SimpleClass();
		System.out.println(s.sum(10, 20));

		
		//�͸� ���� Ŭ����
		s = new SimpleInterface() {
			
			@Override
			public int sum(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
//		
		System.out.println(s.sum(100, 200));
		
		//���ٽ� �������̽��� �޼ҵ尡 �ϳ�!!! �̱⋚���� �̸��� �ʿ���� 
		//  �Ű�����2�� �ް� �������� a+b�� �ش�. ����Ÿ�Ե� �� �޴´� �ڵ����� ��
		// �߻�޼ҵ尡 �ϳ��� �������̽��� ���ٽ��� ����� �� ����
		s = (x,y) -> x+y;
		
		System.out.println(s.sum(7, 8));
//		
//		
//		// �ڹ�8 ���� java.utll.function ��Ű���� ���� ���Ǵ� �Լ��� �������̽��� ǥ�� API�� �����Ǵ� �������̴� �Ʒ��� ���� 4����
//		
//		// Consumer : �Ű����� �հ� ���ϰ��� ����
		Consumer<String> consumer = t -> System.out.println(t + "class");
		consumer.accept("Java");
		
		BiConsumer<String, String> biConsumer = (t,u) -> System.out.println(t + u);
		biConsumer.accept("Java", "Class");
		
		DoubleConsumer doubleConsumer = d -> System.out.println(d +
				"�� 10���� ���� �������� " + d % 10 + "�Դϴ�.");
		doubleConsumer.accept(14.0);
		
		//�տ��� �Ű������� ������Ʈ �ڿ��� ������ intŸ���� �޴´�. ���⼭�� ��Ʈ�� ������Ʈ�� �Ű������� �޾Ҵ�.
		ObjIntConsumer<String> objIntConsumer = (t,i) -> System.out.println(t + i);
		objIntConsumer.accept("Java", 8);
		
		//Supplier - �Ķ���ʹ� ����, ���� ���� ����
		//�Ķ���ʹ� ���� ����Ÿ���� int�̴�
		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random()*6)+1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("�ֻ��� ��: "+ num);
		
		
//		// printString
//		System.out.println("[�л��̸�]");
//		printString(t -> t.getName());
//		
//		System.out.println("[��������]");
//		printInt(t -> t.getEnglishScore());
//		
//		System.out.println("[��������]");
//		printInt(t -> t.getMathScore());
		

		

		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}
