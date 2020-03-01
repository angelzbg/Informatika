package fmi;

public class MilkFactory extends FarmFactory {

	@Override
	public FarmProduct createProduct(String name) {

		FarmProduct product = null;

		if (name.equalsIgnoreCase("GoatMilk")) {
			product = new GoatCheese();
			product.setPrice(1.40);
		} else if (name.equalsIgnoreCase("CowMilk")) {
			product = new CowMilk();
			product.setPrice(1.20);
		} else {
			System.out.println("Our Milk factory cannot produce " + name + " milk");
		}

		return product;
	}
}