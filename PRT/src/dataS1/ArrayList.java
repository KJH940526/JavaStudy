package dataS1;

//������ ���콺 Ŭ�� -> �ҽ� -> �������̵�
public class ArrayList<E> implements List<E> {

	private int size;
	private E[] data;
	
	public ArrayList() {
		this.size = 0;
		resize();
	};
	
	private void resize() {
		if(size == 0) {									//����� 0�̸� �����ڿ��� �ҷ�����
			data = (E[]) new Object[10];				//����� 0 -> �迭x => ���ο� �迭�� �����.
			System.out.println("�迭 ����");				// ���׸�Ÿ������ �迭�� ����� ��� : objectŸ������ �迭�� ����� ����ȯ����
			
		} else {										 //������� add�� ������ add �޼ҵ忡�� �ҷ��´�.
			E[] newData = (E[]) new Object[size + 10];   //���� �迭���� ����� ū �迭�� ����
			System.out.println("�迭 ũ�� ����");
			System.arraycopy(data, 0, newData, 0, size); //���ο� �迭�� ���� �迭�� �����Ѵ�.
			data = newData;								 //���� �迭 ��ſ� ���ο� �迭�� �ִ´�.
		}									
	}
	
	@Override
	public void add(E elemnet) {
		// TODO Auto-generated method stub
		if(data.length == size) { //�������� ����� ������ Ÿ���� ���̿� ������ ������� �ҷ��´�.
			resize();
		}
		
		data[size++] = elemnet;
		
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		try {
			return data[index];
		} catch (Exception e) {
			e.printStackTrace();
//			resize();
			return null;
		}
		finally {
			System.out.println("��");
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	
}
