package dataS1;


public interface List<E> {
	
	void add(E elemnet);			//����Ʈ�� �����͸� �߰��Ѵ�. (�� �ڿ�)

	void add(int index, E element); //������ ��ġ�� �����͸� �߰��Ѵ�. 
	
	E get(int index );				//������ ��ġ�� ������ ��ȯ

	E remove(int index);			//������ ��ġ�� �׸��� ���� �Ѵ�. ( ���� ������ ��ȯ )
	
	void removeAll();				//��ü �׸��� �����Ѵ�.
	
	int size();						//����Ʈ�� �׸� ���� ��ȯ
		
}

