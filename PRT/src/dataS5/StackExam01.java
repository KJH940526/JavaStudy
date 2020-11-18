package dataS5;

public class StackExam01 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push("hello0");
		stack.push("hello1");
		stack.push("hello2");
		stack.push("hello3");
		stack.push("hello4");
		
		while(!stack.empty()) {
			String s = stack.pop();
			System.out.println(s);
		}
		
		System.out.println("==========================");
		
		stack = new Stack<String>();
		stack.push("hello0");
		
		System.out.println(stack.pop());
//		System.out.println(stack.pop());    //하나만 넣었으니깐 위에서 새로만들고
		
	}

}
