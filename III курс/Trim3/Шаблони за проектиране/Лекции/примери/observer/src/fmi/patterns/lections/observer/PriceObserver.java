/**
 * Пример за шаблона Наблюдател към дисциплината "Шаблони за проектиране"
 */
package fmi.patterns.lections.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Наблюдател на промяна на цената
 */
public class PriceObserver implements Observer {
	private float price;

	public PriceObserver() {
		price = 0;
		System.out.println("PriceObserver created: Price is " + price);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obj, Object arg) {
		if (arg instanceof Float) {
			price = ((Float) arg).floatValue();
			System.out.println("PriceObserver: Price changed to " + price);
		} else {
			System.out.println("PriceObserver: Some other change to	subject!");
		}
	}
}


