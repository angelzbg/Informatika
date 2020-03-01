package fmi;

public class VisitorMain {

	public static void main(String[] args) {
	
		ItemElement[] items = new ItemElement[]{
			new Book(20, "id2221"),
			new Book(60, "id5633"),
			new Fruit(5,3,"Bananas"),
			new Fruit(4,6, "Apples")
		};

		calculatePrice(items);
	}
	private static int calculatePrice(ItemElement[] items){
		int sum = 0;
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		for(ItemElement item : items){
			sum = sum + item.accept(visitor);
		}
		System.out.println("Overall price is: " + sum);
		return sum;
	}

}
