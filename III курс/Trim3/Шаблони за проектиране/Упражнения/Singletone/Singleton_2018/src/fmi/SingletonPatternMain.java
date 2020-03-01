package fmi;

public class SingletonPatternMain {

	public static void main(String[] args) {

		SingleObject object = SingleObject.getInstance();
		object.printMessage();

		// Cannot be done
		// SingleObject object = new SingleObject();
	}

}
