package ch7_9_1;

import java.awt.Button;
import java.awt.event.*;

public class InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("시작");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("액션 발생");
				}
			}
		);	//익명 클래스의 끝
	}	//메인 메서드의 끝

}	//이터ex8클래스의 끝


//bin 폴더에 가면 클래스가 2개 있는데 익명클래스가 있다. 익명클래스는 순번에 따라서 생성되는데 여기서는 InnerEx8$1 이라고 표시된다.