package ch3;

public class StudentTest {

	//main �Լ��� Ŭ�����ȿ� ������ �޼���� �ƴϴ�.
	public static void main(String[] args) {
		
		//������ �⺻�ڷ����̶� �����ڷ������� ������.
		//�⺻ �ڷ���(��üx)
		int i = 10;  
		
		//��üŸ��                     //new�� �Ἥ �����ڸ� ȣ���ؾ���
		Student studentLee = new Student(100,"�̼���");		//heap �޸𸮿� ������
		//���������� ������// studenLee�� . ������ �����Ҽ� �ִ� ������ ��Ÿ��
		studentLee.address = "�����";
		
		Student studentKim = new Student();
		studentKim.studentName = "�����";
		studentKim.studentID = 100;
		studentKim.address = "������";
		
		studentLee.showStudnetInfo();
		studentKim.showStudnetInfo();
		
		System.out.println(studentKim); //ch3.Student@15db9742 �̷������� �����µ� ch3�� ��Ű���̰� Student�� ����
		System.out.println(studentLee); //16������ ǥ���Ǵµ� 16������ �� 4����Ʈ�� ������ 32��Ʈ�� �ּҸ� ������.
										//heap�޸� ������ �ּҰ��̴�.
		
		// Ŭ���� => ��ü�� ���α׷����ϱ� ���� �ڵ�� ���� ����
		// �ν��Ͻ� => Ŭ������ �޸𸮿� ������ ����
		// ������� => Ŭ������ �Ӽ�, Ư��
		// �޼��� => ��� ������ �̿��Ͽ� Ŭ������ ����� ����
		// �������� => �޸𸮿� ������ �ν��Ͻ��� ����Ű�� ����
		// ���� �� => ������ �ν��Ͻ��� �޸� �ּ� ��
		

	}
}

