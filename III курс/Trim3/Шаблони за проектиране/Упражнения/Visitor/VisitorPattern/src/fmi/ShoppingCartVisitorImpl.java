package fmi;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{

	public int visit(Book book){
		int cost = 0;
		cost = book.getPrice();
		if(cost > 50){
			cost = cost - 5;
		}
		System.out.println(
				"Visiting Book> "+ book.getIsbnNumber() +
				" price is: " + cost);
		return cost;
	}
	
	public int visit(Fruit fruit){
		int cost = 0;
		cost = fruit.getWeight() * fruit.getPricePerKg();
		System.out.println(
				"Visiting Fruit> "+ fruit.getName() +
				" price is: " + cost);
		return cost;
	}
	
}
