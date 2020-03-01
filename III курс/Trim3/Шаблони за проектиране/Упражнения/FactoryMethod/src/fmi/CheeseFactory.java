package fmi;


public class CheeseFactory extends FarmFactory {

	@Override
	public FarmProduct createProduct(String name) {

		FarmProduct product = null;

		if (name.equalsIgnoreCase("GoatCheese")) {
			product = new GoatCheese();
			product.setPrice(3.50);
		} else if (name.equalsIgnoreCase("CowCheese")) {
			product = new CowCheese();
			product.setPrice(3.20);
		} else {
			System.out.println("Our Cheese factory cannot produce " + name + " cheese");
		}

		return product;
	}
}