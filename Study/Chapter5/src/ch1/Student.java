package ch1;
//��ü �������α׷��ְ� Ŭ����
//��ü ���� ���α׷��ֿ����� ��� �����͸� ��ü(object)�� ����ϸ�, �̷��� ��ü�� �ٷ� ���α׷����� �߽��� �˴ϴ�.
//��ü ���� ���α׷��� => ��ü�� ���� , ��ü�� ��� ����, ��ü ������ ���� ����

//Ŭ������? ��ü�� ���� �Ӽ��� ����� �ڵ�� ���� �Ѱ� 
//��ü�� �Ӽ�
//��ü�� Ư��, �Ӽ�, ��� ����
//property, attribute, member variable

//��ü�� ���
//��ü�� �ϴ� ��ɵ��� �޼���� ����
//method, member function

//Ŭ���� ����  => �Ӽ��� ��������� �����, ��ɵ��� �޼���� �����. ex)�л� Ŭ������ ��// �Ӽ�: �й�,�̸� ��� // ���: ������û, ����, ���� ���

//�ϳ��� java ���Ͽ� �ϳ��� Ŭ������ �δ� ���� ��ġ�̳�, ���� ���� Ŭ������ ���� �ִ� ��� public Ŭ������ �� �ϳ��̸�,
//public Ŭ������ �ڹ� ������ �̸��� �����ؾ� ��

public class Student {
		int studentID;
		String studentName;
		int grade;
		String address;
		
		public void showStudnetInfo() {
			System.out.println(studentName + "," + address);
		}
	
//		//���� �Լ��� �ִ� ������ �����Ѵ�.
//		public static void main(String[] args) {
//			Student studentLee = new Student();
//			studentLee.studentName = "�̼���";
//			studentLee.address = "�����";
//			
//			studentLee.showStudnetInfo();
//			
//		}
		
		//ch2 �Ĺ�
		//�̸��� �ܺο��ٰ� �˷��ִ� �޼��� // �ܺο��� ���̴°� ����� ���� get��� �Ѵ�. ����
				//String�� ��ȯ�� => studentName�� ��Ʈ�� Ÿ���̱� ����
		public String getStudnetName() {
			return studentName;
		};
		
			//��ȯ���� ����			//�Ű������� String
		public void setStudnetName(String name) {
			studentName = name;
		}
		
}
