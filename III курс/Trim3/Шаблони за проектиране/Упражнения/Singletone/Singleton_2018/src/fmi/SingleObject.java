package fmi;

public class SingleObject {
	
	private static SingleObject instance = new SingleObject();
	
	// Private constructor so 
	// that this cannot be instantiated
	private SingleObject(){}
	
	public static SingleObject getInstance(){
		return instance;
	}
	
	public void printMessage(){
		System.out.println("I am a singleton");
	}
}
