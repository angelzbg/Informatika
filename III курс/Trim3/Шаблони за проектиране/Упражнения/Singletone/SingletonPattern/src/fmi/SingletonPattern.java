package fmi;

public class SingletonPattern {

	private static SingletonPattern myObj;
	
	public static SingletonPattern getInstance(){
		if(myObj == null){
			myObj = new SingletonPattern();
		}
		return myObj;
	}
	
	public void printSomething(String message){
		System.out.println(message);
	}
	
	public static void main(String a[]){
		SingletonPattern st = SingletonPattern.getInstance();
		st.printSomething("I am a singleton instance");
	}
}
