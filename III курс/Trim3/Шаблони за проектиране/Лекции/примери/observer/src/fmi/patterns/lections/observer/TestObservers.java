/**
 * Пример за шаблона Наблюдател към дисциплината "Шаблони за проектиране"
 */
package fmi.patterns.lections.observer;

/**
 * Тестова програма за ConcreteSubject, NameObserver и PriceObserver
 */
public class TestObservers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Създаване на Subject и Observers.
		ConcreteSubject s = new ConcreteSubject("Пуканки", 1.29f);
		NameObserver nameObs = new NameObserver();
		PriceObserver priceObs = new PriceObserver();
		
		// Добавяне на наблюдателите!
		s.addObserver(nameObs);
		s.addObserver(priceObs);
		
		// Промяна в subject.
		s.setName("Печени ядки");
		s.setPrice(4.57f);
		s.setPrice(9.22f);
		s.setName("Тиквени семки");
	}
}

