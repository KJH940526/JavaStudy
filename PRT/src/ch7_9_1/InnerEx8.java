package ch7_9_1;

import java.awt.Button;
import java.awt.event.*;

public class InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("����");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("�׼� �߻�");
				}
			}
		);	//�͸� Ŭ������ ��
	}	//���� �޼����� ��

}	//����ex8Ŭ������ ��


//bin ������ ���� Ŭ������ 2�� �ִµ� �͸�Ŭ������ �ִ�. �͸�Ŭ������ ������ ���� �����Ǵµ� ���⼭�� InnerEx8$1 �̶�� ǥ�õȴ�.