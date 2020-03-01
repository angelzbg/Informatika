package fmi;

public class DecoratorMain {

	public static void main(String[] args) {
		
		Car lada = new Lada();
		System.out.println("\nCreating default lada");
		lada.create();

		Car blueLada = new BlueCarDecorator(new Lada());
		System.out.println("\nCreating blue lada");
		blueLada.create();
		
		Car blueLambo = new BlueCarDecorator(new Lamborghini());
		System.out.println("\nCreating blue lambo");
		blueLambo.create();
		
	}

}
