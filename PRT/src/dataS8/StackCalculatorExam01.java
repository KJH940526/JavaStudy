package dataS8;

public class StackCalculatorExam01 {
	public static void main(String[] args) {
		StackCalculator cal = new StackCalculator("3+2*4");     //324*+
//		StackCalculator cal = new StackCalculator("2*4+3");		//24*3+
//		StackCalculator cal = new StackCalculator("2*1+3/2");	// 3.5 //21*32/+
//		StackCalculator cal = new StackCalculator("2*2/3");
//		StackCalculator cal = new StackCalculator("(1*2+3)/4");
//		StackCalculator cal = new StackCalculator("(1+2*3)/4");
																			
//		StackCalculator cal = new StackCalculator("(1+2)*(3/4)+(5+(6-7))"); // 12+34/*567-++
													
		System.out.println(cal.infixToPostfix());
	}

}
