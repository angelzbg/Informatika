package uni.fmi.informatics;

public class SingleObject {
	
	private static SingleObject instance;
	
	public int number = 10;
	
	private SingleObject() {
	}
	
	public static SingleObject getInstance(){
		if(instance == null)
			instance = new SingleObject();
		
		return instance;
	}
	
	public void ShowMessage(){
		System.out.println("This is a message");
	}
	

}
