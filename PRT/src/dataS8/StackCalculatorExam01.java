package dataS8;

public class StackCalculatorExam01 {
	public static void main(String[] args) {
		

//		StackCalculator cal = new StackCalculator("(1*2+3)/4");
//		StackCalculator cal = new StackCalculator("(1+2*3)/4");
		
		StackCalculator cal = new StackCalculator("(1+2)*(3/4)+(5+(6-7))"); // 12+34/*567-++
		System.out.println("�����׽�Ʈ");
													
		System.out.println(cal.infixToPostfix());
	}

}
