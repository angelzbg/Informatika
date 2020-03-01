package fmi;

public abstract class FarmFactory {

	public abstract FarmProduct createProduct(String name);

	public FarmProduct produceProduct(String name) {
		FarmProduct product = createProduct(name);
		product.prepare();
		return product;
	}
}