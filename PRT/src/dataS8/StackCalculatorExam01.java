package dataS8;

public class StackCalculatorExam01 {
	public static void main(String[] args) {
		

//		StackCalculator cal = new StackCalculator("(1*2+3)/4");
		StackCalculator cal = new StackCalculator("(1+2*3)");
		
//		StackCalculator cal = new StackCalculator("(1+2)*(3/4)+(5+(6-7))"); // 12+34/*567-++
		
//		StackCalculator cal = new StackCalculator("324*+");
													
		System.out.println(cal.infixToPostfix());
		System.out.println(cal.CalculateUsingStack());
		
//		Integer a = 1;
//		int b = 2;
//		Integer c = a-b;
//		int d = a-b;
//		
//		System.out.println(int.class.getName());
//		System.out.println(int.class.getClass().getName());
//		System.out.println(c.getClass().getName());
//		System.out.println(a-b);
	}

}
