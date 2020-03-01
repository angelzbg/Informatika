/**
 * Пример за шаблона Наблюдател към дисциплината "Шаблони за проектиране"
 */
package fmi.patterns.lections.observer;

import java.util.Observable;

/**
 * Някакъв subject за наблюдаване 
 */
public class ConcreteSubject extends Observable {
	private String name;
	private float price;

	public ConcreteSubject(String name, float price) {
		this.name = name;
		this.price = price;
		System.out.println("ConcreteSubject created: " + name + " at " + price);
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}

	public void setPrice(float price) {
		this.price = price;
		setChanged();
		notifyObservers(new Float(price));
	}
}
