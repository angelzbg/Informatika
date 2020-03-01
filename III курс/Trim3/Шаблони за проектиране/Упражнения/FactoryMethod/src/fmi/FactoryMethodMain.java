package fmi;

public class FactoryMethodMain {

	public static void main(String[] args) {

		CheeseFactory cheeseFactory = new CheeseFactory();
		FarmProduct goatCheese = cheeseFactory.produceProduct("GoatCheese");
		FarmProduct cowCheese = cheeseFactory.produceProduct("CowCheese");

		MilkFactory milkFactory = new MilkFactory();
		FarmProduct goatMilk = milkFactory.produceProduct("GoatMilk");
		FarmProduct cowMilk = milkFactory.produceProduct("CowMilk");

	}
}