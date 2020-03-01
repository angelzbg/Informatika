/**
 * ������ �� ������� ���������� ��� ������������ "������� �� �����������"
 */
package fmi.patterns.lections.observer;

/**
 * ������� �������� �� ConcreteSubject, NameObserver � PriceObserver
 */
public class TestObservers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������� �� Subject � Observers.
		ConcreteSubject s = new ConcreteSubject("�������", 1.29f);
		NameObserver nameObs = new NameObserver();
		PriceObserver priceObs = new PriceObserver();
		
		// �������� �� �������������!
		s.addObserver(nameObs);
		s.addObserver(priceObs);
		
		// ������� � subject.
		s.setName("������ ����");
		s.setPrice(4.57f);
		s.setPrice(9.22f);
		s.setName("������� �����");
	}
}

